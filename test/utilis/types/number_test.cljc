(ns utilis.types.number-test
  (:require [utilis.types.number :refer [string->long string->double]]
            [utilis.types.string :refer [->string]]
            [clojure.test.check.generators :as gen]
            [com.gfredericks.test.chuck.clojure-test #?(:clj :refer :cljs :refer-macros) [checking]]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer-macros [deftest is] :include-macros true])))

(deftest string->long-should-work
  (checking "string->long longs converted via str" 50
            [x gen/int]
            (is (= x (string->long (str x)))))
  (checking "string->long longs converted via ->string" 50
            [x gen/int]
            (is (= x (string->long (->string x)))))

  (checking "string->long should fail on random strings" 1
            []
            (is (= nil (string->long "foo")))
            (is (= ::bad-string (string->long "foo" ::bad-string))))

  (checking "string->long should fail for non-integral values" 1
            []
            (is (= nil (string->long "3.14")))
            (is (= ::bad-string (string->long "3.14" ::bad-string)))))

(deftest string->double-should-work
  (checking "string->double longs converted via str" 50
            [x gen/ratio]
            (is (= (double x) (string->double (str (double x))))))
  (checking "string->double longs converted via ->string" 50
            [x gen/ratio]
            (is (= (double x) (string->double (->string (double x))))))

  (checking "string->double should fail on random strings" 1
            []
            (is (= nil (string->double "foo")))
            (is (= ::bad-string (string->double "foo" ::bad-string)))))