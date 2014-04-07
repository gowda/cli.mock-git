(ns tools.cli.mock-git.remote.add
  (require [tools.cli.mock-git.utils :as utils])
  (use [clojure.tools.cli :only [parse-opts]]
       [tools.cli.mock-git.remote.commands :only [spec]]))

(def options-spec
  [["-t <branch>" nil "Create refspec to track only <branch>."
    :id :tracking-branch]
   ["-m <master>" nil "Set symbolic-ref refs/remotes/<name>/HEAD."
    :id :master-branch]
   ["-f" nil "Run 'git fetch' immediately."
    :id :fetch-name]
   [nil "--[no-]tags" "Import tags in remote repository."]
   [nil "--mirror <fetch|push>"
    (str "fetch - refs/ will mirror remote respository. "
         "push - 'git push' behaves as if --mirror was passed.")]])

(defn summary []
  (utils/build-options-summary
   "remote add"
   (utils/get-description "add" spec)
   options-spec))

(defn do-command [options args])
