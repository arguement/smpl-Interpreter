package fnplot.syntax.inbuiltfunctions;




import fnplot.syntax.Exp;



/**Parent of all inbuilt types
 * @author Jordan
 */
public abstract class InBuilt extends Exp{

    private static int counter;
    private int ref;

    public InBuilt(){
        this.ref = ++counter;
    }

    public int getRef() {
        return ref;
    }
    // public abstract String toString();
        
}