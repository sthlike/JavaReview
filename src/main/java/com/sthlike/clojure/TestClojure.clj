;
; Copyright (c) 2020 sthlike.com.
;

;(import [com.sthlike.clojure MyObject])

(ns com.sthlike.clojure.TestClojure
  (:import [com.sthlike.algorithm.sort Bubble]))

(defn hello-world [username]
  (println (format "hello, %s" username)))

(hello-world "sun")

(defn messenger
  ([] (messenger "hello, world"))
  ([msg] (println msg)))

(messenger "aaaa")

(defn hello [& who]
  (println who))

(hello "Hello" "world" "class")
(def bubble (Bubble.))
(def arr (int-array [1 5 3 2]))
(println (seq arr))
(.sort bubble arr)
(println (seq arr))
(print (.substring "abcd" 2))


