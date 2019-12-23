
package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

/**
 * Class to represent multiplication expression in the AST.
 * @author newts
 */
public class ExpVecSpec extends Exp {

    Exp exp1;
    Exp exp2;

    public ExpVecSpec(Exp size, Exp funct) {
        exp1 = size;
        exp2 = funct;
    }

    public Exp geSize() {
        return exp1;
    }

    public Exp getFunct() {
        return exp2;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpVecSpec(this, arg);
    }

    @Override
    public String toString() {
        return "vec spec";
    }
}
