# Day12_JavaIgnite
Differentiate between:
Method Overloading
Method Overriding
Provide one example scenario for each.
ANS:

Method Overloading
Same method name but different parameters.
Occurs within the same class.
Inheritance is not required.
Compile-time polymorphism.
EX-
class Demo {
    void show() {
        System.out.println("No parameter");
    }

    void show(int a) {
        System.out.println("One parameter");
    }
}
Method Overriding
Same method name and same parameters.
Occurs between parent and child classes.
Inheritance is required.
Runtime polymorphism.
EX-
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




Question 2

What is the purpose of Wrapper Classes?
Why can't we directly use primitive data types in some Java collections?
ANS:
Uses of Wrapper Classes
Required in Collections Framework.
Provide utility methods.
Support conversion between data types.
Enable autoboxing and unboxing.

Java Collections such as ArrayList, LinkedList, HashSet, and HashMap store objects, not primitive data types.


Question 3

Differentiate between:
FileWriter
FileOutputStream
When would you choose one over the other?
Explain Inheritance using a real-world example.
How does inheritance help reduce code duplication?

ANS:

Difference Between FileWriter and FileOutputStream
FileWriter:
1. Used to write text (character) data.
2. It is a character stream class.
3. Suitable for text files such as .txt.
4. Writes data in the form of characters.
5. Automatically handles character encoding.
FileOutputStream:
1. Used to write binary data.
2. It is a byte stream class.
3. Suitable for images, audio, video, and PDF files.
4. Writes data in the form of bytes.
5. Does not handle character encoding automatically.


//FileWriter is used when writing text data to a file.

FileOutputStream is used when writing binary data such as images, audio, or PDF files.

//Inheritance is a mechanism where one class acquires the properties and methods of another class.

Example: A Car inherits common features like start() and stop() from a Vehicle class.


//Common code is written once in the parent class.

Child classes reuse that code instead of rewriting it, reducing duplication and improving maintainability.

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

ANS:
Output:

Bark

Dog overrides the sound() method of Animal. Although a is a reference of type Animal, it refers to a Dog object. Therefore, at runtime, the sound() method of the Dog class is called. This is an example of method overriding (runtime polymorphism).


