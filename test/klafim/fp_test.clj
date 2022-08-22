(ns klafim.fp-test
  (:require [clojure.test :refer [are deftest is]]
            [klafim.fp :as sut]))

;; system under test
(deftest my-pipeline-test
  (is (= [25/2 27/2 29/2 31/2 33/2 35/2 37/2 39/2 41/2 43/2 45/2 47/2 49/2]
         (sut/my-pipeline (range 50)))))


(deftest divide-by-two-test
  (is (= 2 (sut/divide-by-two 4))))


(deftest divide-by-two-test-multiple
  (are [in out] 
       (= out (sut/divide-by-two in))
    4 2
    5 5/2
    0 0
    -2 -1))