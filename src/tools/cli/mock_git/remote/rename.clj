(ns tools.cli.mock-git.remote.rename
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote rename <old> <new>

(defn summary []
  (utils/build-options-summary
   "remote rename"
   (utils/get-description "rename" spec)
   nil))

(defn do-command [options args])
