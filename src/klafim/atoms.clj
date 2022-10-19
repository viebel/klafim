(ns klafim.atoms)


(defn increment! [counter]
  (let [current-val @counter
        next-val (inc current-val)]
    (reset! counter next-val)))

(def c (atom 0))


@c

(reset! c 0)

(increment! c)

(dotimes [_ 100]
  (future (increment! c)))

@c

(defn safe-increment! [counter]
  (swap! counter inc))

(dotimes [_ 100]
  (future (safe-increment! c)))


@c