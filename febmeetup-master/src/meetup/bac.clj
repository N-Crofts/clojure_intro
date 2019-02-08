(ns meetup.bac
  (:require [clojure.string :as str]
            [clj-http.client :as client]))

(defn get-weather-data [zip-code]
  (let [api-key "4b09896fa988b5b6545a5ee39135e406"
        uri (str "http://api.openweathermap.org/data/2.5/weather?zip=" zip-code ",us&appid=" api-key)]
    (client/get uri {:accept :json
                     :as     :json
                     :throw-exceptions false
                     :coerce           :always})))

(defn- gender->constant
  "Returns gender constant given gender M or F.  If gender cannot be determined, returns contant for males.  Male constant is 0.68.  Female constant is 0.55."
  [gender]
  (if (= "F" (clojure.string/upper-case gender)) 0.55 0.68))
  
 
(defn calculate-bac
  "Calculates a drinker's blood alcohol content given weight (lbs), total number of beverages consumed over a period of hours,
   and gender (M or F)."
  [total-beverages period weight gender]
  (let [constant (gender->constant gender)
        numerator  (* total-beverages 14)
        denominator (* constant weight 454)
        bac (* 100 (/ numerator denominator))
        detox (* period 0.015)]
    (max 0 (- bac detox))))


  

(defn get-feedback
  [bac zip-code]
  (let [msg (cond
               (< bac 0.03)  "Loosen up."
               (< bac 0.08)  "Nice!"
               (< bac 0.125) "Tipsy. Take an uber!"
               (< bac 0.19)  "Wasted! Go lay down somewhere next to a trash can."
               :else         "Call 911 ASAP.")
        weather (get-weather-data zip-code)]
    (str msg " Your weather data is " (or (some-> weather :body)
                                          "unavailable."))))
 
  
