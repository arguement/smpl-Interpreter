package fnplot.syntax.inbuiltfunctions;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.syntax.Statement;
import fnplot.syntax.StmtDefinition;
import fnplot.sys.FnPlotException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class to represent a sequence of Exps in the AST.
 * @author newts
 */
public class ExpToN extends StmtDefinition {

    private ArrayList<Exp> seq; // sequence of commands
    private ArrayList<String> varList;

    

    public ExpToN(ArrayList<String> varList,ArrayList<Exp> expList) {
           this.seq = expList;
           this.varList = varList;
    }

    public ArrayList<Exp> getSeq() {
        return seq;
    }
    public ArrayList<String> getVarList() {
        return this.varList;
    }


    @Override
    public <S,T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
    	return v.visitExpSeq(this, arg);
    }

    @Override
    public String toString() {
	Iterator iter = seq.iterator();

	String result = "";
	/* while (iter.hasNext()) {
	    // result = result + iter.next().toString() + "\n";
	    result = result + iter.next().toString() + "\n";
    } */
    // result = this.seq.stream().j
    result = seq.stream().map(n -> n.toString()).collect(Collectors.joining(","));

	return result;
    }

}

