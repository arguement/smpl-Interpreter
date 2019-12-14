package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

/**
 * Class to represent a variable assignment (definition) in the AST.
 * @author newts
 */
public class PlotStatement extends Statement {

    Exp e;
    String id;
    int num1;
    int num2;

    public PlotStatement(Exp e,String id,Integer num1, Integer num2) {
        System.out.println("inside plot class");
        this.e = e;
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
    }

    public Exp getE() {
        return e;
    }
   
    public String getId() {
        return id;
    }

    public Integer getNum1() {
        return num1;
    }

    
    public Integer getNum2() {
        return num2;
    }

    

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        System.out.println("inside visitor of plot");
        return v.visitStmtPlot(this, arg);
        
    }
    
    @Override
    public String toString() {
        return String.format("plot %s for %s in [ %s : %s ];", this.e.toString(), this.id,this.num1,this.num2);
    }

    

  
}
