package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * Class to represent a variable assignment (definition) in the AST.
 * @author newts
 */
public class StatementAssign extends StmtDefinition {

    String var;
    Exp exp;

    public StatementAssign(String id, Exp e) {
        super(id, e);
        var = id;
        exp = e;
    }

    public String getVar() {
        return var;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitStmtAssign(this, arg);
    }
    
    @Override
    public String toString() {
        return String.format("%s = %s", var, exp.toString());
    }
}
