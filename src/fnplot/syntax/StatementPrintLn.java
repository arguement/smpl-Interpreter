package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import java.util.*;

/**
 * Class to represent a sequence of statements in the AST.
 * @author newts
 */
public class StatementPrintLn extends Exp {

    private Exp exp;

    public StatementPrintLn(Exp s) {
        this.exp = s;
    }

    public Exp getSeq() {
        return exp;
    }

    @Override
    public <S,T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
    	return v.visitStmtPrintLn(this, arg);
    }

    @Override
    public String toString() {
	return null;
    }

}

