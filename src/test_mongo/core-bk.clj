(ns test-mongo.core
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))

(let [conn (mg/connect)
      db (mg/get-db conn "test-db")]
  (mc/insert-batch db "money" [{ :_id (ObjectId.) :amount 1000 :account "A03" :contribution-account "SG" }
                               { :_id (ObjectId.) :amount 500 :account "A03" :sub-account "CV" :preservation-flag 0 }]))

(let [conn (mg/connect)
      db (mg/get-db conn "test-db")]
  (mc/find-maps db "money" { :account "A03" }))
