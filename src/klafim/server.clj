(ns klafim.server
  (:require [cheshire.custom :refer [generate-string]]
            [klafim.library :refer [all-books search-books]]
            [muuntaja.core :as m]
            [org.httpkit.server :refer [run-server]]
            [reitit.coercion.malli]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as coercion]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [reitit.ring.middleware.parameters :as parameters]
            jsonista.core
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]))

(defn search-books-handler [{{{:keys [q]} :query} :parameters}]
  {:status 200
   :body (search-books q)})

(def search-books-parameters-schema {:query [:map
                                             [:q {:json-schema/example "Wat"} :string]]})

(defn all-books-handler [_]
  {:status 200
   :body (all-books)})

(defn ok-handler [_]
  {:status 200, :body "ok"})

(defn run []
  (run-server
   (ring/ring-handler
    (ring/router [["/" {:get ok-handler}]
                  ["/books" {:get all-books-handler}]
                  ["/search-books" {:parameters search-books-parameters-schema
                                    :get {:handler search-books-handler}}]
                  ["" {:no-doc true}
                   ["/swagger.json" {:get (swagger/create-swagger-handler)}]
                   ["/docs/*" {:get (swagger-ui/create-swagger-ui-handler)}]]]
                 {:data {:coercion reitit.coercion.malli/coercion
                         :muuntaja m/instance
                         :middleware [;; query-params & form-params
                                      parameters/parameters-middleware
                                      ;; content-negotiation
                                      muuntaja/format-negotiate-middleware
                                      ;; encoding response body
                                      muuntaja/format-response-middleware
                                      ;; decoding request body
                                      muuntaja/format-request-middleware
                                     ;; coercing response bodys
                                      coercion/coerce-response-middleware
                                     ;; coercing request parameters
                                      coercion/coerce-request-middleware]}}))
   {:port 8888}))

(comment
  (def server (run))

  (server))