package fnplot.syntax.inbuiltfunctions;


import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;

import fnplot.sys.FnPlotException;


/**
 * @@author Derwent
 */
public class CdrFunction extends InBuilt {

    private Exp pair;

    public CdrFunction(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair() {
        return pair;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitCdrFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}