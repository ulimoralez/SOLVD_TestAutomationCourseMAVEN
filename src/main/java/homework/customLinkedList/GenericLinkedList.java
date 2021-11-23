package homework.customLinkedList;

import homework.classes.Person;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericLinkedList<T> extends Person {
    private Logger logger = Logger.getLogger(GenericLinkedList.class.getName());
    private Node head;

    public void insert(T data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.next != null) {
                currentNode= currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, T data) {
        if(index == 0){
            insertAtStart(data);
        }else{
            Node newNode = new Node(data);

            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    public void deleteAt(int index) {
        if(index == 0) {
            head = head.next;
        }else{
            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }
    public void show() {
        Node currentNode = head;
        if(currentNode == null){
            logger.log(Level.INFO, "Linked list is empty");
            System.out.println("Linked list is empty");
        }
        else {
            while(currentNode != null) {
                logger.log(Level.INFO, currentNode.data + "; ");
                currentNode = currentNode.next;
            }
        }
    }
}
