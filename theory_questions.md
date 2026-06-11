# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.
Method Overloading

Method Overloading means having multiple methods with the same name but different parameters in the same class. It is used when we want to perform similar tasks in different ways. For example, in a library system, searchBook(int id) searches a book by ID and searchBook(String title) searches a book by title.

Method Overriding

Method Overriding means a child class provides its own version of a method that is already present in the parent class. The method name and parameters must be the same. For example, in a hospital system, the Doctor class overrides the displayRole() method of the Employee class to display "Doctor" instead of "Employee".




Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?
Wrapper Classes are used to convert primitive data types into objects. They allow primitive values like int, double, and char to be used as objects when needed in Java programs.
Java collections such as ArrayList, HashSet, and HashMap can store only objects, not primitive data types. Since primitives like int, double, and char are not objects, we use their Wrapper Classes (Integer, Double, Character, etc.) instead.



Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?
FileWriter

FileWriter is used to write text data to a file. It works with characters and is mainly used when we want to store words, sentences, or other text information in a file. For example, writing student names or employee details into a text file.

FileOutputStream

FileOutputStream is used to write binary data to a file. It works with bytes and is mainly used for storing data such as images, audio files, or other non-text data. It can also write text by converting it into bytes first.
Choose FileWriter when you need to store or write text data in a readable format, such as student records or employee details. Choose FileOutputStream when you need to store binary data or work directly with bytes, such as saving images, audio files, or other non-text files.



Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?
Inheritance is a feature in Java where one class gets the properties and methods of another class. For example, a Car and a Bike are types of Vehicle. So, the Car and Bike classes can inherit common features like speed and start() from the Vehicle class.
Inheritance helps reduce code duplication because common code is written only once in the parent class and reused by child classes. For example, if both Car and Bike need a start() method, it can be written in the Vehicle class and used by both, avoiding repeated code.


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
Output: Bark
a is a reference of type Animal, but it refers to a Dog object
When a.sound() is called, Java uses Method Overriding and executes the method of the actual object (Dog), not the reference type (Animal).



