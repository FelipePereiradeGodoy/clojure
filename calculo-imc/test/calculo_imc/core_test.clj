(ns calculo-imc.core-test
  (:require [clojure.test :refer :all]
            [calculo-imc.core :refer :all]))

(deftest indicador-imc-test
  (testing "Deve retornar :baixo-peso quando o IMC for menor que 18.5"
    (is (= :baixo-peso (indicador-imc 1 2))))
  (testing "Deve retornar :peso-ideal para IMC entre 18.5 e 24.9"
    (is (= :peso-ideal (indicador-imc 70 1.70))))
  (testing "Deve retornar :acima-peso para IMC acima de 24.9"
    (is (= :acima-peso (indicador-imc 100 1.50)))))
