(ns ccnes.questions)

(def possible-scores
  (map inc (range 7)))

(def sub-scale-order
  [:dr :pr :ee :efr :pfr :mr])

(def sub-scale-name
  {:dr "Distress Reactions (DR)"
   :pr "Punitive Reactions (PR)"
   :ee "Expressive Encouragement (EE)"
   :efr "Emotion-Focused Reactions (EFR)"
   :pfr "Problem-Focused Reactions (PFR)"
   :mr "Minimization Reactions (MR)"})

(def questions
  [{:number 1
    :statement "If my child becomes angry because he/she is sick or
    hurt and can't go to his/her friend's birthday party, I would:"
    :sub-questions [{:part "a"
                     :statement "send my child to his/her room to cool off"
                     :sub-scale :pr}
                    {:part "b"
                     :statement "get angry at my child"
                     :sub-scale :dr}]}
   {:number 2
    :statement "If my child falls off his/her bike and breaks it, and
    then gets upset and cries, I would:"
    :sub-questions [{:part "a"
                     :statement "remain calm and not let myself get anxious"
                     :sub-scale :dr
                     :reversed? true}
                    {:part "b"
                     :statement "comfort my child and try to get
                                 him/her to forget about the accident"
                     :sub-scale :efr}]}])
