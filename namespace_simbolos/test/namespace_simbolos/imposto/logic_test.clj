(ns namespace-simbolos.imposto.logic-test
  (:require [clojure.test :refer :all]
            [namespace-simbolos.imposto.logic :refer :all]))
;Outra maneira de importar é sem o refer :all, para poder escolher a função especifica
;Exemplo [namespace-simbolos.imposto.logic :refer [imposto-retido-fonte]]
;Outra maneira é utilizar alias para remover ambiguidade.
;Exemplo [namespace-simbolos.imposto.logic :as logic]
;No testing coloque o alias antess da função, Exemplo (is (= 0 (logic/imposto-retido-fonte 1)))

(deftest imposto-retido-fonte-test
  (testing "Dado um valor abaixo de 1000 reais então não deve ter imposto retido"
    (is (= 0 (imposto-retido-fonte 1)))
    (is (= 0 (imposto-retido-fonte 999.99))))
  (testing "Dado um valor igual ou superior a 1000 reais então deve ter um imposto retido"
    (is (= 100.00 (imposto-retido-fonte 1000)))))
