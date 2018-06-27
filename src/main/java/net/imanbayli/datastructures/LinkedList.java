package net.imanbayli.datastructures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


/**
 * @author Murad Imanbayli | muradimanbayli@gmail.com 
 * created : Jun 27, 2018 3:47:19 AM 
 */
public class LinkedList implements Iterable<Integer>{
    private Node head;
    private Node tail;
    private int size;
    private int version;
    
    
    
    public void add(int data){
        if(head  == null){
            head = new Node(data);
            tail = head;
        }else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
        version++;
    }
    
    public void remove(int data){
        if(head == null)
            return;
        
        Node current = head;
        Node prev = null;
        
        while(current.data!=data){
            prev = current;
            current = current.next;
        }
        prev.next=current.next;
        size--;
        version++;
    }
    
    public void set(int index,int data){
        Node current = head;
        int count = 0;
        while(count!=index){
            current =current.next;
            count++;
        }
        current.data = data;
        version++;
    }
    
    public int get(int index){
        Node current = head;
        int count = 0;
        while(count!=index){
            current =current.next;
            count++;
        }
        return current.data;
    }
    
    public int size(){
        return size;
    }
    
   
    public boolean isEmpty(){
        return  size == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedlistIterator(this,this.version);
    }
    
    static class LinkedlistIterator implements Iterator<Integer>{
        LinkedList list;
        Node currentNode;
        int version;

        public LinkedlistIterator(LinkedList list,int version) {
            this.list = list;
            currentNode= list.head;
            this.version=version;
        }
        
        
        @Override
        public boolean hasNext() {
           if(version!=list.version){
               throw new ConcurrentModificationException();
           } 
            
           return currentNode != null;
        }

        @Override
        public Integer next() {
             int data = currentNode.data;
             currentNode = currentNode.next;
             return data;
        }
    
    }
    
}
