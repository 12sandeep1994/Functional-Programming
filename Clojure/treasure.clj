(ns clojure.examples.clojure
    (:require [clojure.string :as str]))
    ;;(:gen-class))
    (use '[clojure.string :only (split trim)])
    
    

;;(println "OMDEVARUAMMAAKKA")



(defn readFile []
    (def graph (slurp "map.txt"))
    ;;(def graph (trim graph))
    (println graph)
    (def g (str/split graph #"\s"))
    (def g (to-array (str/split graph #"\n")))
    (def cols  (count (trim (aget g 0))))
    ;;(print cols)
    (def rows (count g))
    (doseq [y (range rows)]
        ;;(print(aget g y ))
        (if (not= (count  (aget g y))  cols)
        (do
        (println "Improper Input")
        (System/exit 0))
        )
    )
    
    ;;(println (count (str/split graph #" ")))
  
    ;;(println rows)
    ;;println
    ;;(def h (to-array-2d (partition 14  (str/split graph #""))))
    (def h (to-array-2d (partition cols   (filter #(not (str/blank? %))
                                             (str/split graph #"")))))

     ;;(println rows)
     ;;(println "ArrayLEngth")
     ;;(println (alength h))
     (if (not= rows (alength h)) 
        (do
                 (println "Improper Input")
                 (System/exit 0))
    )
    ;  (doseq [x (range rows)
    ;  y (range cols)]
     
   



    ; (print(aget h x y ))
     
    ; (if (= y (dec cols)) 
    ;    (println))
    ; )

    
     (doseq [y (range rows)]
        ; (println (alength (aget h y)))
        ; (println "index")
        ; (println y)
        ; (if (not= (alength (aget h y))  cols)
        ; (do
        ;     (println "Improper Input")
        ;     (System/exit 0))
        ; )
    )
    ;;(def h (to-array-2d (partition 13  (remove #{\a} g ))))
    ;;(def h (to-array-2d (partition 13  g )))
    ;;(partition 13 (map #(Integer/parseInt %) (clojure.string/split nums #" ")))
    ;;(println  (aget h 0 0 ))
    ;;(println  (aget h 7 12 ))
    ;;(println (= "@" (aget h 1 0 )))
    )
;;(def hello(to-array-2d (str/split graph #"\\n+")))


(defn changeMaze[p t]
    (loop [i p
           j t]
        ;    (println "IN LOOP")
        ;    (println "I")
        ;    (println i)
        ;    (println "I")
        ;    (println j)
        ;(println(aget h i j ))
        ; (if (= i 9999)
            
        ;     (do
        ;         (println "NO SOLUTION")
        ;         (doseq [x (range 8)
        ;           y (range 13)]
        ;           (print(aget h x y ))
        ;         )
        ;         (println)
        ;         (System/exit 0)
        
        ; ))
        ; (if (== 0 i)
        ;    (do
        ;          (print "NILLLL")
        ;          (doseq [x (range 8)
        ;          y (range 13)]
        ;          (print(aget h x y ))
        ;          )
        ;          (System/exit 0)
        ;      )9999
        ;  )

        (if (= "#" (aget h 0 0 ))
            (do
                (println "Uh oh, I could not find the treasure :-(")
                (doseq [x (range rows)
                        y (range cols)]
                (print(aget h x y ))
                (if (= y (dec cols))
                   (println))
                )
                (println)
                (System/exit 0)
            ))

        (if (= i 9999)
        
                (do
                    (println "Uh oh, I could not find the treasure :-(")
                    (aset h 0 0 "!")
                    (doseq [x (range rows)
                      y (range cols)]
                      
                     (print(aget h x y ))
                      
                     (if (= y (dec cols)) 
                        (println))
                     )
                    (println)
                   (System/exit 0)
                
                ) 
        )
        (if (= "@" (aget h i j ))
            (do
                (println "Woo hoo, I found the treasure :-)")
                (doseq [x (range rows)
                        y (range cols)]
                (print(aget h x y ))
                (if (= y (dec cols))
                   (println))
                )
                (println)
                (System/exit 0)
            ))
       
            (if(and (< (inc i) rows)  (= "-" (aget h (inc i) j )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (inc i) (int j))))
            
            (if(and (< (inc j) cols)  (= "-" (aget h i (inc j) )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (inc j))))
            
            (if(and (>= (dec j) 0)  (= "-" (aget h i (dec j) )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (dec j))))

            (if(and (>= (dec i) 0)  (= "-" (aget h (dec i) j )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (dec i) (int j))))
            
            (if(and (< (inc i) rows)  (= "@" (aget h (inc i) j )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (inc i) (int j))))
            
            (if(and (< (inc j) cols)  (= "@" (aget h i (inc j) )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (inc j))))

            (if(and (>= (dec j) 0)  (= "@" (aget h i (dec j) )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (dec j))))

            (if(and (>= (dec i) 0)  (= "@" (aget h (dec i) j )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "+")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (dec i) (int j))))

            (if(and (< (inc i) rows)  (= "+" (aget h (inc i) j )))
                     (do
                     ;;(print "HELOO")
                     (aset h i j "!")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (inc i) (int j))))
            
            (if(and (< (inc j) cols)  (= "+" (aget h i (inc j) )))
                     (do
                    ;;(print "HELOO")
                     (aset h i j "!")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (inc j))))

            (if(and (>= (dec j) 0)  (= "+" (aget h i (dec j) )))
                     (do
                     ;;(print "HELOO")
                     (aset h i j "!")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (int i) (dec j))))

            (if(and (>= (dec i) 0)  (= "+" (aget h (dec i) j )))
                     (do
                     ;;(print "HELOO")
                     (aset h i j "!")
                     ;;(println "Afer Setting")
                     ;;(println (aget h i j ))
                     (changeMaze (dec i) (int j))))
            
          ;;)
          (changeMaze 9999 9999)
                    
            ;;)
        )
    )
(readFile)
(changeMaze 0 0)
    
