# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.

ANS) Method Overloading:  In this case, the method inside the given class uses the same name, but with different parameters and difeerent return types. Here inheritance is not a factor, where to save compile time and increase program efficiency. Example: in class calculator, we could have both add(int a,int b) and add(int a,int b,int c), etc.
- Method Overriding: In this case the method is same, with parameter lists being the same as well as the return types being same. This occurs between parent and child classes and usually occurs during inheritance of the same method from the parent class by the child class where if in the specific same method we need to change some specific outputs for the child class in special we need '@Overriding' helping in runtime. Example: in parent class employee prints 'Employee' then in child class of same let's say nurse using same method we override and print 'Nurse'.


Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?

ANS)  Wrapper classes provide object representations of Java's primitive data types, such as Integer for int, Double for double, etc.and its purpose is to convert primitive datatypes into objects and used in collections for better utility.
Java collections usually hold objects in themselves not the primitive datatypes directly so using wrapper class those datatypes are autoboxed into objects and then stored in the Java collections.



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

ANS) FileWriter: It is designed specifically for writing text (character data). It allows you to write strings and characters directly without worrying about converting them into bytes. Because of this, it is generally the preferred choice when working with text files such as logs, reports, configuration files, student records, or any other human-readable content.
- FileOutputStream: It is designed for writing raw byte data. It works at a lower level and does not distinguish between text and non-text data. When writing text using a FileOutputStream, you must first convert the text into a byte array, usually with getBytes(). Since it operates on bytes, it is commonly used for binary files such as images, audio files, videos, PDFs, and other formats where the exact byte representation matters.




