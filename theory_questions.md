# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.

Method Overloading                                                Method Overriding
Same method name with different parameter lists.           Same method name and same parameters in parent and child classes.
Occurs within the same class.                             Occurs between parent and child classes.
Used to perform similar operations with different inputs. Used to provide a specific implementation of a parent class method.
Compile-time polymorphism.                                    Run-time polymorphism.
Inheritance is not required.                                   Inheritance is required.
Example scenario for method overloading  
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
Example scenaario for method overriding
class Employee {
    void displayRole() {
        System.out.println("Employee");
    }
}

class Doctor extends Employee {
    @Override
    void displayRole() {
        System.out.println("Doctor");
    }
}

Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?
Wrapper Classes convert primitive data types into objects. They allow primitive values to be used where objects are required and provide useful methods for data conversion and manipulation.
Java Collections (such as ArrayList, LinkedList, HashMap) can store only objects, not primitive data types. Therefore, wrapper classes must be used instead of primitives.

Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?

FileWriter                                                      FileOutputStream
Used to write character/text data to a file.                Used to write binary data (bytes) to a file.
Works with characters.                                          Works with bytes.
Suitable for text files (.txt).                         Suitable for binary files such as images, audio, PDFs, etc.
Methods: write(String)                                           Methods: write(byte[])
Automatically handles character-to-byte conversion.          Requires conversion of text into bytes using getBytes().

Use FileWriter when writing text data such as names, marks, employee details, or reports.
Use FileOutputStream when writing binary data such as images, audio files, videos, or when working directly with bytes.

Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?
Inheritance is a mechanism in Java where one class acquires the properties and methods of another class.
Real-world example:
Consider a Vehicle class.
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
Here, Car inherits the start() method from Vehicle. So a car can use both its own methods and the inherited methods.
Output:
Vehicle starts
Car is driving
Inheritance allows common properties and methods to be written once in a parent class and reused by multiple child classes.
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
Output:Bark
Dog overrides the sound() method of Animal.
a is a reference variable of type Animal, but it refers to a Dog object (new Dog()).
In Java, overridden methods are resolved at runtime (Runtime Polymorphism/Dynamic Method Dispatch).
Therefore, the Dog class's sound() method is called.
Why not "Animal Sound"?
Because the actual object created is Dog, and Java executes the overridden method of the object type, not the reference type.
Reference Type: Animal
Object Type: Dog


