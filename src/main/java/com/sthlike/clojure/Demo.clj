;
; Copyright (c) 2020 sthlike.com.
;

(ns com.sthlike.clojure.Demo
  (:import com.sthlike.algorithm.sort.Bubble))

(defn hello [name]
  (println (format "hello, %s" name)))

(hello "sun")

(def arr (int-array [3 5 2 1]))
(println (seq arr))
(def bubble (Bubble.))
(.sort bubble arr)
(println (seq arr))
