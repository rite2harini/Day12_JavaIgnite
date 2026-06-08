# Day12_JavaIgnite
Differentiate between:

Method Overloading

Method Overriding

Provide one example scenario for each.

ANSWER:-

-> Method Overloading
       -> Same method name is used with different parameters.
       -> It happens in the same class.
       -> It is used to perform similar tasks in different ways.
          Example: 
              A calculator has:
                add(int a, int b)
                add(int a, int b, int c)
       -> Both methods add numbers but with different parameters.
-> Method Overriding
         -> Child class provides its own version of a parent class method.
         ->Used in inheritance.
         -> It helps achieve runtime polymorphism.
              Example:
                  Animal class has sound() method.
                  Dog class overrides it and prints "Bark".


Question 2

What is the purpose of Wrapper Classes?

Why can't we directly use primitive data types in some Java collections?

ANSWERS:
-> Purpose of Wrapper Classes
        -> Wrapper classes convert primitive data types into objects.
             Examples:
                  int → Integer
                  double → Double
                  char → Character
-> Why can't we directly use primitive data types in some Java collections?
           -> Java collections like ArrayList store only objects, not primitive data types.
              Wrong:
                  ArrayList<int> list;
              Correct:
                  ArrayList<Integer> list;
           -> So wrapper classes are used to store primitive values in collections.

Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?



Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?

ANSWER:-
-> FileWriter
     -> Used to write text data into a file.
     -> Suitable for characters and strings.
           Example: Writing names, messages, reports.
-> FileOutputStream
       -> Used to write binary data into a file.
       -> Suitable for images, audio files, and byte data.
       -> Works with bytes.
-> When would you choose one over the other?
       -> Use FileWriter when writing text.
       -> Use FileOutputStream when writing binary or byte data.
-> Inheritance (Real-World Example)
          -> A Car is a Vehicle.
             Vehicle has:
               speed
               fuel
-> Car can use these properties and also have its own features like:
               -> numberOfDoors
           -> So Car inherits properties from Vehicle.
-> How does inheritance help reduce code duplication?
            -> Common code is written only once in the parent class.
            -> Example: If speed and fuel are already in Vehicle class, we do not need to write them again in Car, Bus, or Bike classes.
            -> This saves time and makes code easier to maintain.


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
ANSWER:- Bark

Explain why.
ANSWER:- This is an example of Method Overriding and Runtime Polymorphism.


