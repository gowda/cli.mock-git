(ns tools.cli.mock-git.remote.prune
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

(def options-spec
  [["-n" "--dry-run" ""]])
;; <name>...

(defn summary []
  (utils/build-options-summary
   "prune"
   (utils/get-description "prune" spec)
   nil))

(defn do-command [options args])
