(defproject ccnes "no-version"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.csv "0.1.2"]
                 [org.clojure/tools.nrepl "0.2.3"]

                 [jarohen/nomad "0.4.1"]

                 [ring "1.2.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]]

  :source-paths ["src/clojure"]
  :resource-paths ["resources" "target/resources"]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {:builds [{:source-paths ["src/cljs"],
                        :compiler {:pretty-print true,
                                   :output-to "target/resources/js/main.js",
                                   :optimisations :whitespace}}]}

  :main ccnes.main)
