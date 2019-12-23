package fnplot.syntax.inbuiltfunctions;

import java.util.ArrayList;
import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpLit;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotValue;

/**
 * @@author Jordan
 */
public class VectorIndex extends InBuilt {

    
    private Exp vector;
    private Exp index;

    public VectorIndex() {
        super();
    }

    public VectorIndex(Exp vector,Exp index) {
        
        this.vector = vector;
        this.index = index;
        
      
    }
    public Exp getIndex(){
        return this.index;
    }

    public Exp getVector(){
        return this.vector;
    }
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitVectorFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("list( %s )", this.vector);
    }

}