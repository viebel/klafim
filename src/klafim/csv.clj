(ns klafim.csv
  (:require [clojure.data.csv :refer [read-csv]]
            [clojure.java.io :refer [reader]]
            [klafim.utils :refer [headers-and-rows->maps]]))


(defn read-rows [[headers & rows] kmap]
  (headers-and-rows->maps
   (map #(get kmap % %)
        headers)
   rows))

(defn read-csv-file [path kmap]
  (with-open [reader (reader path)]
    (doall
     (-> (read-csv reader)
         (read-rows kmap)))))

(comment
  (read-csv-file "/Users/viebel/Downloads/books.csv" {"ISBN" :isbn
                                                      "Title" :title
                                                      "Publication year" :publication-year
                                                      "Author IDs" :author-ids}))
