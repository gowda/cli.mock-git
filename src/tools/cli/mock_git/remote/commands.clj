(ns tools.cli.mock-git.remote.commands)

(def spec
  [["add" "Add a remote."]
   ["prune" "Delete all stale remote-tracking branches."]
   ["remove" "Remove a remote."]
   ["rename" "Rename a remote."]
   ["set-branches" "Change list of branches tracked by a remote. "]
   ["set-head" "Set or delete the default branch."]
   ["set-url" "Change URL remote points to."]
   ["show" "Give information about remote."]
   ["update" "Fetch updates for remote as defined in remotes.<group>."]])
