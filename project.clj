(defproject slipset/cautious-engine (or (System/getenv "PROJECT_VERSION") "0.1.0-SNAPSHOT")
  ;; https://crossedstreams.com/2018/04/18/easier-clojure-releases-without-commits/
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases false}]]
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot cautious-engine.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
