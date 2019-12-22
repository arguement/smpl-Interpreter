package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

/**
 * @@author Derwent
 */

 public class ExpBitNot extends Exp{
     public ExpBitNot(Exp exp){
        expr = exp;
     }

     public Exp getBitExp(){
         return expr;
     }

     public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpBitNot(this, arg);
    }

    @Override
    public String toString() {
        return null;
    }

 }