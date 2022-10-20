(ns klafim.library
  (:require [klafim.catalog :as cat]))

(defn add-book! [catalog-state book]
  (swap! catalog-state (fn [catalog]
                         (cat/add-book catalog book))))

(defn search-books [catalog-state query]
  (cat/search @catalog-state query))

(defn all-books [catalog-state]
  (or (vals (:books @catalog-state))
      []))

(comment
  (def catalog-state (atom {}))

  (all-books catalog-state)

  (search-books catalog-state "Watch")

  (add-book! catalog-state {:isbn "978-1779501127"
                            :title "Watchmen"
                            :authors [{:first-name "Alan"
                                       :last-name "Moore"}
                                      {:first-name "Dave"
                                       :last-name "Gibbons"}]}))
