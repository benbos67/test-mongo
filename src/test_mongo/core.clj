(ns test-mongo.core
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

(let [^MongoOptions opts (mg/mongo-options :treads-allowed-to-block-for-connection-multiplier)
      ^ServerAddress sa (mg/server-address "127.0.0.1" 27017)
      conn (mg/connect sa opts)
      db (mg/get-db conn "test-db")]
)
