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
public class SizeVectorFunction extends InBuilt {

    private Exp vector;

    public SizeVectorFunction() {
        super();
    }

    public SizeVectorFunction(Exp args) {
        
        this.vector = args;
        
      
    }

    public Exp getVector() {
        return this.vector;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitSizeVectorFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("vector( [: %s :] )", this.vector);
    }

}