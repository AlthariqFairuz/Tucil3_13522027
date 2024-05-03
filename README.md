# Word Ladder Solver

## Introduction
This is a Word Ladder Solver game implemented in Java. The game uses three different search algorithms: Uniform Cost Search (UCS), Greedy Best-First Search (GBFS), and A* Search.

## Game Description
In the Word Ladder game, the player is given two words of equal length. The goal is to transform the start word into the end word by changing one letter at a time, with the constraint that at each step, the intermediate word must be a valid word in the dictionary.

## Search Strategies
### Uniform Cost Search (UCS)
UCS is a tree search algorithm used for traversing or searching a weighted tree or graph. In the context of the Word Ladder game, the cost of each step is based on its depth, so UCS essentially becomes a Breadth-First Search in this case.

### Greedy Best-First Search (GBFS)
GBFS is a search algorithm that explores a graph by selecting the next move according to a heuristic. In the Word Ladder game, the heuristic could be the number of differing letters between the current word and the end word. GBFS doesn't consider the cost to reach the current node, only the estimated cost to reach the goal.

### A* Search
A* Search is a search algorithm that combines the strengths of UCS and GBFS. It considers both the cost to reach the current node and the estimated cost to reach the goal. This makes it more efficient in finding the shortest path to the goal.

## Requirements

To run this program, you need:

1. **Java Runtime Environment (JRE)**: The JRE provides the libraries, the Java Virtual Machine (JVM), and other components necessary to run Java programs. If you already have the Java Development Kit (JDK) installed, you don't need a separate JRE. The JDK includes a compatible JRE.

2. **Java Development Kit (JDK)**: You need to have JDK installed on your system. You can download it from the official Oracle website. Make sure to download the version that suits your operating system.

3. **IDE (Optional)**: While not necessary, an Integrated Development Environment (IDE) like IntelliJ IDEA or VSCode can make coding in Java easier.

## Running the Java File

1. First, you need to clone this repository to your local machine. Open a terminal window and run the following command:
    ```bash
    git clone https://github.com/AlthariqFairuz/Tucil3_13522027.git
    ```

2. Navigate to the `Tucil3_13522027` directory.
    ```bash
    cd Tucil3_13522027
    ``` 
3. Compile the Java file using the `javac` command:

    ```bash
    javac -d bin src/*.java
    ```

4. Run the compiled Java program using the `java` command:

    ```bash
    java -cp bin Main
    ```
## Author

| Name | NIM | Class |
| ---- | -------- | ----- |
| Muhammad Althariq Fairuz | 13522027 | 01 |

