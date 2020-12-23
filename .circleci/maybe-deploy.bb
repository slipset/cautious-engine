#!/usr/bin/env ~/repo/bb

(sh "git" "-s" "$CIRCLE_SHA1")
(println "Hello world" (:out (sh "git" "-s" "$CIRCLE_SHA1")))