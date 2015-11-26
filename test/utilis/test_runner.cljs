;;   Copyright (c) 7theta. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://www.eclipse.org/legal/epl-v10.html)
;;   which can be found in the file epl-v10.html at the root of this
;;   distribution.
;;
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any others, from this software.

(ns utilis.test-runner
  (:require [doo.runner :refer-macros [doo-tests doo-all-tests]]
            [utilis.exception-test]
            [utilis.fn-test]
            [utilis.map-test]
            [utilis.string-test]

            [utilis.types.bool-test]
            [utilis.types.keyword-test]
            [utilis.types.number-test]
            [utilis.types.string-test]))

(doo-all-tests)