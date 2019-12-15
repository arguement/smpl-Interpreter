package fnplot.syntax.inbuiltfunctions;

import java.util.ArrayList;

import fnplot.semantics.Visitor;
import fnplot.syntax.Exp;
import fnplot.sys.FnPlotException;

public class PairFunction extends Exp {

   

    private ArrayList<Exp> argList;
    private String name;

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

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        // TODO Auto-generated method stub
        System.out.println("inside visit of PairFunction");
        return v.visitExpPair(this, state);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub

        return String.format("pair(%s, %s) ", argList.get(0),argList.get(1));
    }
}