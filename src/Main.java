package src;

import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) {
        // Read the dictionary
        Set<String> dictionary = new HashSet<>();
        try {
            File file = new File("Dict.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                dictionary.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("""
            ██╗    ██╗ ██████╗ ██████╗ ██████╗     ██╗      █████╗ ██████╗ ██████╗ ███████╗██████╗ 
            ██║    ██║██╔═══██╗██╔══██╗██╔══██╗    ██║     ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
            ██║ █╗ ██║██║   ██║██████╔╝██║  ██║    ██║     ███████║██║  ██║██║  ██║█████╗  ██████╔╝
            ██║███╗██║██║   ██║██╔══██╗██║  ██║    ██║     ██╔══██║██║  ██║██║  ██║██╔══╝  ██╔══██╗
            ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝    ███████╗██║  ██║██████╔╝██████╔╝███████╗██║  ██║
            ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝     ╚══════╝╚═╝  ╚═╝╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝ 
            ███████╗ ██████╗ ██╗    ██╗   ██╗███████╗██████╗ 
            ██╔════╝██╔═══██╗██║    ██║   ██║██╔════╝██╔══██╗
            ███████╗██║   ██║██║    ██║   ██║█████╗  ██████╔╝
            ╚════██║██║   ██║██║    ╚██╗ ██╔╝██╔══╝  ██╔══██╗
            ███████║╚██████╔╝███████╗╚████╔╝ ███████╗██║  ██║
        """);
        System.out.println("Welcome to the Word Ladder Solver!");
        System.out.println();

        System.out.println("Please enter two words to find a word ladder between them.");
        System.out.print("Enter the first word: ");
        String start = scanner.nextLine().toLowerCase();
        System.out.print("Enter the second word: ");
        String end = scanner.nextLine().toLowerCase();
        System.out.println();

        // Check whether the two words have the same length
        while (start.length() != end.length() || !dictionary.contains(start) || !dictionary.contains(end)){
            System.out.println("The two words must have the same length and must be valid english words.");
            System.out.print("Enter the first word: ");
            start = scanner.nextLine().toLowerCase();
            System.out.print("Enter the second word: ");
            end = scanner.nextLine().toLowerCase();
            System.out.println();
        }

        System.out.println("Choose the algorithm you want to use:");
        System.out.print("""
                1. Uniform Cost Search
                2. Greedy Breadth-First Search
                3. A* Search
                4. (No Backtrack) Greedy Breadth-First Search
                Enter your choice:
                """);

        int choice = scanner.nextInt();
        System.out.println();
        switch (choice) {
            case 1 -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory(); // Total memory currently available to the JVM
                long startTime = System.nanoTime();
                List<String> result = UCS.findLadderUCS(start, end, dictionary);
                long endTime = System.nanoTime();

                if (result != null) {
                    for (int i = 1 ; i <= result.size(); i++){
                        System.out.println(i + ". " +result.get(i-1));
                    }
                    System.out.println("Steps taken: " + (result.size()-1));
                    long duration = (endTime - startTime) / 1000000;
                    System.out.println("Time taken: " + duration + " ms");

                    long freeMemory = runtime.freeMemory(); // Amount of free memory in the JVM
                    long usedMemory = totalMemory - freeMemory; // Calculate the used memory
                    System.out.println("Total Memory (KB): " + totalMemory / 1024);
                    System.out.println("Free Memory (KB): " + freeMemory / 1024);
                    System.out.println("Used Memory (KB): " + usedMemory / 1024);
                    System.out.println("=".repeat(50));
                    } else {
                    System.out.println("Can't find the result.");
                }
            }
            case 2 -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory(); // Total memory currently available to the JVM
                long startTime = System.nanoTime();
                List<String> result = GBFS.findLadderGBFS(start, end, dictionary);
                long endTime = System.nanoTime();

                if (result != null) {
                    for (int i = 1 ; i <= result.size(); i++){
                        System.out.println(i + ". " +result.get(i-1));
                    }
                    System.out.println("Steps taken: " + (result.size()-1));
                    long duration = (endTime - startTime) / 1000000;
                    System.out.println("Time taken: " + duration + " ms");

                    long freeMemory = runtime.freeMemory(); // Amount of free memory in the JVM
                    long usedMemory = totalMemory - freeMemory; // Calculate the used memory
                    System.out.println("Total Memory (KB): " + totalMemory / 1024);
                    System.out.println("Free Memory (KB): " + freeMemory / 1024);
                    System.out.println("Used Memory (KB): " + usedMemory / 1024);
                    System.out.println("=".repeat(50));
                } else {
                    System.out.println("Can't find the result.");
                }
            }
            case 3 -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory(); // Total memory currently available to the JVM
                long startTime = System.nanoTime();
                List<String> result = AStar.findLadderAStar(start, end, dictionary);
                long endTime = System.nanoTime();
                if (result != null) {
                    for (int i = 1 ; i <= result.size(); i++){
                        System.out.println(i + ". " +result.get(i-1));
                    }
                    System.out.println("Steps taken: " + (result.size()-1));
                    long duration = (endTime - startTime) / 1000000;
                    System.out.println("Time taken: " + duration + " ms");

                    long freeMemory = runtime.freeMemory(); // Amount of free memory in the JVM
                    long usedMemory = totalMemory - freeMemory; // Calculate the used memory
                    System.out.println("Total Memory (KB): " + totalMemory / 1024);
                    System.out.println("Free Memory (KB): " + freeMemory / 1024);
                    System.out.println("Used Memory (KB): " + usedMemory / 1024);
                    System.out.println("=".repeat(50));
                } else {
                    System.out.println("Can't find the result.");
                }
            }
            case 4 -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory(); // Total memory currently available to the JVM
                long startTime = System.nanoTime();
                List<String> result = NoBacktrackGBFS.findLadderNoBacktrackGBFS(start, end, dictionary);
                long endTime = System.nanoTime();
                if (result != null) {
                    for (int i = 1 ; i <= result.size(); i++){
                        System.out.println(i + ". " +result.get(i-1));
                    }
                    System.out.println("Steps taken: " + (result.size()-1));
                    long duration = (endTime - startTime) / 1000000;
                    System.out.println("Time taken: " + duration + " ms");

                    long freeMemory = runtime.freeMemory(); // Amount of free memory in the JVM
                    long usedMemory = totalMemory - freeMemory; // Calculate the used memory
                    System.out.println("Total Memory (KB): " + totalMemory / 1024);
                    System.out.println("Free Memory (KB): " + freeMemory / 1024);
                    System.out.println("Used Memory (KB): " + usedMemory / 1024);
                    System.out.println("=".repeat(50));
                } else {
                    System.out.println("Can't find the result.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
