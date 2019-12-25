package fnplot.semantics;
import java.util.*;

public class BinaryHeap{
    private static ArrayList<Integer> Heap;
   
    public static PriorityQueue<Integer> heapify (ArrayList<Integer> Heap2){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        for(int i=0;i<Heap2.size();i++){
            minHeap.add(Heap2.get(i));  
        } 
        
       
        return minHeap;


    } 
    public static PriorityQueue<Integer> heapinsert (ArrayList<Integer> Heap2,Integer num){ 
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        minHeap= heapify(Heap2);
        minHeap.add(num);
        return minHeap;


    }  
    public static PriorityQueue<Integer> heapdelete (ArrayList<Integer> Heap2){ 
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        minHeap= heapify(Heap2);
        minHeap.poll();
        return minHeap;


    }  
    public static Integer min (ArrayList<Integer> Heap2){
       
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        minHeap= heapify(Heap2); 
         return minHeap.peek(); 
    }
}