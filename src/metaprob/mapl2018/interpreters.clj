(ns metaprob.mapl2018.interpreters
  (:require [metaprob.syntax :refer :all]
            [metaprob.builtin :as b]
            [metaprob.prelude :as p]
            [metaprob.metacirc.infer :as infer]))

(defn infer [& {:keys [procedure inputs intervention-trace
                       target-trace output-trace]}]
  ;; (print (format "infer: output_trace = %s" output-trace))
  (infer/infer procedure
               inputs
               intervention-trace
               target-trace
               output-trace))

(defn interpret [& {:keys [program inputs interventions]}]
  (b/nth (infer/infer program inputs interventions nil  nil)
         0))

