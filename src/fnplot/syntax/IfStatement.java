package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * if statement
 * @author Jordan
 */
public class IfStatement extends Statement {

    
 Exp elseConsq;
 Exp thenconsq;
 Exp pred;

    public IfStatement(){

    }

    public IfStatement(Exp pred, Exp consq,Exp elseConsq) {

        

        this.pred = pred;
        this.thenconsq = consq;
        this.elseConsq = elseConsq;

        
    }

    
    public Exp getElseConsq(){
        return this.elseConsq;
    }
    public Exp getThenConsq(){
        return this.thenconsq;
    }
    public Exp getPred(){
        return this.pred;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        
        return v.visitStmtIf(this, state);
    }
    
    

    @Override
    public String toString() {
        return "if statement";
    }
}
