/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;

/**
 *
 * @param <T> The type of base Java value wrapped by this class
 * @author newts
 * Created on 27-Oct-2011 at 12:51:46 PM
 */
public abstract class FnPlotValue<T extends FnPlotValue<T>> {

    private static final long serialVersionUID = 1L;

    /**
     * Create a FnPlot value wrapping a Java double
     * @param v the double value to be wrapped
     * @return The FnPlotValue instance to represent that double precision value
     */
    public static FnPlotReal make(Double v) {
        return new FnPlotReal(v);
    }
    public static FnChar make(Character v) {
        return new FnChar(v);
    }
    
    /**
     * Create a FnPlot value wrapping a Java integer
     * @param v The int value to be wrapped
     * @return The FnPlotValue instance to represent that integer value.
     */
    public static FnPlotInt make(Integer v) {
        return new FnPlotInt(v);
    }

    public static FnPlotString make(String v) {
        return new FnPlotString(v);
    }
    
    public static FnPlotBoolean make(Boolean v){
        return new FnPlotBoolean(v);
   }
    /**
     *
     * @return The type of this value.
     */
    public abstract FnPlotType getType();
    
    /**
     *
     * @return <code>true</code> if and only if this value is numerically
     * equivalent to an integer
     */
    public boolean isInteger() {
        return getType() == FnPlotType.INTEGER;
    }

    /**
     * Add the given value to this value
     * @param arg The value to be added.
     * @return The sum of the two values as a new instance of FnPlotValue.
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under addition
     */
    public FnPlotValue<?> add(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operation div called with non-numeric type");
    }

    /**
     * Subtract the given value from this value.
     * @param arg The value to be subtracted
     * @return The difference as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under subtraction
     */
    public FnPlotValue<?> sub(FnPlotValue<?> arg) throws FnPlotException {
            throw new TypeFnPlotException("Operation sub called with non-numeric type");
    }

    /**
     * Multiply the given value by this value.
     * @param arg The multiplicand
     * @return The product as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under multiplication
     */
    public FnPlotValue<?> mul(FnPlotValue<?> arg) throws FnPlotException {
            throw new TypeFnPlotException("Operation mul called with non-numeric type");
    }

    /**
     * Divide the given value by this value.
     * @param arg The divisor
     * @return The quotient as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    public FnPlotValue<?> div(FnPlotValue<?> arg) throws FnPlotException {
            throw new TypeFnPlotException("Operation div called with non-numeric type");
    }
    public FnPlotValue<?> expo(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operation expo called with non-numeric type");
}
    /**
     * Compute the remainder of dividing this value by the given value.
     * @param arg The divisor
     * @return The residue modulo arg as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    public FnPlotValue<?> mod(FnPlotValue<?> arg) throws FnPlotException {
            throw new TypeFnPlotException("Operation mod called with non-numeric type");
    } 
    //dean was here
    public FnPlotValue<?> eequals(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error"); 
    } 

    public FnPlotValue<?> greater(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error2"); 
    } 

    public FnPlotValue<?> notequal(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error3"); 
    } 

    public FnPlotValue<?> lesserequal(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error4"); 
    }  

    public FnPlotValue<?> lesser(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error5"); 
    } 

    public FnPlotValue<?> greaterequal(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error6"); 
    }
    public FnPlotValue<?> and(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error7"); 
    }
    public FnPlotValue<?> or(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("error8"); 
    }
    public FnPlotValue<?> not() throws FnPlotException {
        throw new TypeFnPlotException("error9"); 
    }
        
    public FnPlotValue<?> BitAnd(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operator called with non numeric type"); 
    }  
    public FnPlotValue<?> BitOr(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operator called with non numeric type"); 
    }  
    public FnPlotValue<?> BitNot(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operator called with non numeric type"); 
    } 
    /**
     *
     * @return The integer value wrapped in this FnPlot value
     * @throws TypeFnPlotException If there is no such integer
     */
    public int intValue() throws TypeFnPlotException {
        throw new TypeFnPlotException(FnPlotType.INTEGER, getType());
    } 
    //dean
   public boolean booleanValue() throws TypeFnPlotException{
       throw new TypeFnPlotException(FnPlotType.BOOLEAN, getType());
   }
    /**
     *
     * @return The real value wrapped in this FnPlot value
     * @throws TypeFnPlotException if there is no such real value.
     */
    public double doubleValue() throws TypeFnPlotException {
        throw new TypeFnPlotException(FnPlotType.REAL, getType());
    }


    public String stringValue() throws TypeFnPlotException {
        throw new TypeFnPlotException(FnPlotType.STRING, getType());
    }
    public char charValue() throws TypeFnPlotException {
        throw new TypeFnPlotException(FnPlotType.STRING, getType());
    }

    /**
     *
     * @return The user defined function wrapped in this FnPlot value.
     * @throws TypeFnPlotException if there is no such function
     */
    public FnPlotFunction funValue() throws TypeFnPlotException {
        throw new TypeFnPlotException(FnPlotType.FUNCTION, getType());
    }
}
