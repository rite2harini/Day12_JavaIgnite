# Day12_JavaIgnite
Differentiate between:

Method Overloading → Same function/Method but extra or less or different parameters

Method Overriding → Method Remains same in parent and child but inline/printing Statements are Different

Provide one example scenario for each.

EX : (Overloading)

    class Student {

    void displayResult() { //without any parameter
        System.out.println("Displaying current result");
    }

    void displayResult(String semester) { //same function with different parameter
        System.out.println("Displaying result of " + semester);
    }
}

EX: (Overriding)

 void showBookType() {//in Parent
        System.out.println("This is a Book");//may be normal or may be ebook
    }
    .......
 @Override
    void showBookType() {//In child
        System.out.println("This is an EBook");// as its type
    }


Question 2

What is the purpose of Wrapper Classes?
Ans : Wrapper classes convert primitive data types into objects or say use them as container

Why can't we directly use primitive data types in some Java collections?
Ans : Because Java have LinkedLists and ArrayLists etc which stores objects not primitive data types



Question 3

Differentiate between:

FileWriter
ANS: during compile time
FileOutputStream
ANS: during runtime
When would you choose one over the other?



Explain Inheritance using a real-world example.
EX: a child inherits all of it's properties from its parents

How does inheritance help reduce code duplication?
EX: as it helps in method reusability

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
first object declaration is not valid in java . 
refferd to Animal but objects of dog . so o/p will be bark



