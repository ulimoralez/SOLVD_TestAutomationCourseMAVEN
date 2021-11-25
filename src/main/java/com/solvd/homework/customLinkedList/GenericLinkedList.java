package com.solvd.homework.customLinkedList;

import com.solvd.homework.customLogger.CustomLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericLinkedList<T>{
    private Logger logger = new CustomLogger(GenericLinkedList.class.getName()).getInitializedLogger();
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
            logger.severe("Linked list is empty");
        }
        else {
            while(currentNode != null) {
                logger.info(currentNode.data + "; ");
                currentNode = currentNode.next;
            }
        }
    }
}
