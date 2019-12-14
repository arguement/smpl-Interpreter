package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;


public class StatementClear extends Statement {
    
    public StatementClear(){

    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        // System.out.println("inside visitor of plot");
        return v.visitStmtClear(this, arg);
        
    }
    
    @Override
    public String toString() {
        return "Cleared";
    }
}