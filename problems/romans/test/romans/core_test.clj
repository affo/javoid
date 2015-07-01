(ns romans.core-test
  (:require [clojure.test :refer :all]
            [romans.core :refer :all]))

(deftest roman-validation
  (testing "illegal are discarded"
    (is (not (valid? "m")))
    (is (not (valid? "MCF")))
    (is (not (valid? "IIXDJ"))))
  (testing "legal are accepted"
    (is (valid? "M"))
    (is (valid? "IIXXDL"))
    (is (valid? "IXCDLMII"))))

(deftest roman-parse
  (is (= (parse "CXL") 140))
  (is (= (parse "DCCCXXVII") 827))
  (is (= (parse "MMMCMXCIX") 3999))
  (is (= (parse "XLVIII") 48))
  (is (thrown? Exception (parse "IIIII")) "Group of 4")
  (is (thrown? Exception (parse "F")) "F is not a valid character"))
