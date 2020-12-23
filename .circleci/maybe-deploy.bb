#!/usr/bin/env /home/circleci/repo/bb

(require '[clojure.java.shell :refer [sh]])
(require '[clojure.edn :as edn])

(defn make-version! []
  (let [v (edn/read-string "/home/circelci/repo/version.edn")
        commit-count (:out (sh "git" "rev-list" "--count" "--first-parent" "HEAD"))]
    (str v "." commit-count)))

(println "Running deploy in " (System/getenv "PWD"))

(if (->> (System/getenv "CIRCLE_SHA1")
         (sh "git" "show" "-s")
         :out
         (re-find #"\[ci deploy\]"))
  (do
    (println " executing " (first *command-line-args*))
    (System/setenv "PROJECT_VERSION" (make-version!))
    (apply sh *command-line-args*))
  (println "skipping" (first *command-line-args*)))


