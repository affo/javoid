(ns romans.core)

(def value-map 
  {
    "I" 1
    "V" 5
    "X" 10
    "L" 50
    "C" 100
    "D" 500
    "M" 1000
  })

(def validation-re #"^[MDCLXVI]+$")

(defn valid?
    "Performs validation in terms of accepted characters"
    [roman]
    (re-find validation-re roman))

(defn do-parse
    [roman]
    (loop [to-parse      roman
           prev          0
           acc           0
           count-equals  0]
      (let [[h & t] to-parse
            n       (get value-map (str h))]
        (if (nil? h)
          acc
          (cond
            (< n prev) (recur t n (+ acc n) 0)
            (= n prev) (if (> (inc count-equals) 3)
                         (throw (Exception. (str "Not valid: bigger then 3 group of " h)))
                         (recur t n (+ acc n) (inc count-equals)))
            (> n prev) (recur t n (- (+ n acc) (* 2 prev))  0))))))

(defn parse
    [roman]
    (if (not (valid? roman))
      (throw (Exception. (str "Not a valid number: " roman)))
      (do-parse roman)))

