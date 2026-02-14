(ns namespace-simbolos.imposto.logic
  (:gen-class))

;Função privada basta utilizar "defn-"
(defn- esta-na-faixa-isencao?
  [valor]
  (< valor 1000))

(defn imposto-retido-fonte 
  [valor]
  (if (esta-na-faixa-isencao? valor)
    0
    (* valor 0.1)))