(ns klafim.records)



(defrecord Book [title publication-year])


(comment
  (def watchmen (map->Book {:title "Watchmen" :publication-year 1986}))
  (def watchmen-2 (Book. "Watchmen" 1986))

  (type watchmen)
  (:title watchmen)
  (count watchmen)
  (type (dissoc watchmen :publication-year 2))

  )