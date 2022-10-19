(ns klafim.library
  (:require [klafim.catalog :as cat]))


(def catalog-state (atom {}))

(defn add-book! [book]
  (swap! catalog-state (fn [catalog]
                         (cat/add-book catalog book))))

(defn search-books [query]
  (cat/search @catalog-state query))

(defn all-books []
  (vals (:books @catalog-state)))
(comment
  (search-books "Watch")
  (add-book! {:isbn "978-1779501127"
              :title "Watchmen"
              :authors [{:first-name "Alan"
                         :last-name "Moore"}
                        {:first-name "Dave"
                         :last-name "Gibbons"}]}))
