(ns ccnes.questions-layout
  (:require [ccnes.questions :refer [questions possible-scores]]
            [dommy.core :as d])
  (:require-macros [dommy.macros :refer [node sel1]]))

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

