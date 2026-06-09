# Day12_JavaIgnite
Question 1
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.
Ans: Definition: Multiple methods in the same class with the same name but different parameter lists (number, type, or order of parameters).

Occurs within a single class

Compile-time polymorphism (static binding)

Inheritance not required

Parameters must differ

Definition: Redefining a parent class method in a child class with the same signature to provide specific implementation.

 Points:

Occurs between parent and child classes

Runtime polymorphism (dynamic binding)

Inheritance mandatory

Parameters must be exactly same






Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?
Ans:
Wrapper classes are classes that encapsulate primitive data types into objects. They are part of the java.lang package.
Purpose
Object Representation

Allow primitive types to be treated as objects

Essential for working with Collections framework (ArrayList, HashMap, etc.) which only accept objects


Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?



Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?


Important Interview Question - 

class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

Animal a = new Dog();
a.sound();

What will be the output?

Explain why.



