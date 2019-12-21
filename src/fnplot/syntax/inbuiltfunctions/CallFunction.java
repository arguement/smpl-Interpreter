package fnplot.syntax.inbuiltfunctions;


import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;

import fnplot.sys.FnPlotException;


/**
 * @@author Jordan
 */
public class CallFunction extends InBuilt {

    
    private Exp list;
    private Exp funct;

    public CallFunction(Exp funct,Exp list) {
        this.funct = funct;
        this.list = list;
    }

    public Exp getList() {
        return list;
    }

    public Exp getfunct() {
        return funct;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitCallFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}