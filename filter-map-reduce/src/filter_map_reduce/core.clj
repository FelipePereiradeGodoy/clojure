(ns filter-map-reduce.core
  (:gen-class))

;Desafio 1

;Imagine que tenhamos um vetor de numeros onde cada numero representa o ano que o estudante está.
;Exemplo: [5, 6, 6] - Temos 1 estudante no quinto ano e 2 no sexto.

;Desafio 1: Crie uma função que recebe este vetor e retorne a qtde de estudantes no quinto ano.

;[5 5 6 7 8 6 5 5] -> [5 5 5 5] -> 4

(def quinto-ano 5)

(defn quantidade-estudantes-no-quinto-ano
  [estudantes]
  (let [somente-alunos-quinto-ano (filter #(= quinto-ano %) estudantes)
        total-alunos-quinto-ano (count somente-alunos-quinto-ano)]
    total-alunos-quinto-ano))

(quantidade-estudantes-no-quinto-ano [5 6 7 5 5 3 5])

;Desafio 2

;Desafio2: Crie uma função que recebe um vetor de idades e retorna a soma.
;Ex: (soma-das-idades [5 10 5]) -> Deve retornar 20

(defn soma-das-idades
  [idades]
  (reduce + idades))

(soma-das-idades [5 10 5])


;Desafio 3

;Desafio3: Crie uma função que recebe um vetor de nomes e retorne o tamnho médio dos nomes.
;Ex: (tamanho-medio-dos-nomes ["Marcio", "João"]) -> Deve retornar 5

;Para cada nome preciso da qtd de caracteres
;Ex [6 4]

;Soma o total
;10

;Depois calculo a media
;Ex: 5

(defn tamanho-medio-dos-nomes
  [nomes]
  (let [qtd-nomes (count nomes)
        lista-qtde-caracteres (map count nomes)
        total-qtde-caracteres (reduce + lista-qtde-caracteres)
        media-dos-nomes (/ total-qtde-caracteres qtd-nomes)]
    media-dos-nomes)
  )

(tamanho-medio-dos-nomes ["Marcio", "João"])


;Desafio Final

;Desafio Final: Crie uma função que recebe um vetor de nomes e retorne o tamanho médio dos nomes,
;mas deve-se ignorar nomes com 3 ou menos caracteres.
;Ex: (tamanho-medio-dos-nomes ["Marcio", "João", "Ana", "Felipe", "Be"])

;Para cada nome preciso da qtd de caracteres
;Ex [6 4 3 6 2]

;Filtro somente com > 3 caracteres
;Ex: [6 4 6]

;Soma o total
;16

;Depois calcula a media
;5.3s

(defn tamanho-medio-dos-nomes
  [nomes]
  (let [qtde-min-caracteres 3
        lista-qtde-caracteres (map count nomes)
        somente-maiores-que-tres (filter #(> % qtde-min-caracteres) lista-qtde-caracteres)
        total-qtde-caracteres (reduce + somente-maiores-que-tres)
        qtd-nomes-maiores-que-tres (count somente-maiores-que-tres)
        media-dos-nomes (/ total-qtde-caracteres qtd-nomes-maiores-que-tres)]
    media-dos-nomes)
  )

(tamanho-medio-dos-nomes ["Marcio", "João", "Ana", "Felipe", "Be"])