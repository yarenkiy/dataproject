package project_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class CircularLinkedList {
    private Node head;
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            newNode.next = newNode; 
            head = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    public void removePerson(Node personToRemove) {
        if (head == null || personToRemove == null) {
            return;
        }

        if (head == personToRemove) {
            remove();
            return;
        }

        Node current = head;
        while (current.next != head && current.next != personToRemove) {
            current = current.next;
        }

        if (current.next == personToRemove) {
            current.next = personToRemove.next;
            size--;
        }
    }

    public void remove() {
        if (head == null) {
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            head.next = head.next.next;
        }
        size--;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            Node current = head;
            do {
                System.out.print(current.name);
                if (current.next != head) {
                    System.out.print(" --> ");
                }
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        try {
            File file = new File("class1.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNext() && cl.size < 10) { // Assuming we read 10 names from the file
                String name = sc.next();
                cl.insert(name);
            }

         

            Random rand = new Random();
            int N = cl.size;
            int turn = 1;

            while (cl.size > 1) {
                int k = rand.nextInt(N) + 1;
                System.out.println("Turn " + turn + " k = " + k);

                Node current = cl.head;
                for (int i = 0; i < k - 1; i++) {
                    current = current.next;
                }

                System.out.println("student: " + current.name);

                // Remove a letter from the selected student's name
                if (current.name.length() > 1) {
                    current.name = current.name.substring(1);
                } else {
                    cl.removePerson(current);
                }

                cl.display();
                N = cl.size;
                turn++;
            }

            System.out.println("Winner: " + cl.head.name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}