package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

/**
 * Class to represent logical and operator.
 * @author britt
 */


public class ExpLogAnd extends Exp {

    Exp exp1;
    Exp exp2;

    public ExpLogAnd(Exp e1, Exp e2) {
        exp1 = e1;
        exp2 = e2;
    }

    public Exp getExpL() {
        return exp1;
    }

    public Exp getExpR() {
        return exp2;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitExpLogAnd(this, state);
    }

    @Override
    public String toString() {
        return exp1.toString() + " and " + exp2.toString();
    }
}
