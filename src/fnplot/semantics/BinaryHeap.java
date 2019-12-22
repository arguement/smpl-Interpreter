package fnplot.semantics;
import java.util.*;

public class BinaryHeap{
    private static ArrayList<Double> Heap;
   /*
    public static void heapify (ArrayList<Double> Heap2,int n,double i){
        double largest=i; 
        double l =2 * i +1;
        double r=2*i +2; 
        // If left child is larger than root 
        if (l < n && Heap2.get((int)l)>Heap2.get((int)largest)){
            largest=l;
        }
        if (r < n && Heap2.get((int)r)>Heap2.get((int)largest)){
            largest=r;
        } 
        if (largest != i){
            double swap = Heap2.get((int)i); 
            //Heap.get((int)i) = Heap.get((int)largest); 
            //Heap.get((int)largest)=swap; 
            Heap2.add((int)i,Heap2.get((int)largest)); 
            Heap2.add((int)largest,swap);
        }
        
    } 

    public static ArrayList<Double> buildHeap(ArrayList<Double> Heap2,int sixe){ 
        int Start =(sixe/2)-1; 
        for (int i = Start; i >= 0; i--) { 
            heapify(Heap2, sixe, i); 
        } 
        Heap=Heap2;
        return Heap;
    } */ 
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
}