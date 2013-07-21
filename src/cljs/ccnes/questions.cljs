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
    :statement "If my child becomes angry because he/she is sick or hurt and can't go to his/her friend's birthday party, I would:"
    :sub-questions [{:part "a"
                     :statement "send my child to his/her room to cool off"
                     :sub-scale :pr}
                    {:part "b"
                     :statement "get angry at my child"
                     :sub-scale :dr}
                    {:part "c"
                     :statement "help my child think about ways that he/she can still be with friends (e.g., invite some friends over after the party)"
                     :sub-scale :pfr}
                    {:part "d"
                     :statement "tell my child not to make a big deal out of missing the party"
                     :sub-scale :mr}
                    {:part "e"
                     :statement "encourage my child to express his/her feelings of anger and frustration"
                     :sub-scale :ee}
                    {:part "f"
                     :statement "soothe my child and do something fun with him/her to make him/her feel better about missing the party"
                     :sub-scale :efr}]}
   {:number 2
    :statement "If my child falls off his/her bike and breaks it, and then gets upset and cries, I would:"
    :sub-questions [{:part "a"
                     :statement "remain calm and not let myself get anxious"
                     :sub-scale :dr
                     :reversed? true}
                    {:part "b"
                     :statement "comfort my child and try to get him/her to forget about the accident"
                     :sub-scale :efr}
                    {:part "c"
                     :statement "tell my child that he/she is over-reacting"
                     :sub-scale :mr}
                    {:part "d"
                     :statement "help my child figure out how to get the bike fixed"
                     :sub-scale :pfr}
                    {:part "e"
                     :statement "tell my child it's OK to cry"
                     :sub-scale :ee}
                    {:part "f"
                     :statement "tell my child to stop crying or he/she won't be allowed to ride his/her bike anytime soon"
                     :sub-scale :pr}]}
   {:number 3
    :statement "If my child loses some prized possession and reacts with tears, I would:"
    :sub-questions [{:part "a"
                     :statement "get upset with him/her for being so careless and then crying about it"
                     :sub-scale :dr}
                    {:part "b"
                     :statement "tell my child that he/she is over-reacting"
                     :sub-scale :mr}
                    {:part "c"
                     :statement "help my child think of places he/she hasn't looked yet"
                     :sub-scale :pfr}
                    {:part "d"
                     :statement "distract my child by talking about happy things"
                     :sub-scale :efr}
                    {:part "e"
                     :statement "tell him/her it's OK to cry when you feel unhappy"
                     :sub-scale :ee}
                    {:part "f"
                     :statement "tell him/her that's what happens when you're not careful"
                     :sub-scale :pr}]}
   {:number 4
    :statement "If my child is afraid of injections and becomes quite shaky and teary while waiting for his/her turn to get a shot, I would:"
    :sub-questions [{:part "a"
                     :statement "tell him/her to shape up or he/she won't be allowed to do something he/she likes to do (e.g., watch TV)"
                     :sub-scale :pr}
                    {:part "b"
                     :statement "encourage my child to talk about his/her fears"
                     :sub-scale :ee}
                    {:part "c"
                     :statement "tell my child not to make big deal of the shot"
                     :sub-scale :mr}
                    {:part "d"
                     :statement "tell him/her not to embarrass us by crying"
                     :sub-scale :dr}
                    {:part "e"
                     :statement "comfort him/her before and after the shot"
                     :sub-scale :efr}
                    {:part "f"
                     :statement "talk to my child about ways to make it hurt less (such as relaxing so it won't hurt or taking deep breaths)."
                     :sub-scale :pfr}]}
   {:number 5
    :statement "If my child is going over to spend the afternoon at a friend's house and becomes nervous and upset because I can't stay there with him/her, I would:"
    :sub-questions [{:part "a"
                     :statement "distract my child by talking about all the fun he/she will have with his/her friend"
                     :sub-scale :efr}
                    {:part "b"
                     :statement "help my child think of things that he/she could do so that being at the friend's house without me wasn't scary (e.g., take a favorite book or toy with him/her)"
                     :sub-scale :pfr}
                    {:part "c"
                     :statement "tell my child to quit over-reacting and being a baby"
                     :sub-scale :mr}
                    {:part "d"
                     :statement "tell the child that if he/she doesn't stop that he/she won't be allowed to go out anymore"
                     :sub-scale :pr}
                    {:part "e"
                     :statement "feel upset and uncomfortable because of my child's reactions"
                     :sub-scale :dr}
                    {:part "f"
                     :statement "encourage my child to talk about his/her nervous feelings"
                     :sub-scale :ee}]}
   {:number 6
    :statement "If my child is participating in some group activity with his/her friends and proceeds to make a mistake and then looks embarrassed and on the verge of tears, I would:"
    :sub-questions [{:part "a"
                     :statement "comfort my child and try to make him/her feel better"
                     :sub-scale :efr}
                    {:part "b"
                     :statement "tell my child that he/she is over-reacting"
                     :sub-scale :mr}
                    {:part "c"
                     :statement "feel uncomfortable and embarrassed myself"
                     :sub-scale :dr}
                    {:part "d"
                     :statement "tell my child to straighten up or we'll go home right away"
                     :sub-scale :pr}
                    {:part "e"
                     :statement "encourage my child to talk about his/her feelings of embarrassment"
                     :sub-scale :ee}
                    {:part "f"
                     :statement "tell my child that I'll help him/her practice so that he/she can do better next time"
                     :sub-scale :pfr}]}
   {:number 7
    :statement "If my child is about to appear in a recital or sports activity and becomes visibly nervous about people watching him/her, I would:"
    :sub-questions [{:part "a"
                     :statement "help my child think of things that he/she could do to get ready for his/her turn (e.g., to do some warm-ups and not to look at the audience)"
                     :sub-scale :pfr}
                    {:part "b"
                     :statement "suggest that my child think about something relaxing so that his/her nervousness will go away"
                     :sub-scale :efr}
                    {:part "c"
                     :statement "remain calm and not get nervous myself"
                     :sub-scale :dr
                     :reversed? true}
                    {:part "d"
                     :statement "tell my child that he/she is being a baby about it"
                     :sub-scale :mr}
                    {:part "e"
                     :statement "tell my child that if he/she doesn't calm down, we'll have to leave and go home right away"
                     :sub-scale :pr}
                    {:part "f"
                     :statement "encourage my child to talk about his/her nervous feelings"
                     :sub-scale :ee}]}
   {:number 8
    :statement "If my child receives an undesirable birthday gift from a friend and looks obviously disappointed, even annoyed, after opening it in the presence of the friend, I would:"
    :sub-questions [{:part "a"
                     :statement "encourage my child to express his/her disappointed feelings"
                     :sub-scale :ee}
                    {:part "b"
                     :statement "tell my child that the present can be exchanged for something the child wants"
                     :sub-scale :pfr}
                    {:part "c"
                     :statement "NOT be annoyed with my child for being rude"
                     :sub-scale :dr
                     :reversed? true}
                    {:part "d"
                     :statement "tell my child that he/she is over-reacting"
                     :sub-scale :mr}
                    {:part "e"
                     :statement "scold my child for being insensitive to the friend's feelings"
                     :sub-scale :pr}
                    {:part "f"
                     :statement "try to get my child to feel better by doing something fun"
                     :sub-scale :efr}]}
   {:number 9
    :statement "If my child is panicky and can't go to sleep after watching a scary TV show, I would:"
    :sub-questions [{:part "a"
                     :statement "encourage my child to talk about what scared him/her"
                     :sub-scale :ee}
                    {:part "b"
                     :statement "get upset with him/her for being silly"
                     :sub-scale :dr}
                    {:part "c"
                     :statement "tell my child that he/she is over-reacting"
                     :sub-scale :mr}
                    {:part "d"
                     :statement "help my child think of something to do so that he/she can get to sleep (e.g., take a toy to bed, leave the lights on)"
                     :sub-scale :pfr}
                    {:part "e"
                     :statement "tell him/her to go to bed or he/she won't be allowed to watch any more TV"
                     :sub-scale :pr}
                    {:part "f"
                     :statement "do something fun with my child to help him/her forget about what scared him/her"
                     :sub-scale :efr}]}
   {:number 10
    :statement "If my child is at a park and appears on the verge of tears because the other children are mean to him/her and won't let him/her play with them, I would:"
    :sub-questions [{:part "a"
                     :statement "NOT get upset myself"
                     :sub-scale :dr
                     :reversed? true}
                    {:part "b"
                     :statement "tell my child that if he/she starts crying then we'll have to go home right away"
                     :sub-scale :pr}
                    {:part "c"
                     :statement "tell my child it's OK to cry when he/she feels bad"
                     :sub-scale :ee}
                    {:part "d"
                     :statement "comfort my child and try to get him/her to think about something happy"
                     :sub-scale :efr}
                    {:part "e"
                     :statement "help my child think of something else to do"
                     :sub-scale :pfr}
                    {:part "f"
                     :statement "tell my child that he/she will feel better soon"
                     :sub-scale :mr}]}
   {:number 11
    :statement "If my child is playing with other children and one of them calls him/her names, and my child then begins to tremble and become tearful, I would:"
    :sub-questions [{:part "a"
                     :statement "tell my child not to make a big deal out of it"
                     :sub-scale :mr}
                    {:part "b"
                     :statement "feel upset myself"
                     :sub-scale :dr}
                    {:part "c"
                     :statement "tell my child to behave or we'll have to go home right away"
                     :sub-scale :pr}
                    {:part "d"
                     :statement "help my child think of constructive things to do when other children tease him/her (e.g., find other things to do)"
                     :sub-scale :pfr}
                    {:part "e"
                     :statement "comfort him/her and play a game to take his/her mind off the upsetting even"
                     :sub-scale :efr}
                    {:part "f"
                     :statement "encourage him/her to talk about how it hurts to be teased"
                     :sub-scale :ee}]}
   {:number 12
    :statement "If my child is shy and scared around strangers and consistently becomes teary and wants to stay in his/her bedroom whenever family friends come to visit, I would:"
    :sub-questions [{:part "a"
                     :statement "help my child think of things to do that would make meeting my friends less scary (e.g., to take a favorite toy with him/her when meeting my friends)"
                     :sub-scale :pfr}
                    {:part "b"
                     :statement "tell my child that it is OK to feel nervous"
                     :sub-scale :ee}
                    {:part "c"
                     :statement "try to make my child happy by talking about the fun things we can do with our friends"
                     :sub-scale :efr}
                    {:part "d"
                     :statement "feel upset and uncomfortable because of my child's reactions"
                     :sub-scale :dr}
                    {:part "e"
                     :statement "tell my child that he/she must stay in the living room and visit with our friends"
                     :sub-scale :pr}
                    {:part "f"
                     :statement "tell my child that he/she is being a baby"
                     :sub-scale :mr}]}])
