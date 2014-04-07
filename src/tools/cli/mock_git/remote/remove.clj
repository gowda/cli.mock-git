(ns tools.cli.mock-git.remote.remove
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote remove <name>

(defn summary []
  (utils/build-options-summary
   "remote remove"
   (utils/get-description "remove" spec)
   nil))

(defn do-command [options args])
