package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * Class to represent a variable assignment (definition) in the AST.
 * @author dean 
 */
public class ExpGetMin extends Exp {

    
    Exp exp;

    public ExpGetMin(Exp e) {
        
        exp = e;
    }

    public Exp getHeap() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpGetMin(this, arg);
    }
    
    @Override
    public String toString() {
        return String.format("%s", exp.toString());
    }
}

