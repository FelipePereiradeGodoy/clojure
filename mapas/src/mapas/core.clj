(ns mapas.core
  (:gen-class))

;Mapas simples, parecido com um obj ou dicionario.
;Utilizamos por padrão uma keyword para declarar o nome de uma properidade de um mapa
{:nome "Felipe"
 :sobrenome "Godoy"}

;Carrinho de compras
(defn compras
  []
  {:tomate {:quantidade 2, :preco 5}
   :arroz {:quantidade 1, :preco 4}
   :feijao {:quantidade 2, :preco 10}})

(compras); Retorna o mapa inteiro

;==========
;Como recuperar valor de chaves do mapa
;==========

;1 - Caso o mapa retorna nil o get retorna nil
(get (compras) :tomate)

;2 - Caso o mapa retorna nil retorna uma Execption
((compras) :tomate)

;3 - Caso o mapa retorna nil retorna nil
(:tomate (compras))

;==========
;Retornando valores default, caso não seja encontrado nenhum
;==========
(:batata (compras) {:quantidade 0, :preco 0})

;==========
;Navegando para sub-propriedade do mapa
;==========

;Maneira "padrão"
(:quantidade (:tomate(compras)))

;get-in
(get-in (compras) [:tomate :quantidade])
;get-in default
(get-in (compras) [:batata :quantidade] 0)

;Thread-first macro - para acessar propriedades aninhadads de forma encadeada
(-> (compras) :tomate :preco)
