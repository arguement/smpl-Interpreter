package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpBitwiseNot extends Exp {

    Exp exp1;

    public ExpBitwiseNot(Exp e1) {
        exp1 = e1;
        
    }

    public Exp getExp() {
        return exp1;
    }

    

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpBitwiseNot(this, arg);
    }

    @Override
    public String toString() {
        return "~" + exp1.toString();
    }
}
