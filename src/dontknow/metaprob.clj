(ns dontknow.metaprob
  (:refer-clojure :only [defmacro])
  (:require [dontknow.library]))

                         ;; declare letfn let fn assert for
                         ;; ;; We don't need the following any more; delete
                         ;; ;; them anon
                         ;; cond case
                         ;; dosync
                         ;; count map? get assoc zipmap
                         ;; with-meta meta apply ref ref-set deref
                         ;; type instance? ns-resolve
                         ;; symbol symbol? string?
                         ;; cons conj list? concat mapcat list empty? list? seq?
                         ;; vec vector? nth count contains?
                         ;; str boolean?
                         ;; print newline format
                         ;; + - * / = < > <= >= number?
                         ;; rand

; This module is intended for import by metaprob code.
; To access any of this functionality from clojure, please import 
; library.clj.

; --------------------
; The following are special forms and are defined in *every* namespace
; independent of anything you can do:
;
;  def do if

; This isn't part of metaprob but boy is it useful

(defmacro let [& rest]
  `(clojure.core/let ~@rest))

;; ----------------------------------------------------------------------
;; Re-export library macros

(defmacro define [& rest]
  `(dontknow.library/define ~@rest))

(defmacro program [& rest]
  `(dontknow.library/program ~@rest))

(defmacro block [& rest]
  `(dontknow.library/block ~@rest))

(defmacro tuple [& rest]
  `(dontknow.library/tuple ~@rest))

(defmacro with-address [& rest]
  `(dontknow.library/with-address ~@rest))

(def this "please do not use 'this' in the absence of run-time traces")

;; ----------------------------------------------------------------------
;; Re-expore builtin functions

(def assert dontknow.library/mp-assert)
(def not dontknow.library/mp-not)

(def eq dontknow.library/eq)
(def neq dontknow.library/neq)
(def gt dontknow.library/gt)
(def gte dontknow.library/gte)
(def lt dontknow.library/lt)
(def lte dontknow.library/lte)

(def add dontknow.library/add)
(def sub dontknow.library/sub)
(def mul dontknow.library/mul)
(def div dontknow.library/div)
; etc. etc.

(def mk_nil dontknow.library/mk_nil)

(def trace_get dontknow.library/trace_get)
(def trace_has dontknow.library/trace_has)
(def trace_set dontknow.library/trace_set)
(def trace_set_at dontknow.library/trace_set_at)
(def trace_set_subtrace_at dontknow.library/trace_set_subtrace_at)
(def trace_has_key dontknow.library/trace_has_key)
(def trace_subkeys dontknow.library/trace_subkeys)
(def lookup dontknow.library/lookup)

(def interpret dontknow.library/interpret)
(def interpret_prim dontknow.library/interpret_prim)
(def pprint dontknow.library/mp-pprint)

(def flip dontknow.library/flip)
(def uniform dontknow.library/uniform)
(def resolve_tag_address dontknow.library/resolve_tag_address)
(def name_for_definiens dontknow.library/name_for_definiens)

(def pair dontknow.library/pair)
(def list_to_array dontknow.library/list_to_array)
(def array_to_list dontknow.library/array_to_list)
(def list dontknow.library/mp-list)

(def is_metaprob_array dontknow.library/is_metaprob_array)

(def dereify_tag dontknow.library/dereify_tag)
(def and dontknow.library/mp-and)
(def or  dontknow.library/mp-or)

(def exactly)

;; ----------------------------------------------------------------------
;; Re-export prelude overrides

(def first dontknow.library/mp-first)
(def rest dontknow.library/mp-rest)
(def is_pair dontknow.library/is_pair)
(def length dontknow.library/length)
(def last dontknow.library/mp-last)
(def nth dontknow.library/mp-nth)
(def range dontknow.library/mp-range)

;; (def map dontknow.library/mp-map)     ;use the one from the prelude instead!

(def append dontknow.library/append)

(def error dontknow.library/error)
(def capture_tag_address dontknow.library/capture_tag_address)

(def env_lookup dontknow.library/env_lookup)
(def make_env dontknow.library/make_env)
(def match_bind dontknow.library/match_bind)
