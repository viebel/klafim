(ns klafim.server
  (:require [cheshire.custom :refer [generate-string]]
            [klafim.library :refer [all-books search-books add-book!]]
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

(def catalog-state (atom {}))

(defn search-books-handler [{{{:keys [q]} :query} :parameters}]
  {:status 200
   :body (search-books catalog-state q)})

(def search-books-parameters-schema {:query [:map
                                             [:q {:json-schema/example "Wat"} :string]]})

(defn all-books-handler [_]
  {:status 200
   :body (all-books catalog-state)})

(defn add-book-handler [{{:keys [body]} :parameters}]
  (def body body)
  {:status 200
   :body (add-book! catalog-state body)})

(def author-schema [:map 
                    [:first-name :string]
                    [:last-name :string]])

(def add-book-parameters-schema {:body [:map {:json-schema/example {:isbn "978-1779501127"
                                                                    :title "Watchmen"
                                                                    :authors [{:first-name "Alan"
                                                                               :last-name "Moore"}
                                                                              {:first-name "Dave"
                                                                               :last-name "Gibbons"}]}}
                                        [:isbn :string]
                                        [:title :string]
                                        [:authors [:sequential author-schema]]]})
(defn ok-handler [_]
  {:status 200, :body "ok"})

(defn run []
  (run-server
   (ring/ring-handler
    (ring/router [["/" {:get ok-handler}]
                  ["/books" {:get all-books-handler
                             :post {:handler add-book-handler
                                    :parameters add-book-parameters-schema}}]
                  ["/search-books" {:get {:parameters search-books-parameters-schema
                                          :handler search-books-handler}}]
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

  (server)
  )