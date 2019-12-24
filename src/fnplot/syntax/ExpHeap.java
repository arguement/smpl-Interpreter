package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * Class to represent a variable assignment (definition) in the AST.
 * @author newts
 */
public class ExpHeap extends Exp {

    
    Exp exp;

    public ExpHeap( Exp e) {
        
        exp = e;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpHeap(this, arg);
    }
    
    @Override
    public String toString() {
        return String.format("%s", exp.toString());
    }
}