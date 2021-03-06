package fnplot.syntax.inbuiltfunctions;


import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;


/**
 * @@author Jordan
 */
public class IsPairFunction extends InBuilt {

    private Exp pair;

    public IsPairFunction(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair() {
        return pair;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitIsPairFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}