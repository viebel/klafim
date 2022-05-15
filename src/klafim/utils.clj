(ns klafim.utils 
  (:require [clojure.set :refer [rename-keys]]))


(defn full-name [{:keys [first-name last-name]}]
  (str first-name
       " "
       last-name))


(comment
  (def mike {:first-name "Michael"
             :last-name "Kleyman"
             :email "mike@me.com"})
  (full-name mike)
  
  (def alan {:id "alan-moore"
             :first-name "Alan"
             :last-name "Moore"
             :book-isbns ["123-456"]})
  
  (full-name alan))


(defn mapify [s k]
  (zipmap (map k s) s))

(comment
  (mapify [{:a 1 :b 2} {:a 2 :b 3}] :a))


(defn headers-and-rows->maps
  [headers rows]
  (map (partial zipmap headers) rows))

(headers-and-rows->maps ["id" "name"]
                        [["1" "foo"]
                         ["2" "bar"]])


