package fnplot.syntax.inbuiltfunctions;

import java.util.ArrayList;
import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpLit;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotValue;

/**
 * @@author Jordan
 */
public class CarFunction extends InBuilt {

    private Exp pair;

    public CarFunction(Exp pair) {
        this.pair = pair;
    }

    public Exp getPair() {
        return pair;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        return v.visitCarFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}