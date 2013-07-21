(ns ccnes.app
  (:require [dommy.core :as d]
            [jayq.core :as jq]
            [jayq.util :refer [log wait]]
            [ccnes.questions :refer [questions]])
  (:require-macros [dommy.macros :refer [node sel1]]
                   [jayq.macros :refer [ready]]))

(def possible-scores
  (map inc (range 7)))

(defn header-node []
  (node
   [:h3 {:style {:margin-top :2em}}
    "CCNES Scorer:"]))

(defn decode-key [key-code]
  ((set possible-scores) (int (js/String.fromCharCode key-code))))

(defn respond-to-keyboard [controls]
  (doseq [[number question] controls
          [part sub-question] question
          [score control] sub-question]
    (d/listen! control :keypress
               (fn [e]
                 (when-let [selected-score (-> (.-keyCode e)
                                               decode-key)]
                   (.click (jq/$ (get sub-question selected-score))))))))

(defn index-controls [controls]
  (for [[number question] controls
        [part sub-question] question]
    {:number number
     :part part
     :controls (sort-by key sub-question)}))

(defn on-select-focus-next [controls]
  (doseq [[{:keys [controls]} next-part] (->> (index-controls controls)
                                              (sort-by (juxt :number :part))
                                              (partition 2 1))
          :let [next-control (-> next-part :controls first val)
                handler #(.focus next-control)]
          [_ control] controls]
    (d/listen! control :click handler)))

(defn focus-first-question! [controls]
  (let [first-question (get-in controls [1 "a" 1])]
    (.focus first-question)))

(defn questions-controls []
  (doto (into {}
              (for [{:keys [number sub-questions]} questions]
                [number
                 (into {}
                       (for [{:keys [part]} sub-questions]
                         [part
                          (into {}
                                (for [score possible-scores]
                                  [score
                                   (node
                                    [:input {:name (str "question" number part)
                                             :type "radio"
                                             :value score}])]))]))]))
    respond-to-keyboard
    on-select-focus-next))

(defn sub-question-node [{:keys [statement part]} controls]
  [:div.subquestion
   [:div.sq-statement (format "%s) %s" part  statement)]
   [:div.scores
    [:table
     [:tr
      (for [score possible-scores]
        [:td score])]
     [:tr
      (for [score possible-scores]
        [:td (get controls score)])]]]])

(defn question-node [{:keys [sub-questions number statement]} controls]
  (node
   [:div.question
    [:div.q-statement (str number ". " statement)]
    (for [{:keys [part] :as sub-question} sub-questions]
      (sub-question-node sub-question (get controls part)))]))

(defn questions-node [controls]
  (node
   (for [{:keys [number] :as question} questions]
     (question-node question (get controls number)))))

(ready
 (let [controls (questions-controls)]
   (d/replace-contents! (sel1 :#main) (node (list
                                             (header-node)
                                             (questions-node controls))))
   (focus-first-question! controls)))
