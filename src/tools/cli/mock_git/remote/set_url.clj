(ns tools.cli.mock-git.remote.set-url
  (require [tools.cli.mock-git.utils :as utils])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

;; git remote set-url [--push] <name> <newurl> [<oldurl>]
;; git remote set-url --add [--push] <name> <newurl>
;; git remote set-url --delete [--push] <name> <url>
(def options-spec
  [[nil "--push" "Manipulate only push URLs, instead of fetch URLs."]
   [nil "--add" "Add new URL, instead of changing URL."]
   [nil "--delete" "Delete all URLs matching regex <url>."]])

(defn summary []
  (utils/build-options-summary
   "remote set-url"
   (utils/get-description "set-url" spec)
   options-spec))

(defn do-command [options args])
