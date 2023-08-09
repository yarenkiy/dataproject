/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project1_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yarenk
 */
public class Project1_1 {

   
     public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        List<String> initialNames = new ArrayList<>();

        try {
            File file = new File("class.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String name = sc.next();
                cl.insert(name);
                initialNames.add(name);
            }

            Random random = new Random();
            int N = cl.size;
            int turn = 1;

            while (cl.size > 1) {
                int k = random.nextInt(N) + 1;
                System.out.println("Turn " + turn + " k = " + k);

                Node current = cl.head;
                for (int i = 0; i < k - 1; i++) {
                    current = current.next;
                }

                System.out.println("student: " + current.name);
                if (current.name.length() > 1) {
                    current.name = current.name.substring(1);
                } else {
                    cl.removePerson(current);
                }

                cl.display();
                N = cl.size;
                turn++;
            }

            System.out.println("Winner : " + getWinnerName(cl.head.name, initialNames));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static String getWinnerName(String lastCharacter, List<String> initialNames) {
        for (String name : initialNames) {
            if (name.endsWith(lastCharacter)) {
                return name;
            }
        }
        return null;
    }


    
}
