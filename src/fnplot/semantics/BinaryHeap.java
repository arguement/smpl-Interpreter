package fnplot.semantics;
import java.util.*;

public class BinaryHeap{
    private static ArrayList<Double> Heap;
   
    public static PriorityQueue<Double> heapify (ArrayList<Double> Heap2){
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(); 
        for(int i=0;i<Heap2.size();i++){
            minHeap.add(Heap2.get(i));  
        } 
        //System.out.println(minHeap);
        
        //minHeap=Heap2; 
        System.out.println(Heap);
        return minHeap;


    } 
    public static PriorityQueue<Double> heapinsert (ArrayList<Double> Heap2,double num){ 
        
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(); 
        minHeap= heapify(Heap2);
        minHeap.add(num);
        return minHeap;


    }  
    public static PriorityQueue<Double> heapdelete (ArrayList<Double> Heap2){ 
        
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(); 
        minHeap= heapify(Heap2);
        minHeap.poll();
        return minHeap;


    }  
    public static Double min (ArrayList<Double> Heap2){
        return Heap2.get(0);
    }
}