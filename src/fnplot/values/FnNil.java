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
public class FnNil extends FnPlotValue<FnNil> {

    int value;
    String output = null;

    public FnNil() {
        this(0);
    }

    public FnNil(Integer v) {
        value = v;
    }

    public FnNil(String v) {
        output = v;
    }
    
    @Override
    public FnPlotType getType() {
        return null;
    }
    

    @Override
    public String toString() {
        if (output != null){
            return this.output;
        }
        return "Nil";
    }
}
