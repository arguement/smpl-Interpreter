

package fnplot.values;

import fnplot.semantics.Environment;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.inbuiltfunctions.InBuilt;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class FnInBuiltFunction extends FnPlotValue<FnInBuiltFunction> {
    InBuilt funExp;
    Environment<FnPlotValue<?>> closingEnv;

    /**
     * Create a new instance of a user-defined function.
     * @param funExp The function expression that was evaluated
     * @param closingEnv The environment over which this function is closed
     */
    public FnInBuiltFunction(InBuilt funExp, Environment<FnPlotValue<?>> closingEnv) {
        this.funExp = funExp;
        this.closingEnv = closingEnv;
        
    }
    
    @Override
    public FnPlotType getType() {
        return FnPlotType.FUNCTION;
    }
    

    public InBuilt getFunExp() {
        return funExp;
    }

    public Environment<FnPlotValue<?>> getClosingEnv() {
        return closingEnv;
    }
    
    @Override
    public String toString() {
        // String params;
        // ArrayList<String> paramList = funExp.getParameters();
        // int n = paramList.size();
        // switch (n) {
        //     case 0: params = ""; break;
        //     case 1: params = paramList.get(0); break;
        //     default: 
        //         params = paramList.get(0);
        //         for (int i = 1; i < n; i++) {
        //             params += ", " + paramList.get(i);
        //         }
        // }
        // String body = funExp.getBody().toString();

        return String.format("[%s]",this.funExp.toString());
    }
    
}
