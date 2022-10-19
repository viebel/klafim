(ns klafim.library
  (:require [klafim.catalog :as cat]))


(def catalog-state (atom {}))

(defn add-book! [catalog-state book]
  (swap! catalog-state (fn [catalog]
                         (cat/add-book catalog book))))


(comment
  (add-book! catalog-state {:isbn "978-1779501127"
                                      :title "Watchmen"
                                      :authors [{:first-name "Alan"
                                                 :last-name "Moore"}
                                                {:first-name "Dave"
                                                 :last-name "Gibbons"}]}))
