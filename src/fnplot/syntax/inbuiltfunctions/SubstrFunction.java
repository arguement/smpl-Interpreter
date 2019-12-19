package fnplot.syntax.inbuiltfunctions;


import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;

import fnplot.sys.FnPlotException;


/**check if 2 expressions evaluate to the same object
 * @author Jordan
 */
public class SubstrFunction extends InBuilt {

    private Exp start;
    private Exp end;
    private Exp str;


    public SubstrFunction(Exp str, Exp start, Exp end) {
        this.str = str;
        this.start = start;
        this.end = end;
    }

    public Exp getStart() {
        return start;
    }

    public Exp getEnd() {
        return end;
    }

    public Exp getStr(){
        return str;
    }


    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        
        return v.visitSubstrFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}