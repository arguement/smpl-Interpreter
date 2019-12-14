package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import java.util.ArrayList;

/**
 * Class to represent an AST node for a let expression.
 * @author newts
 */
public class StmtFun extends Exp {
    ArrayList<Binding> bindings;
    Exp body;

    public StmtFun(ArrayList<Binding> bs, Exp bod) {
	bindings = bs;
	body = bod;
    }

    public ArrayList<Binding> getBindings() {
	return bindings;
    }

    public Exp getBody() {
	return body;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitStmtFun(this, state);
    }

    @Override
    public String toString() {
	return "fun " + bindings + " mapsto " + body;
    }

}
