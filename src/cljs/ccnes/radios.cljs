(ns ccnes.radios
  (:require [ccnes.questions :refer [questions possible-scores]]
            [dommy.core :as d]
            [jayq.core :as jq]
            [jayq.util :refer [wait]])
  (:require-macros [dommy.macros :refer [node sel1]]))

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
        [part controls] question]
    {:number number
     :part part
     :controls controls}))

(defn on-select-focus-next [controls]
  (doseq [[{:keys [controls]} next-part] (->> (index-controls controls)
                                              (sort-by (juxt :number :part))
                                              (partition 2 1))
          :let [next-control (->> next-part :controls (sort-by key) first val)
                handler #(.focus next-control)]
          [_ control] controls]
    (d/listen! control :click handler)))

(defn focus-first-question! [controls]
  (let [first-question (get-in controls [1 "a" 1])]
    (wait 500
          #(.focus first-question))))

(defn make-controls []
  (into {}
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
                                       :value score}])]))]))])))

(defn questions-controls []
  (doto (make-controls)
    respond-to-keyboard
    on-select-focus-next))

(defn get-answer [controls number part]
  (first
   (for [[score control] (get-in controls [number part])
         :when (jq/prop (jq/$ control) :checked)]
     score)))

(defn read-answers [controls]
  (for [{:keys [number sub-questions] :as question} questions]
    (assoc question
      :sub-questions (for [{:keys [part] :as sub-question} sub-questions]
                       (assoc sub-question
                         :answer (get-answer controls number part))))))


