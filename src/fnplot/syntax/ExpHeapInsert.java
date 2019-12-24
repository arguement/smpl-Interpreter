package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * Class to represent a variable assignment (definition) in the AST.
 * @author newts
 */
public class ExpHeapInsert extends Exp {

    
    Exp exp; 
    Exp exp2;

    public ExpHeapInsert( Exp e1, Exp e2) {
        
        exp = e1;
        exp2=e2;
    }

    public Exp getHeap() {
        return exp;
    } 

    public Exp getNum() {
        return exp2;
    } 
    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpHeapInsert(this, arg);
    }
    
    @Override
    public String toString() {
        return String.format("%s", exp2.toString());
    }
}