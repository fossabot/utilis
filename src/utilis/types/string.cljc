;;   Copyright (c) 7theta. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://www.eclipse.org/legal/epl-v10.html)
;;   which can be found in the LICENSE file at the root of this
;;   distribution.
;;
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any others, from this software.

(ns utilis.types.string)

(defn ->string
  "Coerces 'v' into a string in a way appropriate to it's
  original type"
  [v]
  (if (or (keyword? v) (symbol? v) (string? v))
    (name v)
    (str v)))
