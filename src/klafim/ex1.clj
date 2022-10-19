(ns klafim.ex1)

(defn add-book-and-its-authors
  "Add a book to a catalog.
   Receives catalog and book-info.
   Returns catalog with updated :books and :authors."
  [catalog book-info])

(defn add-book-and-its-authors!
  "Add a book to a catalog.
   Receives catalog atom and book-info.
   Update catalog atom with updated :books and :authors."
  [catalog book-info])

(defn sum "Summing numbers in a sequence"
  [s])

(defn pairs->map 
  "Converting a sequence of pairs to a map"
 [pairs] )


(defn my-map "same as map (non-lazy with recursion)")

(defn my-filter "same as filter (non-lazy with recursion)")

(defn my-reduce "same as reduce (with recursion)")


(defn my-map "same as map (with reduce)")

(defn my-filter "same as filter (with reduce)")


;;;BONUS

(defn my-map "same as map (lazy)")

(defn my-filter "same as filter (lazy)")



(defn parse-rows 
  "Receive a sequence of maps and a map with parsing functions. Example of arguments:
  rows 
    [{:a \"1\" :b \"2, 4\"}
     {:a \"100\" :b \"2, 5, 6\"}])
   
  parse-map
           {:a read-int
            :b read-string-seq})"
  [rows parse-map])


(comment

  (def watchmen-info {:isbn "978-1779501127"
                      :title "Watchmen"
                      :publication-year 1986
                      :authors [{:first-name "Alan"
                                 :last-name "Moore"}
                                {:first-name "Dave"
                                 :last-name "Gibbons"}]}))