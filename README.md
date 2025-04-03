---
Title: "Java OOP Concepts with Examples"
Author: "ChatGPT, @theFlyingRaijin"
Date: "2025-02-18"
---

# Java OOP Concepts with Examples

This document provides a comprehensive overview of core Object-Oriented Programming (OOP) concepts in Java along with code examples for each concept.

## Table of Contents
1. [Classes and Objects](#classes-and-objects)
2. [Encapsulation](#encapsulation)
3. [Inheritance](#inheritance)
4. [Polymorphism](#polymorphism)
   - [Method Overloading](#method-overloading)
   - [Method Overriding](#method-overriding)
5. [Abstraction](#abstraction)
   - [Abstract Classes](#abstract-classes)
   - [Interfaces](#interfaces)
6. [Composition and Aggregation](#composition-and-aggregation)
7. [Constructors and Initialization](#constructors-and-initialization)
8. [The `final` Keyword](#the-final-keyword)


## OOP Concepts in Java - Summary Table

| **OOP Concept**       | **Explanation**                                                                 | **Achieved in Java By**                                                                 |
|------------------------|----------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| **Class**             | Blueprint for creating objects that encapsulate data and behavior               | Using the `class` keyword                                                               |
| **Object**            | Instance of a class; represents a real-world entity                            | Instantiated using the `new` keyword                                                    |
| **Encapsulation**     | Hiding internal state and requiring access through methods                     | `private` fields + `public` getter/setter methods                                       |
| **Inheritance**       | One class inherits properties and behaviors from another class                 | Using the `extends` keyword for classes                                                 |
| **Polymorphism**      | One interface, many implementations (same method behaves differently)          | Method **overloading** and **overriding**, dynamic method dispatch                      |
| **Abstraction**       | Hiding implementation details and showing only essential features              | Using **abstract classes** (`abstract` keyword) and **interfaces** (`interface` keyword)|
| **Method Overloading**| Compile-time polymorphism; multiple methods with the same name but different parameters | Defining multiple methods in the same class with different signatures                   |
| **Method Overriding** | Run-time polymorphism; subclass provides specific implementation              | Using `@Override` annotation and redefining parent methods in child classes             |
| **Composition**       | Strong "has-a" relationship; contained object cannot exist without the container| Declaring other class objects as fields and instantiating them inside the class         |
| **Aggregation**       | Weak "has-a" relationship; contained object can exist independently            | Passing objects as parameters or initializing via constructors                          |
| **Constructor**       | Special method to initialize object state at creation                          | Defining a method with the same name as the class and no return type                    |
| **`final` Keyword**   | Restricts modification to classes, methods, or variables                       | Using `final` before variables, methods, or classes                                     |

---

## 1. Classes and Objects
**Concept:**
A *class* is a blueprint for creating objects. It defines the object's state (attributes) and behavior (methods). An *object* is an instance of a class.

**Example:**

```java
public class Car {
    // Attributes
    private String model;
    private int year;
    
    // Constructor
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
    
    // Method to display car information
    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2020);
        myCar.displayInfo();
    }
}
```

## 2. Encapsulation

**Concept:**  
Encapsulation involves bundling data (attributes) and methods (behavior) into a single unit—a class—and restricting direct access to some of its components. This is achieved using access modifiers like private and public.

**Example:**  

```java

public class Employee {
    // Private attributes
    private String name;
    private double salary;
    
    // Getter and Setter methods to access and modify the attributes
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

## 3. Inheritance

**Concept:**  
Inheritance allows a class (child/subclass) to inherit properties and methods from another class (parent/superclass), promoting code reuse and creating a natural hierarchy between classes.

**Example:**  

```java
// Parent class
public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}


// Child class extending Animal
public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();   // Inherited method from Animal
        myDog.bark();  // Method specific to Dog
    }
}
```

## 4. Polymorphism

**Concept:**  
Polymorphism allows objects to be treated as instances of their parent class, letting a single interface represent different underlying forms (data types).

Method Overloading
**Concept:**  

Method overloading occurs when multiple methods in the same class share the same name but have different parameter lists.

**Example:**  

```java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}
```

Method Overriding

**Concept:**  
Method overriding happens when a subclass provides its own implementation of a method that is already defined in its superclass.

**Example:** 

```java

public class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Cat();
      
        myAnimal.sound();  // Outputs: Meow
    }
}
```

## 5. Abstraction

**Concept:**  
Abstraction hides complex implementation details and exposes only the essential features of an object. Java supports abstraction through abstract classes and interfaces.

Abstract Classes

**Concept:**  
An abstract class cannot be instantiated and can include abstract methods (without implementations) that must be defined by its subclasses.

**Example:**  

```java

public abstract class Shape {
    // Abstract method to calculate area
    public abstract double area();
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```

Interfaces

**Concept:**  
Interfaces declare a contract by specifying abstract methods that implementing classes must override. A class can implement multiple interfaces.

**Example:** 

```java
public interface Drawable {
    void draw();
}

public class Rectangle implements Drawable {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
```

## 6. Composition and Aggregation
**Concept:**  

Composition: A strong "has-a" relationship where the lifetime of the contained object is controlled by the container (e.g., a Car has an Engine).
Aggregation: A weaker "has-a" relationship where the contained object can exist independently (e.g., a University has Departments).
Composition **Example:**  

```java
public class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

public class Car {
    // Composition: Car owns an Engine
    private Engine engine;
    
    public Car() {
        engine = new Engine();
    }
    
    public void startCar() {
        engine.start();
        System.out.println("Car started.");
    }
}
```

Aggregation **Example:**  

```java

import java.util.List;

public class Department {
    private String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

public class University {
    // Aggregation: University has multiple Departments
    private List<Department> departments;
    
    public University(List<Department> departments) {
        this.departments = departments;
    }
    
    public void displayDepartments() {
        for (Department dept : departments) {
            System.out.println(dept.getName());
        }
    }
}
```

## 7. Constructors and Initialization
**Concept:**  
Constructors are special methods used to initialize new objects. They have the same name as the class and no return type.

**Example:**  

```java
public class Person {
    private String name;
    
    // Constructor to initialize the Person object
    public Person(String name) {
        this.name = name;
    }
    
    public void display() {
        System.out.println("Name: " + name);
    }
}

```

##  8. The final Keyword

**Concept:**  
The final keyword is used to restrict modification:

Final Variables: Once assigned, they cannot be reassigned.
Final Methods: Cannot be overridden by subclasses.
Final Classes: Cannot be subclassed.

**Example:**  

```java
public final class Constants {
    public static final double PI = 3.14159;
}
```
