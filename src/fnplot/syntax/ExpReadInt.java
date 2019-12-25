package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import java.util.*;

/**
 * Class to represent a sequence of statements in the AST.
 * @author newts
 */
public class ExpReadInt extends Exp {

    public ExpReadInt() {
        
    }

    

    @Override
    public <S,T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
    	return v.visitExpReadInt(this, arg);
    }

    @Override
    public String toString() {
	return null;
    }

}

