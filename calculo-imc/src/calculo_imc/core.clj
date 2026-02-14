(ns calculo-imc.core
  (:gen-class))

;defonce inpende a redefinição da constante
(defonce imc-max-para-peso-baixo 18.5)
(defonce imc-max-para-peso-ideal 24.9)

 (defn- calcular-imc
   "Calcula o valor do IMC dado o peso e a altura."
  [peso altura]
  (/ peso (* altura altura)))

(defn indicador-imc
  "Determina o indicador de IMC (:baixo-peso, :peso-ideal ou :acima-peso) com base no peso e altura"
  [peso altura]
  (let [imc (calcular-imc peso altura)]
    (cond
      (< imc imc-max-para-peso-baixo) :baixo-peso
      (<= imc imc-max-para-peso-ideal) :peso-ideal
      :else :acima-peso)))
 
 (indicador-imc 100 1.75)
 

;Melhorando o código, segregando a responsabilidade.
(defn classificar-imc
  [imc]
  (cond
    (< imc imc-max-para-peso-baixo) :baixo-peso
    (<= imc imc-max-para-peso-ideal) :peso-ideal
    :else :acima-peso))

(defn indicador-imc
  [peso altura]
  (-> (calcular-imc peso altura)
      classificar-imc))
 
 (indicador-imc 100 1.75)