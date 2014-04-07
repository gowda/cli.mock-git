(ns tools.cli.mock-git.remote.update
  (require [tools.cli.mock-git.utils :as utils])
  (use [clojure.tools.cli :only [parse-opts]]
       [tools.cli.mock-git.remote.commands :only [spec]]))

;; git remote [-v | --verbose] update [-p | --prune] [(<group> | <remote>)...]
(def options-spec
  [["-v" "--verbose" "Be more verbose."]
   ["-p" "--prune" "Prune all remotes that are updated."]])

(defn summary []
  (utils/build-options-summary
   "remote update"
   (utils/get-description "update" spec)
   options-spec))

(defn do-command [options args])
