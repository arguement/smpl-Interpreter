package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

/**
 * Class to represent multiplication expression in the AST.
 * @author newts
 */
public class ExpFor extends Exp {

    String var;
    Exp start;
    Exp stop;
    Exp insideLoop;

    public ExpFor(String e1, Exp e2,Exp e3,Exp exp4) {
        var = e1;
        start = e2;
        stop = e3;
        insideLoop = exp4;
    }

    public String getVar(){
        return this.var;
    }

    public Exp getStart(){
        return this.start;
    }
    public Exp getStop(){
        return this.stop;
    }
    public Exp getInsideLoop(){
        return this.insideLoop;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpFor(this, arg);
    }

    @Override
    public String toString() {
        return "for loop";
    }
}
