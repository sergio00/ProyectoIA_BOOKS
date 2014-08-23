(import recomendaciones.model.Person)
(import recomendaciones.model.Theme)
(deftemplate Person (declare (from-class Person)))
;;SE DEFINE LAS PERSONALIDADES Y SEGUN ESO SE DEFINE EL TEMA DEL LIBRO
(defrule recommend-ESTJ
    "Recommend some themes for personality ESTJ"
    (Person {personality == "ESTJ"})
    =>
    (add (new Theme "Fantasy")))

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

