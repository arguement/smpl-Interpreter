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
public class ListFunction extends InBuilt {

   

    private ArrayList<Exp> argList;
   

    public ListFunction(){
        super();
    }

    public ListFunction(ArrayList<Exp> args) {
        
        this.argList = args;
        
      
    }

    public ArrayList<Exp> getArguments() {
        return this.argList;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitListFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("list( %s )", this.argList);
    }

}