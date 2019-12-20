package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpPara extends Exp  {

    String id;
    private String var;

    public ExpPara(String id, String var) {

        this.id = id;
        this.var = var;
    }

    public String getVar() {
	return this.var;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
    // return v.visitExpVar(this, arg);
    return null;
    }

    @Override
    public String toString() {
	return null;
    }
}
