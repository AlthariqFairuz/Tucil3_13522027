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
        """);
        System.out.println("Welcome to the Word Ladder Solver!");
        System.out.println();

        System.out.println("Please enter two words to find a word ladder between them.");
        System.out.print("Enter the first word: ");
        String start = scanner.nextLine();
        System.out.print("Enter the second word: ");
        String end = scanner.nextLine();
        System.out.println();

        // Check whether the two words have the same length
        while (start.length() != end.length()) {
            System.out.println("The two words must have the same length.");
            System.out.print("Enter the first word: ");
            start = scanner.nextLine();
            System.out.print("Enter the second word: ");
            end = scanner.nextLine();
            System.out.println();
        }

        System.out.println("Choose the algorithm you want to use:");
        System.out.print("""
                1. Uniform Cost Search
                2. Greedt Breadth-First Search
                3. A* Search
                Enter your choice:
                """);

        int choice = scanner.nextInt();
        System.out.println();
        switch (choice) {
            case 1 -> {
                List<String> result = UCS.findLadderUCS(start, end, dictionary);
                if (result != null) {
                    System.out.println(result);
                    System.out.println("The length of the ladder is: " + (result.size() - 1));
                    System.out.println("=".repeat(50));
                } else {
                    System.out.println("Word is invalid.");
                }
            }
            case 2 -> {
                if (GBFS.findLadder(start, end, dictionary) != null) {
                    System.out.println(GBFS.findLadder(start, end, dictionary));
                } else {
                    System.out.println("Word is invalid.");
                }
            }
            case 3 -> {
                if (AStar.findLadder(start, end, dictionary) != null) {
                    System.out.println(AStar.findLadder(start, end, dictionary));
                } else {
                    System.out.println("Word is invalid.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
