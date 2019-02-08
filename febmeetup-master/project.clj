(defproject meetup "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clj-http "3.9.1"]
                 [cheshire "5.8.1"]]
  :aot [meetup.core]
  :main meetup.core)
