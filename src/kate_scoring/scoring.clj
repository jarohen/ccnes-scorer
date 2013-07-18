(ns kate-scoring.scoring
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(def sub-scales
  [{:sub-scale :dr
    :questions ["1b" "2a" "3a" "4d" "5e" "6c" "7c" "8c" "9b" "10a" "11b" "12d"]}
   {:sub-scale :pr
    :questions ["1a" "2f" "3f" "4a" "5d" "6d" "7e" "8e" "9e" "10b" "11c" "12e"]}
   {:sub-scale :ee
    :questions ["1e" "2e" "3e" "4b" "5f" "6e" "7f" "8a" "9a" "10c" "11f" "12b"]}
   {:sub-scale :efr
    :questions ["1f" "2b" "3d" "4e" "5a" "6a" "7b" "8f" "9f" "10d" "11e" "12c"]}
   {:sub-scale :pfr
    :questions ["1c" "2d" "3c" "4f" "5b" "6f" "7a" "8b" "9d" "10e" "11d" "12a"]}
   {:sub-scale :mr
    :questions ["1d" "2c" "3b" "4c" "5c" "6b" "7d" "8d" "9c" "10f" "11a" "12f"]}])

(defn parse [survey]
  (map #(Integer/parseInt %) survey))

(def questions
  (for [number (map inc (range 12))
        letter [\a \b \c \d \e \f]]
    (str number letter)))

(defn survey->map [survey]
  (zipmap questions survey))

(defn load-csv-file [file-name]
  (with-open [r (io/reader file-name)]
    (doall (rest (csv/read-csv r
                               :separator \tab)))))

(defn map->scores [m]
  (for [{:keys [sub-scale questions]} sub-scales]
    {:sub-scale sub-scale
     :answers (map #(get m %) questions)}))

(defn round-2 [x]
  (/ (Math/round (* 100 x)) 100.0))

(defn average-answers [survey]
  (for [{:keys [sub-scale answers]} survey]
    {:sub-scale sub-scale
     :score (-> (apply + answers)
                (/ 12.0)
                round-2)}))

(comment
  (->> (load-csv-file "/tmp/results.csv")
       (map parse)
       (map survey->map)
       (map map->scores)
       (map average-answers)))
