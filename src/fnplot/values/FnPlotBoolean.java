/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;
import static fnplot.values.FnPlotValue.make;

/**
 *
 * @author dean

 */
public class FnPlotBoolean extends FnPlotValue<FnPlotBoolean> {
    
    boolean value;
    int val1;
    
     public FnPlotBoolean(Boolean val1){
         this.val1=val1;
     }
    
     @Override
     public FnPlotBoolean eequals (FnPlotValue<?> arg) throws FnPlotException { 
          boolean value= val1==arg.doubleValue();
         return make(value);
     }
    @Override
    public FnPlotType getType() {
        return FnPlotType.BOOLEAN;
    }
    
    
    @Override
    public int intValue() {
        return val1;
    }

    @Override
    public double doubleValue() {
        return val1;
    }

    @Override
    public String toString() {
        return String.valueOf(val1);
    }
}
