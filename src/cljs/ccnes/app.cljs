(ns ccnes.app
  (:require [dommy.core :as d]
            [jayq.core :as jq]
            [jayq.util :refer [log wait]]
            [ccnes.questions :refer [questions]]
            [ccnes.questions-layout :refer [questions-node]]
            [ccnes.radios :refer [questions-controls focus-first-question!]])
  (:require-macros [dommy.macros :refer [node sel1]]
                   [jayq.macros :refer [ready]]))

(defn header-node []
  (node
   [:h3 {:style {:margin-top :2em}}
    "CCNES Scorer:"]))

(ready
 (let [controls (questions-controls)]
   (d/replace-contents! (sel1 :#main) (node (list
                                             (header-node)
                                             (questions-node controls))))
   (focus-first-question! controls)))
