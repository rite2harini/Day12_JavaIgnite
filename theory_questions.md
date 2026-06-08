# Day12_JavaIgnite
Differentiate between:

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

Provide one example scenario for each.




Question 2

What is the purpose of Wrapper Classes?
A Wrapper Class is a built-in Java class that wraps  a raw value inside a full Java object. 
Why can't we directly use primitive data types in some Java collections?



Question 3

Differentiate between:

FileWriter

FileOutputStream

When would you choose one over the other?



Explain Inheritance using a real-world example.

How does inheritance help reduce code duplication?
it helps to reduce code dupliucation as the common parts the common codes is written in parent folder and which the codes will be diffred but will remain in same context can be written in the child code and the same part is not required to write it again as it 

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
Bark
Explain why.
here we call the object new dog so the codes which is below the class dog will be executed.
here we called the object dog which is inside the animal class


