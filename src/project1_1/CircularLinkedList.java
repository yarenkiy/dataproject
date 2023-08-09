/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1_1;

/**
 *
 * @author yarenk
 */
public class CircularLinkedList {
    Node head;
   int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }
    


    public void insert(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            newNode.next = newNode; 
            head = newNode;
        }
        else {
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    public void removePerson(Node personToRemove) {
           if (size == 0) {
        return ; 
    }

    if (size == 1) {
        head = null; 
    } 
    else {
        Node current = head;
        while (current.next != personToRemove) {
            current = current.next;
        }
        current.next = personToRemove.next;
        if (head == personToRemove) {
            head = personToRemove.next; 
        }
    }

    size--;
}

    
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
        } 
        else {
            Node current = head;
            do {
                System.out.print(current.name);
                if (current.next != head) {
                    System.out.print(" --> ");
                }
                current = current.next;
            }
            while (current != head);
            System.out.println();
        }
    }
}
