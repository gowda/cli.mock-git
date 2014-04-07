(ns tools.cli.mock-git.help
  (require [tools.cli.mock-git
            [utils :as utils]
            [remote :as remote]])
  (use [tools.cli.mock-git.commands :only [spec]]))

(defn summary []
  (utils/build-options-summary
   "help"
   (utils/get-description "help" spec)
   nil
   spec))

(defn do-command [options args]
  (let [summary (case (first args)
                  "remote" (remote/summary)
                  (summary))]
    (println summary)))

