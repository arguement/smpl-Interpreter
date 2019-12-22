package fnplot.syntax.inbuiltfunctions;


import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;

import fnplot.sys.FnPlotException;


/**check if 2 expressions evaluate to the same object
 * @author Jordan
 */
public class IsEqv extends InBuilt {

    
    private Exp exp2;
    private Exp exp1;

    public IsEqv(Exp exp,Exp exp2) {
        this.exp1 = exp;
        this.exp2 = exp2;
    }

    public Exp getExpL() {
        return exp1;
    }

    public Exp getExpR() {
        return exp2;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        
        return v.visitIsEqvFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}