(ns mais-sobre-mapas.core
  (:gen-class))

;Função que incrementa o valor
(inc 39)

;Algumas operações com listas
(conj [1 2 3] 4)
(conj [1 2 3] 4 5)
(conj [1 2 3] "Marcio")
(conj [1 2 3] [4 5])
(pop [1 2 3])
(peek [1 2 3])


;Tentar realizar as mesmas operações com mapas
(defn compras
  []
  {:tomate {:quantidade 2 :preco 5}
   :arroz {:quantidade 1 :preco 4}
   :feijao {:quantidade 2 :preco 10}})

(compras)

;==========
;peek em mapas
;==========
;Não funciona em mapas

;==========
;pop em mapas
;==========
;Não funciona em mapas

;DISSOC para desvincular uma propriedade de um mapa
(dissoc (compras) :tomate)
(dissoc (compras) :tomate :arroz)

;==========
;conj em mapas
;==========

;Não é a melhor maneira
;Junto dois mapas
(conj (compras) {:alface {:quantidade 2, :preco 8}})

;A mais indicada é ASSOC
;Junto uma propriedade ao mapa
(assoc (compras) :alface {:quantidade 2, :preco 8})

;ASSOC em uma propriedade que já existe substitui a mesma
(assoc (compras) :tomate {:quantidade 4, :preco 10})

;Para atualizar um mapa utilizamos UPDATE
(update {:nome "Marcio", :idade 39} :idade inc)

;Incrementa 1 na quantidade do tomate
(update-in (compras) [:tomate :preco] inc)

;Dobrando o preço do tomate
(update-in (compras) [:tomate :preco] * 2)