package fnplot.syntax.inbuiltfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpLit;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotValue;

/**
 * @@author Jordan
 */
public class Heap extends InBuilt {

    private ArrayList<Exp> argList;
    private PriorityQueue<Integer> minHeap ; 


    public Heap() {
        super();
    }

    public Heap(ArrayList<Exp> args) {
        
        this.argList = args;
        this.minHeap = new PriorityQueue<Integer>();
        // System.out.println(args);
      
    }

    public <S, T> void heapify (Visitor<S, T> v, S state) throws FnPlotException{
       
        ArrayList<FnPlotValue<?>> val= new ArrayList<FnPlotValue<?>>();

        for (Exp exp : this.argList) {
            val.add((FnPlotValue<?>)exp.visit(v, state));
        }

        for(int i=0;i<val.size();i++){
            this.minHeap.add(val.get(i).intValue());  
        } 

        System.out.println(this.minHeap);
        

    } 

    public void heapinsert (Integer num){ 
        
        this.minHeap.add(num);
        
    }

    public void heapdelete (){ 
        
        minHeap.poll();


    } 

    public  Integer min (){
       
       
         return minHeap.peek(); 
    }

    public ArrayList<Exp> getArguments() {
        return this.argList;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitHeapFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("heap( %s )", this.minHeap.toString());
    }

}