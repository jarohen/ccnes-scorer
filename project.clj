(defproject ccnes "no-version"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.csv "0.1.2"]
                 [org.clojure/tools.nrepl "0.2.3"]

                 [jarohen/nomad "0.4.1"]

                 [ring "1.2.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]

                 [jayq "2.4.0"]
                 [prismatic/dommy "0.1.1"]]

  :source-paths ["src/clojure"]
  :resource-paths ["resources" "target/resources"]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {:builds [{:source-paths ["src/cljs"],
                        :compiler {:pretty-print true,
                                   :output-to "target/resources/js/main.js",
                                   :optimizations :whitespace}}
                       {:id "prod"
                        :source-paths ["src/cljs"],
                        :compiler {:output-to "target/resources/js/main.js",
                                   :optimizations :advanced
                                   :externs ["resources/cljs-externs/jQuery.js"]}}]}

  :main ccnes.main

  :aliases {"start" ["trampoline" "run"]})
