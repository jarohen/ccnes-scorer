(ns ccnes.scorer)

(defn reverse-answer [answer]
  (- 8 answer))

(defn group-answers [answers]
  (reduce (fn [acc {:keys [sub-scale answer]}]
            (update-in acc [sub-scale] conj answer))
          {}
          answers))

(defn average-answers [grouped-answers]
  (for [[sub-scale answers] grouped-answers]
    {:sub-scale sub-scale
     :score (/ (apply + answers) (count answers))}))

(defn calculate-scores [answers]
  (->> (for [{:keys [number sub-questions]} answers
             {:keys [part sub-scale answer reversed?]} sub-questions]
         {:sub-scale sub-scale
          :answer (if reversed?
                    (reverse-answer answer)
                    answer)})
       group-answers
       average-answers))

(defn answers-missing [answers]
  (for [{:keys [number sub-questions]} answers
        {:keys [part answer]} sub-questions
        :when (nil? answer)]
    {:number number
     :part part}))

(defn bind-answers [answers scores]
  (add-watch answers ::scorer
             (fn [_ _ _ answers]
               (reset! scores
                       (doto (if-let [missing (seq (answers-missing answers))]
                               {:missing missing}
                               {:scores (calculate-scores answers)})
                         (-> pr-str js/console.log))))))
