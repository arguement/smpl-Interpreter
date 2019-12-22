/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;
import static fnplot.values.FnPlotValue.make;

/**
 *Boolean type 
 * @author Jordan
 * 
 */
public class FnPlotBoolean extends FnPlotValue<FnPlotBoolean> {

    boolean value;

    public FnPlotBoolean() {
        this(false);
    }

    public FnPlotBoolean(boolean v) {
        value = v;
    }
    @Override
     public FnPlotBoolean eequals (FnPlotValue<?> arg) throws FnPlotException { 
          //boolean value= val1==arg.doubleValue();
          Boolean val = value == arg.booleanValue();
         return  make(val);
     }
    
     @Override
    public boolean booleanValue() throws TypeFnPlotException {
        // TODO Auto-generated method stub
        return this.value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public FnPlotType getType() {
        // TODO Auto-generated method stub
        return FnPlotType.BOOLEAN;
    }
} 