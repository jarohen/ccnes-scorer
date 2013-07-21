(ns ccnes.app
  (:require [dommy.core :as d]
            [jayq.core :as jq]
            [jayq.util :refer [log wait]]
            [ccnes.questions :refer [questions]]
            [ccnes.questions-layout :refer [questions-node]]
            [ccnes.scorer :refer [bind-answers]]
            [ccnes.scores-layout :refer [bind-scores]]
            [ccnes.radios :refer [questions-controls focus-first-question! read-answers]])
  (:require-macros [dommy.macros :refer [node sel1]]
                   [jayq.macros :refer [ready]]))

(defn header-node []
  (node
   [:h3 {:style {:margin-top :2em}}
    "CCNES Scorer:"]))

(defn score-button [click-handler]
  (doto (node
         [:div {:style {:margin-top :2em}}
          [:button "Score!"]])
    (d/listen! :click click-handler)))

(ready
 (let [controls (questions-controls)
       answers (atom nil)
       scores (atom nil)
       score-button-handler #(reset! answers (read-answers controls))
       scores-el (node [:div {:style {:margin-top :2em}}])]
   (d/replace-contents! (sel1 :#main) (node (list
                                             (header-node)
                                             (questions-node controls)
                                             (score-button score-button-handler)
                                             scores-el)))
   (focus-first-question! controls)
   (bind-answers answers scores)
   (bind-scores scores scores-el)))
