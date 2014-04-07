(ns tools.cli.mock-git.remote.show
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote [-v | --verbose] show [-n] <name>...
(def options-spec
  [["-n" nil "Do not query remote heads, use cached information."
    :id :no-query-remote]])

(defn summary []
  (utils/build-options-summary
   "remote show"
   (utils/get-description "show" spec)
   options-spec))

(defn do-command [options args])
