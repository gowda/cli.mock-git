(ns tools.cli.mock-git.utils
  (use [clojure.tools.cli :only [parse-opts]]))

(defn build-synopsis [options-spec]
  (->> (map (juxt first second) options-spec)
       (map (fn [option-spec]
              (->> (interpose "|" option-spec) (apply str))))
       (map #(str "[" % "]"))
       (interpose " ")
       (apply str)))

(defn build-commands-summary [commands-spec]
  (->> commands-spec
       (map (fn [[command description]]
              (str "\t" command "\t\t" description)))
       (interpose "\n")
       (apply str)))

(defn build-options-summary [command description options-spec & commands-spec]
  (let [commands-summary (if commands-spec
                           (->> ["Supported commands:"
                                 (apply build-commands-summary commands-spec)
                                 ""]
                                (interpose "\n")
                                (apply str)))]
    (->> [(str "git " command ": " description)
          ""
          "Synopsis"
          (build-synopsis options-spec)
          ""
          commands-summary
          "Recognized options:"
          (-> (parse-opts [""] options-spec :in-order true) :summary)]
         (interpose "\n")
         (apply str))))

(defn filter-first [fn coll]
  (-> (filter fn coll) first))

(defn get-description [command commands-spec]
  (-> (filter-first #(= (first %) command) commands-spec)
      second))
