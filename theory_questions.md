# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.
Method Overloading-in method overloading there aresame methods with diffrent parameters.
                    example-add(int a,int b) and add(int a,int b,int c) even add(double a , double b , double c)

Method Overriding- it is type of calliing the same methods again and again in diffrent classlike in a parent class and its children classstoo
                    example -class Employee {
                                void role() {
		                            System.out.println("Employee");
	                            }
                            }
                            class doc extends Employee {
                                void role() {
		                            System.out.println("Doctor");
	                            }
                            }



Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?

Wrapper classes provide object representations of Java's primitive data types, such as Integer for int, Double for double, etc.and its purpose is to convert primitive datatypes into objects and used in collections for better utility.
Java collections usually hold objects in themselves not the primitive datatypes directly so using wrapper class those datatypes are autoboxed into objects and then stored in the Java collections.



Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?

FileWriter: It is designed specifically for writing text (character data). It allows you to write strings and characters directly without worrying about converting them into bytes. Because of this, it is generally the preferred choice when working with text files such as logs, reports, configuration files, student records, or any other human-readable content.
- FileOutputStream: It is designed for writing raw byte data. It works at a lower level and does not distinguish between text and non-text data. When writing text using a FileOutputStream, you must first convert the text into a byte array, usually with getBytes(). Since it operates on bytes, it is commonly used for binary files such as images, audio files, videos, PDFs, and other formats where the exact byte representation matters.




Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?
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



