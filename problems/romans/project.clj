(defproject romans "0.1.0-SNAPSHOT"
  :description "Roman to base10 numbers converter: http://www.4clojure.com/problem/92"
  :url "https://github.com/affo/javoid"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot romans.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
