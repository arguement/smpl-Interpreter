package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpNot extends Exp {

    Exp exp1;

    public ExpNot(Exp e1) {
        exp1 = e1;
        
    }

    public Exp getExp() {
        return exp1;
    }

    

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpNot(this, arg);
    }

    @Override
    public String toString() {
        return  "not "+ exp1.toString() ;
    }
}
