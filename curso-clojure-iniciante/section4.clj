; Exemplos de LET
; let Recebe uma um vetor de chave valor
; (let [chave "valor"])

;------------------------------------------------------------
;Contém numero magico
(defn valor-total
    [valor]
    (+ valor (* valor 0.1)))

;Adicionando let para remover numero magico, criando um simbolo, parecido com const, valor de let é visto apenas dentro do escopo let
(defn valor-total
    [valor]
    (let [percentual-multa 0.1]
        (+ valor (* valor percentual-multa))))

;Adicionando let para remover numero magico, criando um simbolo, parecido com const, valor de let é visto apenas dentro do escopo let
;Adicionando também um novo simbolo dinamicamente para deixar mais semantico
(defn valor-total
    [valor]
    (let [percentual-multa 0.1
          valor-multa (* valor percentual-multa)]
        (+ valor valor-multa)))


;=======================================================
;=======================================================
;=======================================================


;Exemplo de Documentação de Funções em Clojure
;------------------------------------------------------------
(defn valor-total
    "Calcular o valor total incluindo a multa"
    [valor]
    (+ valor (* valor 0.1)))
