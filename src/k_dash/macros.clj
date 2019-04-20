(ns k-dash.macros 
  (:require [clojure.data.json :as json]))

(defmacro read-json [filename]
  (json/read-str (slurp filename)))
