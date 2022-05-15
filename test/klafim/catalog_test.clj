(ns klafim.catalog-test
  (:require [clojure.test :refer [deftest is]]
            [klafim.catalog :refer [add-book create-catalog search]]))


(def watchmen {:isbn "978-1779501127"
               :title "Watchmen"
               :author-ids ["alan-moore" "dave-gibbons"]})

(def seven-habits {:isbn "978-19821372743"
                   :title "Seven Habits of Highly Effective People"
                   :author-ids ["stephen-covey"]})


(def alan {:id "alan-moore"
           :first-name "Alan"
           :last-name "Moore"
           :book-isbns ["123-456"]})

(def dave {:id "dave-gibbons"
           :first-name "Dave"
           :last-name "Gibbons"
           :book-isbns ["123-456"]})

(def stephen {:id "stephen-covey"
              :first-name "Stephen"
              :last-name "Covey"
              :book-isbns ["145-423"]})

(def catalog
  (create-catalog [watchmen seven-habits] [alan dave stephen]))

(deftest search-test
  (is (= [{:title "Watchmen"
           :author-names ["Alan Moore" "Dave Gibbons"]}]
         (search catalog "Wat"))))


(deftest add-book-test
  (let [catalog (add-book {} {:isbn "978-1779501127"
                              :title "Watchmen"
                              :authors [{:first-name "Alan"
                                         :last-name "Moore"}
                                        {:first-name "Dave"
                                         :last-name "Gibbons"}]})
        expected '{:books {"978-1779501127" {:title "Watchmen"
                                             :isbn "978-1779501127"
                                             :author-ids ("alan-moore" "dave-gibbons")}}
                   :authors {"alan-moore" {:first-name "Alan"
                                           :last-name "Moore"
                                           :id "alan-moore"}
                             "dave-gibbons" {:first-name "Dave"
                                             :last-name "Gibbons"
                                             :id "dave-gibbons"}}}]
    (is (= expected catalog))))

(deftest add-book-idempotent-test
  (let [catalog (add-book {} {:isbn "978-1779501127"
                              :title "Watchmen"
                              :authors [{:first-name "Alan"
                                         :last-name "Moore"}
                                        {:first-name "Dave"
                                         :last-name "Gibbons"}]})
        catalog2 (add-book catalog {:isbn "978-1779501127"
                                    :title "Watchmen"
                                    :authors [{:first-name "Alan"
                                               :last-name "Moore"}
                                              {:first-name "Dave"
                                               :last-name "Gibbons"}]})]
    (is (= catalog2 catalog))))