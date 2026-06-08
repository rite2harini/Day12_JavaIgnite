# Day12_JavaIgnite
Differentiate between:

Method Overloading
Method Overloading means having multiple methods with the same name in the same class, but with different parameters.
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
Method Overriding
Method Overriding means a child class gives its own implementation of a method already present in the parent class.
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

Provide one example scenario for each.




Question 2

What is the purpose of Wrapper Classes?
Wrapper classes convert primitive data types into objects.
int → Integer
char → Character
double → Double
boolean → Boolean

Why can't we directly use primitive data types in some Java collections?

Java collections like ArrayList, HashSet, and HashMap store objects, not primitive values. That is why we cannot directly store int, char, or double in collections.
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
Question 3

Differentiate between:

FileWriter
FileWriter is used to write character/text data into a file.
FileOutputStream
FileOutputStream is used to write binary data into a file.
When would you choose one over the other?

Choose FileWriter when working with text files.
Choose FileOutputStream when working with binary files like images or videos.


Explain Inheritance using a real-world example.
Inheritance means one class can acquire the properties and methods of another class.
A Vehicle has common features like speed, fuel, and start method. A Car is also a vehicle, so it can inherit these common features from Vehicle.
class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}
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
Here, reference variable is of type Animal, but the actual object is of type Dog.

In Java, method overriding is decided at runtime based on the actual object. Since the object is Dog, the Dog class sound() method is called.

This is called runtime polymorphism or dynamic method dispatch.


