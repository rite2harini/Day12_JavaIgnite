# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.




Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?



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

### 1. Method Overloading vs. Method Overriding

Method overloading occurs within a single class when multiple methods share the exact same name but have different parameter lists. This allows a method to handle varying types or amounts of input, and it represents compile-time polymorphism because the compiler knows exactly which version to call based on the arguments provided. A common scenario for overloading is a payment processing system that contains one method accepting a standard credit card number and an overloaded version accepting a third-party digital wallet ID.

Method overriding occurs between a parent class and a child class when the child provides a specific, customized implementation for a method that is already defined in its parent. It represents runtime polymorphism because the actual method executed depends on the object created at runtime. A scenario for overriding is a generic Employee class with a method to calculate monthly salary, which is then overridden by a Manager subclass to also factor in a percentage-based performance bonus.

### 2. Wrapper Classes and Java Collections

Wrapper classes exist in Java to convert raw primitive data types, such as standard integers or booleans, into full-fledged objects. They provide a protective "wrapper" around the primitive value, giving it an object reference and granting it access to helpful built-in utility methods.

This conversion is strictly necessary because the Java Collections Framework, which includes dynamic data structures like ArrayLists and HashMaps, is designed exclusively to work with objects. Primitive data types merely hold raw values in memory and lack the object references required by these collections to perform their sorting, searching, and memory allocation operations. By wrapping a primitive `int` into an `Integer` object, the collection can safely store and manipulate the data using Java generics.

### 3. FileWriter vs. FileOutputStream

FileWriter and FileOutputStream are both used to write data to files, but they operate on completely different streams of data. FileWriter is a character-oriented stream specifically designed to write human-readable text. It automatically handles character encoding and translates your Java strings into the appropriate text format. FileOutputStream is a byte-oriented stream that writes raw, untranslated binary data directly to the file system one byte at a time.

You should choose a FileWriter whenever you are generating string data that needs to be opened and read by people, such as simple text documents, CSV files, or application error logs. You must choose a FileOutputStream when you are dealing with non-text binary files, such as saving a downloaded image, generating an audio file, or compiling a PDF document, where character encoding would corrupt the data.

### 4. Inheritance and Code Duplication

Inheritance establishes an "is-a" relationship between concepts, allowing a new specialized class to automatically absorb the attributes and behaviors of an existing broader class. A real-world example is an electronics store inventory system. You might have a generic parent class called ElectronicDevice that contains universally shared properties like brand name, price, and power state. Child classes like Laptop, Smartphone, and Television would extend this parent class.

Inheritance drastically reduces code duplication by centralizing shared logic. Instead of writing the code to apply a store discount or toggle the power state inside every single product category, you write that logic exactly once inside the ElectronicDevice parent class. Every child class instantly inherits those exact capabilities for free, leaving the programmer to only write code for highly unique features, such as a Laptop tracking its battery percentage or a Television tracking its screen resolution.

### 5. Predicting Polymorphic Output

The output of the provided code snippet will be the word "Bark".

This happens because of a core object-oriented concept known as runtime polymorphism, also referred to as dynamic method dispatch. In the code, the reference variable "a" is declared as the parent type Animal, but the actual object created in memory using the "new" keyword is a Dog. During compilation, the Java compiler looks at the Animal class just to verify that a method named `sound()` actually exists. However, during runtime, the Java Virtual Machine ignores the reference type and looks strictly at the actual object residing in memory. Since the object physically created was a Dog, the JVM executes the Dog class's specific, overridden version of the sound method instead of the parent's generic version.

