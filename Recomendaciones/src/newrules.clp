(import recomendaciones.model.*)

(deftemplate Person (declare (from-class Person)))
(deftemplate Test (declare (from-class Test)))
(deftemplate FoundPersonality (declare (from-class FoundPersonality)))

(bind ?a 0)
(bind ?b 0)
(bind ?c 0)
(bind ?d 0)

(defrule test-question1
    "Get answer from question 1"
    ?t <- (Test {q1 == 1})
    =>
    (+ ?c ?t))

(defrule test-question2
    "Get answer from question 2"
    ?t <- (Test {q2 == 1})
    =>
    (+ ?a ?t))

(defrule test-question3
    "Get answer from question 3"
    ?t <- (Test {q3 == 1})
    =>
    (+ ?b ?t))

(defrule test-question4
    "Get answer from question 4"
    ?t <- (Test {q4 == 1})
    =>
    (+ ?d ?t))

(defrule test-question5
    "Get answer from question 5"
    ?t <- (Test {q5 == 1})
    =>
    (+ ?a ?t))

(defrule test-question6
    "Get answer from question 6"
    ?t <- (Test {q6 == 1})
    =>
    (+ ?c ?t))

(defrule test-question7
    "Get answer from question 7"
    ?t <- (Test {q7 == 1})
    =>
    (+ ?b ?t))

(defrule test-question8
    "Get answer from question 8"
    ?t <- (Test {q8 == 1})
    =>
    (+ ?c ?t))

(defrule test-question9
    "Get answer from question 9"
    ?t <- (Test {q9 == 1})
    =>
    (+ ?d ?t))

(defrule test-question10
    "Get answer from question 10"
    ?t <- (Test {q10 == 1})
    =>
    (+ ?a ?t))

(defrule test-question11
    "Get answer from question 11"
    ?t <- (Test {q11 == 1})
    =>
    (+ ?b ?t))

(defrule test-question12
    "Get answer from question 12"
    ?t <- (Test {q12 == 1})
    =>
    (+ ?d ?t))

(defrule test-question13
    "Get answer from question 13"
    ?t <- (Test {q13 == 1})
    =>
    (+ ?c ?t))

(defrule test-question14
    "Get answer from question 14"
    ?t <- (Test {q14 == 1})
    =>
    (+ ?a ?t))

(defrule test-question15
    "Get answer from question 15"
    ?t <- (Test {q15 == 1})
    =>
    (+ ?b ?t))

(defrule test-question16
    "Get answer from question 16"
    ?t <- (Test {q16 == 1})
    =>
    (+ ?c ?t))

(defrule test-question17
    "Get answer from question 17"
    ?t <- (Test {q17 == 1})
    =>
    (+ ?d ?t))

(defrule test-question18
    "Get answer from question 18"
    ?t <- (Test {q18 == 1})
    =>
    (+ ?b ?t))

(defrule test-question19
    "Get answer from question 19"
    ?t <- (Test {q19 == 1})
    =>
    (+ ?d ?t))

(defrule test-question20
    "Get answer from question 20"
    ?t <- (Test {q20 == 1})
    =>
    (+ ?a ?t))


(defrule recommend-ESTJ-1
    "Recommend some themes for personality ESTJ"
    (Person {personality == "ESTJ"})
    =>
    (add (new Theme "Fiction")))

(defrule recommend-ESTP
    "Recommend some themes for personality ESTP"
    (Person {personality == "ESTP"})
    =>
    (add (new Theme "Graphic Novels")))

(defrule recommend-ESTP-1
    "Recommend some themes for personality ESTP"
    (Person {personality == "ESTP"})
    =>
    (add (new Theme "Comics")))

(defrule recommend-INTP
    "Recommend some themes for personality INTP"
    (Person {personality == "INTP"})
    =>
    (add (new Theme "Science")))

(defrule recommend-INTP-1
    "Recommend some themes for personality INTP"
    (Person {personality == "INTP"})
    =>
    (add (new Theme "Crime")))

