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