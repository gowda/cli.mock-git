(ns tools.cli.mock-git
  (require [tools.cli.mock-git
            [utils :as utils]
            [help :as help]
            [remote :as remote]])
  (use [tools.cli.mock-git.commands :only [spec]]
       [clojure.tools.cli :only [parse-opts]]))

(def options-spec
  [[nil "--version" "Print the Git suite version."]
   [nil "--help" "Print the synopsis and a list of commonly used commands."]
   ["-C <path>" nil
    (str "Run as if git was started in <path> "
         "instead of current working directory.")
    :id :working-directory]
   ["-c <name>=<value>" nil "Pass a configuration parameter to the command."
    :id :config-params]
   [nil "--exec-path[=<path>]"
    "Path to wherever your core Git programs are installed."]
   [nil "--html-path"
    "Print the path to Git's HTML docs installation directory and exit."]
   [nil "--man-path" "Print the manpath to man pages of Git and exit."]
   [nil "--info-path" "Print the path to Info files of Git and exit."]
   ["-p" "--paginate"
    "Piple all output into less if standard output is a terminal."]
   [nil "--no-pager" "Do not pipe Git output into a pager."]
   [nil "--no-replace-objects"
    "Do not use replacement refs to replace Git objects."]
   [nil "--bare" "Treat the repository as a bare repository."]
   [nil "--git-dir=<path>" "Set the path to the repository."]
   [nil "--work-tree=<path>" "Set the path to the working tree."]
   [nil "--namespace=<name>" "Set the Git namespace."]])

(defn usage []
  (utils/build-options-summary
   nil
   (str "A demonstration application for command-line options "
        "parsing using \nclojure's tools.cli library.")
   options-spec
   spec))

(defn -main [& args]
  (let [{:keys [options arguments errors summary]}
        (parse-opts args options-spec :in-order true)]
    (case (first arguments)
      "help" (help/do-command options (rest args))
      "remote" (remote/do-command options (rest args))
      (println (usage)))))
