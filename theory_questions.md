# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.


Ans->>     Method Overloading	                                                        Method Overriding
          Same method name with different parameters in same class	                      Child class provides new implementation of parent class method
        	No                                                                             Yes
	   Must be different	                                                           Must be same
	   Can be same or different	                                                    Usually same
	  Compile-time polymorphism                                                      	Runtime polymorphism


Example of Method Overloading
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println(c.add(2, 3));
        System.out.println(c.add(2, 3, 4));
    }
}
Example of Method Overriding
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.sound();
    }
}



Question 2

What is the purpose of Wrapper Classes?

Ans->>>Wrapper classes convert primitive data types into objects.



Why can't we directly use primitive data types in some Java collections?
Ans->>.Java collections like ArrayList store objects, not primitive values.



Question 3

Differentiate between:

FileWriter

FileOutputStream


Ans->>	the difference between the filewriter and file ouput stream is written below 

FileWrite                                                     FileOutputStream
	Text files	                                                       Binary files
	Characters	 txt files                                           	Images, audio, pdf
	char	                                                               byte


When would you choose one over the other?

Ans->>>Choose FileWriter When:
Writing text
Creating notes/logs/text documents
Example of FileOutputStream
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        FileOutputStream fos =
                new FileOutputStream("data.bin");

        fos.write(65);

        fos.close();
    }
}
Choose FileOutputStream When:
Writing binary data
Storing images, videos, pdf files



Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?

Ans->Without inheritance:

Every class must write common code again.

With inheritance:

Common code is written once in parent class and reused by child classes.

Example:

If all vehicles have:

start()
stop()
fuel()

these methods are written once in Vehicle class.

All child classes reuse them.


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
Ans->

Bark
Explanation
a is reference of parent class Animal.
Object created is of child class Dog.

Java checks the object type at runtime.

Since object is Dog, overridden method in Dog class is called.

This is called:

Runtime Polymorphism
Dynamic Method Dispatch


