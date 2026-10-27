package com.pluralsight;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String[] fileNames =  {
                "goldilocks.txt",
                "hansel_and_gretel.txt",
            "mary_had_a_little_lamb.txt"
        };

        System.out.println("=== File Names ===");
        for (int i = 0; i < fileNames.length; i++){
            System.out.println(i + ". " + fileNames[i]);
        }

        System.out.printf("Enter a File Name: ");
        String fileName = input.nextLine().trim();

        boolean found = false;
        for (String name : fileNames) {
            if (fileName.equalsIgnoreCase(name)) {
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("File Name, " + fileName + ", could not be found.");
            return;
        }
        try{
            // create a FileReader object connected to the File

            FileReader fileReader = new FileReader(fileName);
            // create a BufferedReader to manage input stream

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            System.out.println("\n" + fileName);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e){
            System.out.println("File Name, " + fileName + ", does not exist.");
        }

    }
}