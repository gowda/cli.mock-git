(ns tools.cli.mock-git.remote.set-branches
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote set-branches [--add] <name> <branch>...
(def options-spec
  [[nil "--add" "Add to the list, do not replace."]])

(defn summary []
  (utils/build-options-summary
   "remote set-branches"
   (utils/get-description "set-branches" spec)
   options-spec))

(defn do-command [options args])
