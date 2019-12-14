/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;
import static fnplot.values.FnPlotValue.make;

/**
 *
 * @author newts
 * Created on 14-Nov-2016
 */
public class FnNone extends FnPlotValue<FnNone> {
    
    int value;

    public FnNone() {
        this(0);
    }

    public FnNone(Integer v) {
        value = v;
    }
    
    @Override
    public FnPlotType getType() {
        return null;
    }
    

    @Override
    public String toString() {
        return "None";
    }
}
