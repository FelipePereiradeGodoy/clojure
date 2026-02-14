(ns tipos-clojure.core
  (:gen-class))

(type 10); java.lang.Long
(type 10.0);java.lang.Double
(type (/ 10 3));clojure.lang.Ratio
(type (* 3 (/ 10 3)));clojure.lang.BigInt
(type 10N);clojure.lang.BigInt
(type 10M);clojure.lang.BigDecimal
(type "Marcio");java.lang.String
(type nil);nil
(type []);clojure.lang.PersistentVector

(type println);Possível verificar o tipo de funções
; conseguimos ver o nome do pacote onde a função foi declarada
;clojure.core$println
