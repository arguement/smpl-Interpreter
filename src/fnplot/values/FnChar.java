/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;
import static fnplot.values.FnPlotValue.make;

/**
 *String type 
 * @author Jordan
 * 
 */
public class FnChar extends FnPlotValue<FnChar> {

    Character value;

    // public FnChar() {
    //     this();
    // }

    public FnChar(Character v) {
        value = v;
    }

    @Override
    public char charValue() throws TypeFnPlotException {
       
        return this.value;
    }

    @Override
    public FnPlotValue<?> eequals(FnPlotValue<?> arg) throws FnPlotException {
        // TODO Auto-generated method stub
        return make(value.equals(arg.charValue()));
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public FnPlotType getType() {
      
        return FnPlotType.STRING;
    }
}
