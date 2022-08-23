(ns klafim.fp)


(comment (+ 3 4))

(comment
  (map inc [1 2 3 4 5 19 20 10]))

(comment (inc 3)




         (map inc [2 3 4 5 10 232 12 1 1 1 1 120])


         (map inc [1 2 3 4 5 19 20 10]))



(defn divide-by-two [n]
  (/ n 2))

(defn multiply-by-n [a b]
  (* a b))


(map (partial multiply-by-n 10) [1 2 3 4])

(map (fn [n] 
       (multiply-by-n 10 n))
     [1 2 3 4])

(comment (divide-by-two 10)

         (divide-by-two 0)

         (divide-by-two -1)

         (divide-by-two "aaa")

         (divide-by-two 10.2)

         (divide-by-two "10")

         (divide-by-two (+ 2 3))

         (divide-by-two (* 2 3)))


(map divide-by-two
     (map inc [1 2 3 4 5 19 20 10]))


(even? 2)
(even? 1)


(filter even? [1 2 3 4 5])

(defn beautiful? [n]
  (and (> n 23)
       (odd? n)))

(comment
  (beautiful? 40)
  (beautiful? 41))

(comment
  (filter beautiful? (range 100))

  (count (range 100))

  (last (range 100))

  (nth (range 100) 1)

  (map divide-by-two
       (filter beautiful?
               (map inc
                    (range 100))))

  (->> (range 100)
       (map inc)
       (filter beautiful?)
       (map divide-by-two)))


(defn my-pipeline [s]
  (->> s
       (map inc)
       (filter beautiful?)
       (map divide-by-two)))

(defn my-pipeline-elena [s]
  (let [original s
        first-step (map inc original)
        second-step (filter beautiful? first-step)
        third-step (map divide-by-two second-step)]
    [original first-step second-step third-step]))

(my-pipeline-elena [10 100 93])


(defn my-pipeline-chip [s]
  [s (map inc s) (filter beautiful? (map inc s)) (map divide-by-two (filter beautiful? (map inc s)))])

(= (my-pipeline-chip (range 100))
   (my-pipeline-elena (range 100)))





(defn inc-seq [s]
  (map inc s))


(defn book-matches? [book]
  (= (:title book) "Watchmen"))

(defn book-matches? [{:keys [title]}]
  (= title "Watchmen"))

(book-matches? {:title "Watchmen" :isbn "dssadas"})


(map (fn [book]
       (:title book))
     [{:title "Watchmen" :isbn "dssadas"}
      {:title "7 habits" :isbn "dssadas"}])


(map :title
     [{:title "Watchmen" :isbn "dssadas"}
      {:title "7 habits" :isbn "dssadas"}])


;; Patrick: function overloading (multi arity)
;; Erris: How to write a function that expects a vector (destructuring)
;; JB: Type validation
;; lists vs vectors


;;; Summary

;; Data
;; LISP syntax
;; REPL
;; Create a project
;; map and filter
;; sequences
;; defn
;; anonymous functions
;; let 
;; def
;; unit tests
;; equality check
;; dictionaries and records
;; vectors
;; comment forms
;; destructuring
;; keywords as functions
;; partial
