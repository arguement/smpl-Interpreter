package fnplot.syntax.inbuiltfunctions;

import java.util.ArrayList;
import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpLit;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotValue;

/**
 * @@author Jordan
 */
public class ListFunction extends InBuilt {

   

    private ArrayList<Exp> argList;
   

    public ListFunction(){
        super();
    }

    public ListFunction(ArrayList<Exp> args) {
        
        this.argList = args;
        
      
    }

    public ArrayList<Exp> getArguments() {
        return this.argList;
    }

    private <S,T> ArrayList<Exp> expressionReduce(Visitor<S, T> v,ArrayList<Exp> args, S state) throws FnPlotException{

        // List<Exp> eval = args.stream().map( exp->new ExpLit( ((FnPlotValue)exp.visit(v, state)) )  ).collect(Collectors.toList());
        ArrayList<Exp> eval = new ArrayList<>();

        for (Exp exp : args) {
            ExpLit newLit = new ExpLit( ((FnPlotValue)exp.visit(v, state)) ) ;
            eval.add(newLit);
        }

        return new ArrayList<Exp>(eval);
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub

        ArrayList<Exp> evalArgs = expressionReduce(v, this.argList, state);
        this.argList =  evalArgs;
        
        return v.visitListFunction(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("list( %s )", this.argList);
    }

}