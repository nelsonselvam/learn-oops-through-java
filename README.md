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

## 2. Encapsulation

**Concept:**  
Encapsulation involves bundling data (attributes) and methods (behavior) into a single unit—a class—and restricting direct access to some of its components. This is achieved using access modifiers like private and public.

**Example:**  

```java

public class FinancialAccount {
    // Private attributes are "encapsulated" within the class.
    private String accountId;
    private double balance;

    // Public constructor
    public FinancialAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        // Use the setter to enforce rules during creation
        this.setBalance(initialBalance);
    }

    // Public "getter" method to safely expose the balance
    public double getBalance() {
        return this.balance;
    }

    // Public "setter" method provides controlled access to modify the balance
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            this.balance = newBalance;
        } else {
            // Protects the integrity of the object's state
            System.out.println("Error: Balance cannot be negative.");
        }
    }

    public String getAccountId() {
        return this.accountId;
    }
}

// How it's used:
// FinancialAccount myAccount = new FinancialAccount("ACC123", 500.00);
// System.out.println(myAccount.getBalance()); // Output: 500.0
// myAccount.setBalance(-100.00); // Output: Error: Balance cannot be negative.
// System.out.println(myAccount.getBalance()); // Output: 500.0 (The balance remains unchanged)
```

## 3. Inheritance

**Concept:**  
Inheritance allows a class (child/subclass) to inherit properties and methods from another class (parent/superclass), promoting code reuse and creating a natural hierarchy between classes.

**Example:**  

```java
// Parent class with common attributes and methods
public class Person {
    String name;
    String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Child class "inherits" from Person
public class FullTimeEmployee extends Person {
    private double annualSalary;

    public FullTimeEmployee(String name, String id, double annualSalary) {
        // "super" calls the parent class constructor
        super(name, id);
        this.annualSalary = annualSalary;
    }
}

// Another child class "inherits" from Person
public class Contractor extends Person {
    private double hourlyRate;

    public Contractor(String name, String id, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
    }
}
```

## 4. Polymorphism

**Concept:**  
Polymorphism allows objects to be treated as instances of their parent class, letting a single interface represent different underlying forms (data types).

Method Overloading

**Concept:**  
Method overloading occurs when multiple methods in the same class share the same name but have different parameter lists.

Method Overriding

**Concept:**  
Method overriding happens when a subclass provides its own implementation of a method that is already defined in its superclass.

**Example:** 

```java

// Let's modify the parent and child classes slightly
public abstract class Person { // Made abstract to enforce calculatePay
    String name;
    String id;
    //... constructor ...

    // Abstract method must be implemented by children
    public abstract double calculateMonthlyPay();
}

public class FullTimeEmployee extends Person {
    private double annualSalary;
    //... constructor ...

    @Override
    public double calculateMonthlyPay() {
        return annualSalary / 12;
    }
}

public class Contractor extends Person {
    private double hourlyRate;
    private int hoursWorked;
    //... constructor and a setter for hoursWorked...

    @Override
    public double calculateMonthlyPay() {
        return hourlyRate * hoursWorked;
    }
}

// The power of polymorphism in action:
public class PayrollProcessor {
    public void process(Person person) {
        // The *same* line of code behaves differently based on the object type.
        // We don't need to know if it's a FullTimeEmployee or a Contractor.
        double pay = person.calculateMonthlyPay();
        System.out.println("Processing pay for " + person.name + ": $" + pay);
    }
}

// How it's used:
// PayrollProcessor processor = new PayrollProcessor();
// Person emp = new FullTimeEmployee("Jane Doe", "E123", 120000);
// Person con = new Contractor("John Smith", "C456", 75);
// ((Contractor)con).setHoursWorked(100); // Set hours for the contractor

// processor.process(emp); // Executes FullTimeEmployee's calculateMonthlyPay
// processor.process(con); // Executes Contractor's calculateMonthlyPay
```

## 5. Abstraction

**Concept:**  
Abstraction hides complex implementation details and exposes only the essential features of an object. Java supports abstraction through abstract classes and interfaces.

Abstract Classes

**Concept:**  
An abstract class cannot be instantiated and can include abstract methods (without implementations) that must be defined by its subclasses.


Interfaces

**Concept:**  
Interfaces declare a contract by specifying abstract methods that implementing classes must override. A class can implement multiple interfaces.

**Example:** 

```java
// The "contract" is defined using an interface (pure abstraction)
public interface DataService {
    // Any class implementing this interface MUST provide this functionality.
    // It hides *how* the connection is made or data is fetched.
    String fetchData(String query);
    boolean connect(String connectionString);
}

// Concrete implementation for a database
public class OracleDatabaseService implements DataService {
    @Override
    public boolean connect(String connectionString) {
        System.out.println("Connecting to Oracle DB at " + connectionString);
        // Add complex Oracle JDBC connection logic here...
        return true;
    }

    @Override
    public String fetchData(String query) {
        System.out.println("Executing Oracle SQL query: " + query);
        // Add logic to fetch and format data from Oracle...
        return "{\"data\": \"some data from Oracle\"}";
    }
}

// Concrete implementation for a REST API
public class RestApiService implements DataService {
    @Override
    public boolean connect(String apiUrl) {
        System.out.println("Initializing HTTP client for " + apiUrl);
        // Add complex REST client setup logic here...
        return true;
    }

    @Override
    public String fetchData(String endpoint) {
        System.out.println("Calling REST endpoint: " + endpoint);
        // Add logic to make HTTP call and get response...
        return "{\"data\": \"some data from a REST API\"}";
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
