(ns klafim.catalog
  (:require [cheshire.core :refer [generate-string]]
            [clojure.set :refer [rename-keys]]
            [clojure.string :refer [includes? lower-case upper-case]]
            [klafim.utils :refer [full-name mapify]]))

(def watchmen {:isbn "978-1779501127"
               :title "Watchmen"
               :author-ids ["alan-moore" "dave-gibbons"]})

(def seven-habits {:isbn "978-19821372743"
                   :title "Seven Habits of Highly Effective People"
                   :author-ids ["stephen-covey"]})

(def alan {:id "alan-moore"
           :first-name "Alan"
           :last-name "Moore"
           :book-isbns ["978-1779501127"]})

(def dave {:id "dave-gibbons"
           :first-name "Dave"
           :last-name "Gibbons"
           :book-isbns ["978-1779501127"]})

(def stephen {:id "stephen-covey"
              :first-name "Stephen"
              :last-name "Covey"
              :book-isbns ["978-19821372743"]})

(def catalog {:books {(:isbn watchmen) watchmen
                      (:isbn seven-habits) seven-habits}
              :authors {"alan-moore" alan
                        "dave-gibbons" dave
                        "stephen-covey" stephen}})

(defn create-catalog [books authors]
  {:books (mapify books :isbn)
   :authors (mapify authors :id)})

(comment
  (create-catalog [watchmen seven-habits] [alan dave stephen]))

(defn matching-books [{:keys [books]} query]
  (filter (fn [{:keys [title]}]
            (includes? title query))
          (vals books)))

(defn author-name [{:keys [authors]} author-id]
  (->> (get authors author-id)
       (full-name)))

(defn book-info [catalog book]
  (-> book
      (select-keys  [:title :author-ids])
      (update :author-ids #(map (partial author-name catalog) %))
      (rename-keys {:author-ids :author-names})))

(comment
  (book-info catalog (first (vals (:books catalog)))))

(defn search [catalog query]
  (let [books (matching-books catalog query)]
    (map (fn [book]
           (book-info catalog book))
         books)))

(comment
  (search catalog "Wat"))

(defn search-json [catalog query]
  (-> (search catalog query)
      generate-string))

(comment
  (search-json catalog "Wat"))

(defn author-id [{:keys [first-name last-name]}]
  (str (lower-case first-name) "-"
       (lower-case last-name)))

(comment
  (author-id {:first-name "Dave"
              :last-name "Gibbons"})
  (map author-id [{:first-name "Alan"
                   :last-name "Moore"}
                  {:first-name "Dave"
                   :last-name "Gibbons"}]))

(defn add-book-only [catalog {:keys [title isbn authors]}]
  (assoc-in  catalog
             [:books isbn]
             {:title title
              :isbn isbn
              :author-ids (map author-id authors)}))

(defn add-author [catalog author]
  (let [id (author-id author)]
    (assoc-in  catalog
               [:authors id]
               (assoc author :id id))))

(defn add-authors [catalog authors]
  (reduce (fn [res author]
            (add-author res author))
          catalog
          authors))

(comment
  (add-author {} {:first-name "Alan"
                  :last-name "Moore"})
  (add-book-only {} {:isbn "978-1779501127"
                     :title "Watchmen"
                     :authors [{:first-name "Alan"
                                :last-name "Moore"}
                               {:first-name "Dave"
                                :last-name "Gibbons"}]}))

(defn add-book [catalog {:keys [authors] :as book}]
  (-> catalog
      (add-book-only book)
      (add-authors authors)))

(comment
  (add-book {} {:isbn "978-1779501127"
                :title "Watchmen"
                :authors [{:first-name "Alan"
                           :last-name "Moore"}
                          {:first-name "Dave"
                           :last-name "Gibbons"}]}))


(def my-book '{:title "Watchmen"
               :isbn "978-1779501127"
               :author-ids ("alan-moore" "dave-gibbons")})

(defn add-book-simple [catalog book]
  (let [books-with-the-new-book (assoc (:books catalog)
                                       (:isbn book)
                                       book)]
    (assoc catalog :books books-with-the-new-book)))


(defn add-book-simple [catalog book]
  (update catalog :books (fn [books]
                           (assoc books
                                  (:isbn book)
                                  book))))


(update {:cnt 10} :cnt inc)


(add-book-simple {} my-book)



(update {:first-name "Sam"
         :last-name "Williams"}
        :last-name
        (fn [last-name]
          (upper-case last-name)))



(defn count-items [cart])

(= {:items 3} (count-items {:items ["book" "mug" "pencil"]}))


(defn count-items-in-carts [carts])

(= [{:items 1} {:items 3}] (count-items-in-carts [{:items ["glass"]}
                                                  {:items ["book" "mug" "pencil"]}]))

(def user {:id "erris"
           :carts [{:items ["glass"]}
                   {:items ["book" "mug" "pencil"]}]})

(defn update-user-carts [user])

(= {:id "erris"
    :carts [{:items 1}
            {:items 3}]}
   (update-user-carts {:id "erris"
                       :carts [{:items ["glass"]}
                               {:items ["book" "mug" "pencil"]}]}))

(defn update-all-user-carts [users])

(= [{:id "erris"
     :carts [{:items 2}
             {:items 3}]}
    {:id "erris"
     :carts [{:items 1}
             {:items 3}]}]
   (update-all-user-carts [{:id "chip"
                            :carts [{:items ["glass" "water"]}
                                    {:items ["book" "mug" "pencil"]}]}
                           {:id "erris"
                            :carts [{:items ["glass"]}
                                    {:items ["book" "mug" "pencil"]}]}]))


(defn update-all-user-carts-in-system [system])


(= {:users [{:id "erris"
             :carts [{:items 2}
                     {:items 3}]}
            {:id "erris"
             :carts [{:items 1}
                     {:items 3}]}]}
   (update-all-user-carts-in-system {:users [{:id "chip"
                                              :carts [{:items ["glass" "water"]}
                                                      {:items ["book" "mug" "pencil"]}]}
                                             {:id "erris"
                                              :carts [{:items ["glass"]}
                                                      {:items ["book" "mug" "pencil"]}]}]}))