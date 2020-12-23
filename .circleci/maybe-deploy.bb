#!/usr/bin/env /home/circleci/repo/bb

(require '[clojure.java.shell :refer [sh]])

(if (->> (System/getenv "CIRCLE_SHA1")
         (sh "git" "show" "-s")
         :out
         (re-find #"\[ci deploy\]"))
  (do
    (println " executing " (first *command-line-args*))
    (apply sh *command-line-args*))
  (println "skipping" (first *command-line-args*)))


