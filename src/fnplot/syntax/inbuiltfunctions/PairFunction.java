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
public class PairFunction extends InBuilt {

   

    private ArrayList<Exp> argList;
    private String name;

    public PairFunction(){
        super();
    }

    public PairFunction(String name,ArrayList<Exp> args) {
        System.out.println("inside constructor of Pair Function");
        this.argList = args;
        this.name = name;
    }

    public ArrayList<Exp> getArguments() {
        return this.argList;
    }
    
    public String getName(){
        return this.name;
    }

    /**
     * evaluates all the expressions inside the pair
     * @param <S>
     * @param <T>
     * @param v
     * @param args
     * @param state
     * @return
     * @throws FnPlotException
     */
    private <S,T> ArrayList<Exp> expressionReduce(Visitor<S, T> v,ArrayList<Exp> args, S state) throws FnPlotException{

        // List<Exp> eval = args.stream().map( exp->new ExpLit( ((FnPlotValue)exp.visit(v, state)) )  ).collect(Collectors.toList());
        ArrayList<Exp> eval = new ArrayList<>();

        for (Exp exp : args) {
            ExpLit newLit = new ExpLit( ((FnPlotValue)exp.visit(v, state)) ) ;
            eval.add(newLit);
        }

        return new ArrayList<Exp>(eval);
    }

    /**
     * @param argList the argList to set
     */
    private void setArgList(ArrayList<Exp> argList) {
        this.argList = argList;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        System.out.println("inside visit of PairFunction");

        ArrayList<Exp> evalArgs = expressionReduce(v, this.argList, state);
        setArgList(evalArgs);
        
        
        return v.visitExpPair(this, state);
    }

    /**
     * creates how this languages feature will show when evaluated
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub

        return String.format("pair(%s, %s)", argList.get(0).toString(),argList.get(1).toString());
    }
}