(ns tools.cli.mock-git.remote
  (require [tools.cli.mock-git.utils :as utils]
           [tools.cli.mock-git.remote
            [add :as add]
            [prune :as prune]
            [remove :as remove]
            [rename :as rename]
            [set-branches :as set-branches]
            [set-head :as set-head]
            [set-url :as set-url]
            [show :as show]
            [update :as update]])
  (use [tools.cli.mock-git.remote.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

(def options-spec
  [["-v" "--verbose"
    "Be a little more verbose and show remote url after name."]])

(defn summary []
  (utils/build-options-summary
   "remote"
   (utils/get-description "remote" spec)
   options-spec
   spec))

(defn get-help [subcommand]
  (let [summary-fn (case subcommand
                     "add" add/summary
                     "prune" prune/summary
                     "remove" remove/summary
                     "rename" rename/summary
                     "set-branches" set-branches/summary
                     "set-head" set-head/summary
                     "set-url" set-url/summary
                     "show" show/summary
                     "update" update/summary
                     summary)]
    (summary-fn)))

(defn print-usage [options args]
  (println "Unrecognized command: " (first args))
  (println (summary)))

(defn do-command [in-options in-args]
  (let [{:keys [options arguments errors summary]}
        (parse-opts in-args options-spec :in-order true)
        command (case (first arguments)
                  "add" add/do-command
                  "prune" prune/do-command
                  "remove" remove/do-command
                  "rename" rename/do-command
                  "set-branches" set-branches/do-command
                  "set-head" set-head/do-command
                  "set-url" set-url/do-command
                  "show" show/do-command
                  "update" update/do-command
                  "help" (do (println (get-help (second arguments)))
                             (System/exit 0))
                  print-usage)]
    (command options (rest arguments))))
