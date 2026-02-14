;===============================================
;Condicionais em Clojure
;===============================================

;========================
;Predicados(Predicates)
;========================

;São função que retorna sempre um boolean
;Por boas práticas funções Predicates tem seu nome terminado em ?

(even? 3);retorna true se for par
(odd? 3);retorna true se for impar
(neg? 3);retorna true se for negativo

;Criando uma função predicate
(defn isento-imposto?
    [valor]
    (< valor 1000))


;========================
; IF
;========================

;É uma função com 3 parâmetros, ultimo parametro opcional

;(if (condição)
;    (expressão para caso true)
;    (expressão para caso false))


;Statments x Expressions

;Statments:
;    - Abordagem "imperativa"
;    - Não tem retorno

;Expressions:
;    - Abordagem "declarativa"
;    - Sempre tem um retorno



(defn imposto-retido
    "Se salario abaixo ou igual a 1000 reais não tem imposto.
    Acima de 1000 e abaixo de 2000 reais tem 10% de imposto e acima ou igual a 2000,
    imposto deve ser 20%."
    [salario]
    (let [imposto-primeira-faixa 0
          imposto-segunda-faixa 0.1
          imposto-terceira-faixa 0.2
          salario-primeira-faixa 1000
          salario-segunda-faixa 2000]
        (if (<= salario salario-primeira-faixa)
            (* salario imposto-primeira-faixa)
            (if (< salario salario-segunda-faixa)
                (* salario imposto-segunda-faixa)
                (* salario imposto-terceira-faixa)))))



;========================
; WHEN
;========================

;Parecido com o if é uma função

(defn imprimir-mensagem-boas-vindas
    [idade]
    (when (>= idade 18)
        (println "Esta mensagem será exibida apenas para usuarios")
        (println "com mais de 18 anos de idade")))