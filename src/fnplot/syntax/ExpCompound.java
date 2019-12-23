package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import java.util.*;

/**
 * Class to represent a sequence of Exps in the AST.
 * @author newts
 */
public class ExpCompound extends Exp {

    ArrayList<Exp> seq; // sequence of commands

    

    public ExpCompound(ArrayList<Exp> s) {
        
        this.seq = s;
    }

    public ArrayList<Exp> getSeq() {
        return seq;
    }

    @Override
    public <S,T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
    	return v.visitExpCompount(this, arg);
    }

    @Override
    public String toString() {
	Iterator iter = seq.iterator();

	String result = "";
	while (iter.hasNext()) {
	    result = result + iter.next().toString() + "\n";
	}

	return result;
    }

}

