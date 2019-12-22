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
public class VectorFunction extends InBuilt {

    private ArrayList<Exp> argList;

    public VectorFunction() {
        super();
    }

    public VectorFunction(ArrayList<Exp> args) {
        
        this.argList = args;
        System.out.println(args);
      
    }

    public ArrayList<Exp> getArguments() {
        return this.argList;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitVectorFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("vector( [: %s :] )", this.argList);
    }

}