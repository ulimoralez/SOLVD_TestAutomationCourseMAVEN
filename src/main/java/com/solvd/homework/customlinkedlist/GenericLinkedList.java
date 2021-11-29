package com.solvd.homework.customlinkedlist;

import com.solvd.homework.customlogger.CustomLogger;

import java.util.logging.Logger;

public class GenericLinkedList<T>{
    private static final Logger LOGGER = new CustomLogger(GenericLinkedList.class.getName()).getInitializedLogger();
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
            LOGGER.severe("Linked list is empty");
        }
        else {
            while(currentNode != null) {
                LOGGER.info(currentNode.data + "; ");
                currentNode = currentNode.next;
            }
        }
    }
}
