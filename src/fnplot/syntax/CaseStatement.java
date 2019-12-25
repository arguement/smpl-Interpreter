package fnplot.syntax;

import java.util.ArrayList;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * if statement
 * @author Jordan
 */
public class CaseStatement extends Statement {

    
    private ArrayList<Clause> clauses;

    public CaseStatement() {

    }

    public CaseStatement(ArrayList<Clause> clauses) {

        

        this.clauses = clauses;

        
    }

    public ArrayList<Clause> getClause(){

        return this.clauses;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        
        return v.visitStmtCase(this, state);
    }
    
    

    @Override
    public String toString() {
        return "clause";
    }
}
