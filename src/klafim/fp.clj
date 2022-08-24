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


(map (fn [n] (* n 5)) [1 2 3 4 5])

(def start-coll [1 2 3 4 5])

(def jb-coll (map (fn [n] {:my-number n
                           :your-number (dec n)})
                  start-coll))


(map (fn [m] (:my-number m))
     jb-coll)

(= start-coll
   (map (fn [{:keys [my-number]}] my-number)
        jb-coll))


(vals (first jb-coll))

(get {:my-number 10
      :your-number 9}
     :my-number)


(:my-number {:my-number 10
             :your-number 9})

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









(defn main []
  (println "Hello Clojure!"))


;; JB: Type validation and type hint
;; Elena, Patrick: lists vs vectors
;; JB: Spread operator?
;; Chip: recursion


;;; Summary

;;; Day 1
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

;;; Day 2 - Immutability


;; anonymous functions
;; apply +, max
;; multi arity functions
;; variadic functions

;; reduce - find-max, factorial, sorted?

;; REPL or TDD

;; assoc
;; update

;; always use the least generic tool that does the job!
;; tools designed for professionals are not easy to use for beginners!

;; reduce - implement frequencies

;; immutable linked lists
;; git vs. structural sharing

;; assoc-in, update-in


;; Day 3 
;; JSON
;; Run a program with bb
;; ClojureScript
;; Use NPM module
;; Tests with bb



