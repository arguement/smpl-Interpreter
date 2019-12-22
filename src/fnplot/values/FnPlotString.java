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
public class FnPlotString extends FnPlotValue<FnPlotString> {

    String value;

    public FnPlotString() {
        this("");
    }

    public FnPlotString(String v) {
        value = v;
    }

    @Override
    public String stringValue() throws TypeFnPlotException {
       
        return this.value;
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
