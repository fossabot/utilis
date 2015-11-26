(ns utilis.types.bool-test
  (:require [utilis.types.bool :refer [->boolean]]
            [clojure.test.check.generators :as gen]
            [com.gfredericks.test.chuck.clojure-test #?(:clj :refer :cljs :refer-macros) [checking]]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer-macros [deftest is] :include-macros true])))

(deftest ->boolean-should-work

  ;;To be consistent with clojure.core
  (checking "->boolean should treat '() as true" 1
            []
            (is (= true (->boolean '()))))
  (checking "->boolean should treat 0 as true" 1
            []
            (is (= true (->boolean 0))))
  (checking "->boolean should treat all types of numbers as true" 1000
            [n (gen/one-of [gen/int gen/ratio (gen/fmap double gen/ratio)])]
            (is (= true (->boolean n))))
  (checking "->boolean should treat nil as false" 1
            []
            (is (= false (->boolean nil))))

  (checking "->boolean should convert true or false strings" 1
            []
            (is (= true (->boolean "true")))
            (is (= false (->boolean "false"))))

  (checking "->boolean should fail for non true or false strings" 1000
            [s (gen/such-that #(not (#{"true" "false"} %)) gen/string)]
            (is (nil? (->boolean s)))
            (is (= ::not-convertable (->boolean s ::not-convertable)))))