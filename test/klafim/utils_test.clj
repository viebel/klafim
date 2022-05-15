(ns klafim.utils-test 
  (:require [clojure.test :refer [deftest is]]
            [klafim.utils :refer [full-name mapify]]))

(deftest full-name-test
  (is (= "Joe Doe"
         (full-name {:first-name "Joe"
                     :last-name "Doe"}))))

(deftest mapify-test
  (is (= {1 {:a 1 :b 2} 
          2 {:a 2 :b 3}}
         (mapify [{:a 1 :b 2} {:a 2 :b 3}] :a))))