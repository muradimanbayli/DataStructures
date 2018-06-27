package net.imanbayli.datastructures;

import java.util.Iterator;

/**
 * @author Murad Imanbayli | muradimanbayli@gmail.com 
 * created : Jun 27, 2018 3:56:12 AM 
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        
        System.out.println(list.isEmpty());
        
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(10);
        
        
        Iterator<Integer> iterator=list.iterator();
        
        while (iterator.hasNext()) {            
            int i = iterator.next();
            
            if(i==7){
                list.remove(i);
            }
            
            System.out.println(i);
            
            
        }
        
        
    }
}
