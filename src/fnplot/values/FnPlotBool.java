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
public class FnPlotBool extends FnPlotValue<FnPlotBool> {

    boolean value;

    public FnPlotBool() {
        this(false);
    }

    public FnPlotBool(Boolean v) {
        value = v;
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
