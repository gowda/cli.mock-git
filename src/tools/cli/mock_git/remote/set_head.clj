(ns tools.cli.mock-git.remote.set-head
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote set-head <name> (-a | --auto | -d | --delete | <branch>)
(def options-spec
  [["-a" "--auto"
    (str "Query remote to determine HEAD and set "
         "symbolic-ref refs/remotes/<name>/HEAD.")]
   ["-d" "--delete" "Delete symbolic ref refs/remotes/<name>/HEAD."]])

(defn summary []
  (utils/build-options-summary
   "remote set-head"
   (utils/get-description "set-head" spec)
   options-spec))

(defn do-command [options args])
