(ns ccnes.scores-layout
  (:require [dommy.core :as d]
            [ccnes.questions :refer [sub-scale-name sub-scale-order]]
            [clojure.string :as s])
  (:require-macros [dommy.macros :refer [node]]))

(defn order-scores [scores]
  (let [order-fn (into {} (map vector sub-scale-order (range)))]
    (sort-by (comp order-fn :sub-scale) scores)))

(defn scores-node [scores]
  (let [{:keys [scores missing]} scores]
    (cond

     scores
     (node
      (list
       [:h4 "Scores:"]
       [:table {:style {:margin-bottom :2em}}
        (for [{:keys [sub-scale score]} (order-scores scores)]
          [:tr
           [:td
            [:b (sub-scale-name sub-scale)]
            ": "]
           [:td {:style {:padding-left :1em}}
            (format "%.2f" score)]])]))

     missing
     (node
      [:div {:style {:color :#b00}}
       [:h4 "Missing answers:"]
       [:p (s/join ", "
                   (for [{:keys [number part]} missing]
                     (str number part)))]]))))

(defn render-scores [scores scores-el]
  (d/replace-contents! scores-el (scores-node scores))
  (.scrollIntoView scores-el))

(defn bind-scores [scores scores-el]
  (add-watch scores ::layout
             (fn [_ _ _ scores]
               (render-scores scores scores-el))))
