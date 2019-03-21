/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesimulation;

/**
 *
 * @author timmermank1
 */
class Register {

    private Node first; 
    private Node last;
    private int n;
    private double scanTime;
    private double payTime;
    
    private static class Node {
        public Customer customer;
        public Node next;
    }
//creates empty queue    
    
    Register(double d, double d0) {
        first = null;
        last = null;
        n = 0;
        d = scanTime;
        d0 = payTime;
   
    }
    
//gets line length 
    
    
    int getLineLength() {
        return n;
    }
//to add items to the queue
    
    void enqueue(Customer customer) {
        Node oldCustomer = last;
        last = new Node();
        last.customer = customer;
        last.next = null;
        oldCustomer.next = last; 
        
        if (isEmpty()){
        first = last;
        } else{
        oldCustomer.next = last;
        }
        
        n++;
        
    }
//to remove items from the queue
    
    Customer dequeue() {
        Customer customer = first.customer;
        first = first.next;
        n--;
        
        return customer;
        
    }
//to test if the queue is empty
    
    boolean isEmpty() {
        return first == null;
    }
//to see who the first customer in line is
    
    Customer peek() {
       return first.customer;
    }

    double getScanTime() {
        return scanTime;
    }

    double getPayTime() {
        return payTime;
    }
    
}
