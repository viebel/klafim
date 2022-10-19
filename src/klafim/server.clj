(ns klafim.server
  (:require [cheshire.custom :refer [generate-string]]
            [klafim.library :refer [all-books search-books]]
            [org.httpkit.server :refer [run-server]]
            [reitit.coercion :as coercion]
            [reitit.coercion.malli]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as rrc]
            [reitit.ring.middleware.parameters :as parameters]))

(defn handler [_]
  {:status 200, :body "ok"})

(defn run []
  (run-server
   (ring/ring-handler
    (ring/router [["/" {:get handler}]
                  ["/books" {:get (fn [request]
                                    {:status 200
                                     :body (generate-string (all-books))})}]
                  ["/search-books" {:parameters {:query [:map [:q :string]]}
                                    :get {:handler (fn [{{{:keys [q]} :query} :parameters}]
                                                     {:status 200
                                                      :body (generate-string (search-books q))})}}]]
                 {:data {:coercion reitit.coercion.malli/coercion
                         :middleware [parameters/parameters-middleware
                                      rrc/coerce-exceptions-middleware
                                      rrc/coerce-request-middleware
                                      rrc/coerce-response-middleware]}}))
   {:port 8888}))

(comment
  (def server (run))

  (server))