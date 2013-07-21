(ns ccnes.main
  (:require [clojure.tools.nrepl.server :as nrepl]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.util.response :refer [response content-type]]
            [hiccup.page :refer [html5 include-js include-css]]
            [nomad :refer [defconfig]]
            [clojure.java.io :as io]
            [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [resources]]))

(defconfig config (io/resource "ccnes-config.edn"))

(defn skeleton []
  (html5
   [:head
    [:title "CCNES Scorer"]
    (include-js "//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js")
    (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css")
    (include-js "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js")
    (include-js "/js/main.js")
    (include-css "/css/questions.css")]
   [:body
    [:div#main.container "Hello world!"]]))

(defroutes handler
  (GET "/" []
       (-> (response (skeleton))
           (content-type "text/html;charset=UTF-8")))
  (resources "/js" {:root "js"})
  (resources "/css" {:root "css"}))

(defn -main []
  (when-let [nrepl-port (get-in (config) [:nrepl :port])]
    (nrepl/start-server :port nrepl-port)
    (println "Started nREPL: port" nrepl-port))
  (when-let [web-port (get-in (config) [:web :port])]
    (run-jetty #'handler {:port web-port :join? false})
    (println "Started web: port" web-port)))

