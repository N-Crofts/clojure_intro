(ns meetup.bac-tests
  (:require [meetup.bac :as bac]
            [clojure.test :refer :all]))


(deftest calculate-bac-tests
  (testing "bac caluculator works")
  (let [drinks 4
        period 5
        weight 120
        gender "f"
        bac    (bac/calculate-bac drinks period weight gender)]
    (is (and (> bac 0.10) (< bac 0.12)))))


(deftest get-feedback-tests
  (testing "get correct feedback")
  (let [was-called? (atom false)]
    (with-redefs [bac/get-weather-data (fn [_] 
                                         (reset! was-called? true)
                                         {:status 404 :body nil})]
      (is (= "Tipsy. Take an uber! Your weather data is unavailable." (bac/get-feedback 0.12 23801)))
      (is (true? @was-called?)))))

