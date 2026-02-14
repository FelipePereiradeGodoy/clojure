(ns mais-sobre-vetores.core
  (:gen-class))


(defn substituir-nome
  [nomes novo-nome]
  (assoc nomes 0 novo-nome))

(substituir-nome ["Marcio", "Joao", "Maria"] "Felipe")