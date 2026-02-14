(ns disciplinas.core
  (:require [clojure.string :refer [upper-case join]])
  (:gen-class))

;Desafio: Precisamos criar uma função que, dado um conjunto(vetor)
;de disciplinas e o semestre da discente, deve:
;-filtrar a lista para exibir disciplinas restantes(que sejam do semetre atual ou superior)
;-transformar nome da disciplina para maiusculo e descartar demais informações.
;-criar uma String concatenando o nome de todas as disciplinas filtradas
;Exemplo Entrada:
;[{:nome "Estrutura de dados" :semestre 2}
;{:nome "Algoritmos" :semestre 1}
;{:nome "Inteligencia Artificial" :semestre 3}] 2
;Exemplo de saida:
;"ESTRUTURA DE DADOS, INTELIGENCIA ARTIFICIAL"


;===============
;MINHA SOLUÇÃO
;===============

(defn filtrar-disciplinas-por-semestre
  [disciplinas filtro-semestre]
  (filter 
   (fn 
     [disciplina]
     (let [semestre (:semestre disciplina)]
       (>= semestre filtro-semestre))) 
   disciplinas))

(defn transformar-nome-disciplina-maisculo
  [disciplinas]
  (map
   (fn
     [disciplina]
     (let [nome (:nome disciplina)]
       (upper-case nome)))
   disciplinas)
  )

(defn transformar-disciplinas-em-string
  [nomes]
  (join ", " nomes)
  )

(defn lista-disciplinas-por-semestre-min
  [disciplinas semestre-min]
  (let [disciplinas-elegiveis (filtrar-disciplinas-por-semestre disciplinas semestre-min)
        nome-disciplinas-maiusculo (transformar-nome-disciplina-maisculo disciplinas-elegiveis)
        disciplinas-em-string (transformar-disciplinas-em-string nome-disciplinas-maiusculo)]
    disciplinas-em-string))
 
(lista-disciplinas-por-semestre-min
 [{:nome "Estrutura de dados" :semestre 2}
  {:nome "Algoritmos" :semestre 1} 
  {:nome "Inteligencia Artificial" :semestre 3}
  ] 
 2)

;===============
;Professor Solução
;===============

(defn disciplinas
  []
  [{:nome "Estrutura de dados" :semestre 2}
   {:nome "Algoritmos" :semestre 1}
   {:nome "Inteligencia Artificial" :semestre 3}])

;Solução do professor utilizar thread last
;->>
;Serve para passar o resultado das funções como ultimo parametro para a proxima como encadeamento
(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (->> disciplinas
       (filter #(>= (:semestre %) semestre-atual))
       (map :nome)
       (map upper-case)
       (join ", ")))

(nomes-disciplinas-restantes (disciplinas) 2)

;Exemplo utilizando Thread first
;->
;Serve para passar o resultado das funções como primeiro parametro para a proxima como encademaneto.

;Sem thread first
(defn transform 
  [person]
  (update (assoc person :hair-color "gray") :age inc))

(transform {:name "Socrates", :age 39})

;Com thread first
(defn transform
  [person]
  (-> person
      (assoc :hair-color "gray")
      (update :age inc)))

(transform {:name "Socrates", :age 39})