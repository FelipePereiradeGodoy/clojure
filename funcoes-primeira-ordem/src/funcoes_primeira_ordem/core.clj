(ns funcoes-primeira-ordem.core
  (:gen-class))

;=====================================================
;=====================================================
;=====================================================


(defn consulta-taxa-padrao-por-http
  "Imagina que esta codigo faz uma req http para obter a taxa-padrao."
  []
  0.30)


;=====================================================
;=====================================================
;=====================================================

(defn imposto-retido
  "Se salario abaixo de 1000 reais não tem imposto. Acima ou igual a 1000 deve aplicar imposto padrão."
  [taxa-padrao salario]
    (if (< salario 1000)
      0
      (* salario taxa-padrao)))

(imposto-retido 0.2 1000)

;Passamos o resultado da função como parametro
(imposto-retido (consulta-taxa-padrao-por-http) 1000)


;=====================================================
;=====================================================
;=====================================================


;Passamos a função como parametro
;OBS: Ao retirar o parantes passamos a referencia da função.
(defn imposto-retido
  "Se salario abaixo de 1000 reais não tem imposto. Acima ou igual a 1000 deve aplicar imposto padrão."
  [consulta-taxa-padrao salario]
  (if (< salario 1000)
    0
    (* salario (consulta-taxa-padrao))))

;Passamos a função como parametro
;OBS: Ao retirar o parantes passamos a referencia da função.
(imposto-retido consulta-taxa-padrao-por-http 1000)



;=====================================================
;=====================================================
;=====================================================

(defn consulta-taxa-padrao-fixa
  []
  0.1)

;Retorna uma função ou seja sua referencia
(defn minha-taxa-padrao
  []
  consulta-taxa-padrao-fixa)

;Retorna a referencia da memoria
(minha-taxa-padrao)

;Já que a função "minha-taxa-padrao" retorna outra função, então para executa-la.
;Mas esse cenário é mais utilizado para didatica.
((minha-taxa-padrao))

;Utilizando retorno de função passando ele como argumento para outro função
(imposto-retido (minha-taxa-padrao) 2000)


;=====================================================
;=====================================================
;=====================================================

;Função com nome
(defn dobro [x] (* 2 x))
(dobro 2)

;Cria uma função anonima igual a função dobro acima
(fn [x] (* 2 x))
;Executando a função anonima
((fn [x] (* 2 x)) 2)

;Outra maneira de criar função anonima é
;Função anonima igual a função dobro acima
;"%" serve para utilizar o primeiro parametro passado
#(* 2 %)
;Executando a função anonima
(#(* 2 %) 2)

;Utilizando "%" para mais de um argumento
#(* 2 %1 %2)
;Executando a função anonima com mais de um argumento
(#(* 2 %1 %2) 2 4)


;Para declarar uma função de constante podemos utilizar a função
(constantly 10)
;Executando uma função de constante
((constantly 10))


;=====================================================
;=====================================================
;=====================================================

;Utilizando funções de ordem superior com funções anonimas
(imposto-retido (fn [] 0.2) 1000)
(imposto-retido (constantly 0.2) 1000)