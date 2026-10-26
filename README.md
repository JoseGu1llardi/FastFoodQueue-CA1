# Fast-Food Storage Queue System

## Description
Java application that manages food item storage in a fast-food restaurant using a Queue (FIFO) data structure.

## Scenario
- Fast-food restaurant with 5 food types: Burger, Pizza, Fries, Sandwich, Hotdog
- Maximum capacity: 8 trays
- Data structure: Queue (First-In, First-Out)

## Features
- Add food items with weight and best-before date validation
- Remove items following FIFO order
- Display top item in queue
- List all items in storage
- Check if storage is full or empty

## Project Structure
```
src/main/java/com/fastfood/
├── model/
│   ├── FoodItem.java        # food item (type, weight, best-before, added time)
│   └── FoodType.java        # enum with the 5 food types
├── datastructure/
│   └── FoodQueue.java       # FIFO queue, max 8 trays
└── ui/
    └── MainApp.java         # console menu
```

## How to Run
The project uses the standard Maven layout (`src/main/java`), so it can be opened in any Java IDE.

**IntelliJ IDEA / Eclipse / NetBeans / VS Code**
1. Open (or import) the project folder as a Maven project
2. Run `MainApp` class in `com.fastfood.ui` package
3. Follow the interactive console menu

**Command line (Maven)**
```
mvn package
java -jar target/FastFoodQueue-1.0.jar
```

**Command line (JDK only)**
```
javac -d out src/main/java/com/fastfood/*/*.java
java -cp out com.fastfood.ui.MainApp
```

## Technologies
- Java 17+
- Maven

## Students
Jose Wellington Ribeiro - 2024521  |
William de Brito Leal - 2024230

## GitHub Repository
https://github.com/JoseGu1llardi/FastFoodQueue-CA1.git

## Creation Date
October 3, 2026
