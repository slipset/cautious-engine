#!/usr/bin/env /home/circleci/repo/bb

(require '[clojure.java.shell :refer [sh]])

(def circle-sha (System/getenv "CIRCLE_SHA1"))

(println "CIRCLE SHA" circle-sha)
(if (->> (sh "git" "show" "-s" circle-sha)
         :out
         (re-find #"\[ci deploy\]"))
  (do
    (println " executing " (first *command-line-args*))
    (apply sh *command-line-args*))
  (println "skipping" (first *command-line-args*)))


