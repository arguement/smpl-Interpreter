package fnplot.semantics;

import fnplot.syntax.StmtLet;
import fnplot.syntax.StmtFun;
import fnplot.syntax.Statement;
import fnplot.syntax.StmtDefinition;
import fnplot.syntax.StmtSequence;
import fnplot.syntax.StatementClear;
import fnplot.syntax.ExpLit;
import fnplot.syntax.ExpDiv;
import fnplot.syntax.ExpMul;
import fnplot.syntax.ExpAdd;
import fnplot.syntax.ExpVar;
import fnplot.syntax.ExpMod;
import fnplot.syntax.ExpExpo;
import fnplot.syntax.ExpSub;
import fnplot.syntax.Binding;
import fnplot.syntax.ArithProgram;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.ExpFunCall;
import fnplot.syntax.PlotStatement;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotReal;
import fnplot.values.FnPlotValue;
import fnplot.values.FnPlotFunction;
import fnplot.values.FnNone;
import java.awt.geom.Point2D;
import java.util.*;
import java.awt.geom.Point2D;

public class Evaluator 
    implements Visitor<Environment<FnPlotValue<?>>, FnPlotValue<?>> {
    /* For this visitor, the argument passed to all visit
       methods will be the environment object that used to
       be passed to the eval method in the first style of
       implementation. */

    // allocate state here
    protected FnPlotValue<?> result;	// result of evaluation

    /**
     * The global environment associated with this evaluator.
     */
    protected Environment<FnPlotValue<?>> globalEnv;
    
    /**
     * The plotting device used by this interpreter.
     */
    private Plotter plotter;

    public Evaluator() {
	// perform initialisations here
	result = FnPlotValue.make(0);
        globalEnv = new Environment<>();
    }
    
    /**
     * @return The global environment used by this evaluator.  This will be the
     * parent environemnt of all environments that might arise during the 
     * tree walk of an AST that this Evaluator instance may perform.
     */
    public Environment<FnPlotValue<?>> getGlobalEnv() {
        return globalEnv;
    }

    /**
     * @return The plotting device currently being used by this interpreter
     */
    public Plotter getPlotter() {
        return plotter;
    }

    /**
     * Set the plotting device.
     * @param plotter The plotting device to be used by this interpreter.
     */
    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
    }

    /**
     * Visit a node representing the overall program.  This will be similar to
     * visiting the sequence of statements that make up the program, but is
     * provided as a separate method so that any top-level, one-time actions 
     * can be taken to initialise the context for the program, if necessary.
     * @param p The program node to be traversed.
     * @param arg The environment to be used while traversing the program.
     * @return The result of the last statement of the program, after evaluating
     * all the preceding ones in order.
     * @throws FnPlotException if any of the statements in the body of the 
     * program throws an exception.
     */
    @Override
    public FnPlotValue<?> visitArithProgram(ArithProgram p, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	result = p.getSeq().visit(this, arg);
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtSequence(StmtSequence sseq, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	ArrayList<Statement> seq = sseq.getSeq();
	Iterator<Statement> iter = seq.iterator();
	result = FnPlotValue.make(0); // default result
        for (Statement s : seq) {
            result = s.visit(this, env);
        }
	// return last value evaluated
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtDefinition(StmtDefinition sd, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	result = sd.getExp().visit(this, env);
	env.put(sd.getVar(), result);
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtLet(StmtLet let, Environment<FnPlotValue<?>> env) 
	throws FnPlotException {
	ArrayList<Binding> bindings = let.getBindings();
	Exp body = let.getBody();

	int size = bindings.size();
	String[] vars = new String[size];
	FnPlotValue<?>[] vals = new FnPlotValue<?>[size];
	Binding b;
	for (int i = 0; i < size; i++) {
	    b = bindings.get(i);
	    vars[i] = b.getVar();
	    // evaluate each expression in bindings
	    result = b.getValExp().visit(this, env);
	    vals[i] = result;
	}
	// create new env as child of current
	Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);
	return body.visit(this, newEnv);
    }

    //just added this
    @Override
    public FnPlotValue<?> visitStmtFun(StmtFun let, Environment<FnPlotValue<?>> env) 
	throws FnPlotException {
	ArrayList<Binding> bindings = let.getBindings();
	Exp body = let.getBody();

	int size = bindings.size();
	String[] vars = new String[size];
	FnPlotValue<?>[] vals = new FnPlotValue<?>[size];
	Binding b;
	for (int i = 0; i < size; i++) {
	    b = bindings.get(i);
	    vars[i] = b.getVar();
	    // evaluate each expression in bindings
	    result = b.getValExp().visit(this, env);
	    vals[i] = result;
	}
	// create new env as child of current
	Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);
	return body.visit(this, newEnv);
    }

    public FnPlotValue<?> visitStmtClear(StatementClear exp, Environment<FnPlotValue<?>> env) throws FnPlotException{
        this.plotter.clear();
        return null;
    }

    //added by me
    public FnPlotValue<?> visitFnDefn(ExpFunction defn, Environment<FnPlotValue<?>> env) throws FnPlotException{
        System.out.println("inside evaluator visitfn");
        Closure  c= new Closure(defn.getParameters(), defn.getBody(), env);
        // env.put(( (Exp)defn)., c);
        FnPlotFunction funct = new FnPlotFunction(defn, env);
        env.put(funct.toString(), c);

        
        // env.put(defn.ge,funct.funValue());
        
        // System.out.printf("inside functiondfn its %s %n",this.result);
        return funct;
    }

    //added by me   
    @Override
    public FnPlotValue<?> visitExpExpo(ExpExpo exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.expo(val2);
    }
    public FnPlotValue<?> visitFnCall(ExpFunCall callExp, Environment<FnPlotValue<?>> env) throws FnPlotException{
        System.out.println("inside evaluator visitfncall");
        // System.out.println(callExp.toString());
        String name = callExp.getName();
        
        // System.out.println(name);
        ArrayList<Exp> args = callExp.getArguments();
        ArrayList<FnPlotValue<?>> values = new ArrayList<>();
        for (Exp e : args) {
            values.add( e.visit(this, env) );
            
        }
        // FnPlotValue<?> fun = env.get(name).funValue();
        // Environment newEnv = new Environment<>(fun.)
        
        
        // System.out.println(env.dictionary);
        // System.out.println(globalEnv.dictionary);
        // System.out.println(env.parent);
        // System.out.println(env.);
        // System.out.println(values);
        Closure closure =  (Closure)env.get(env.get(name).toString()) ;

        // System.out.printf("close getparams: %s %n",closure.getParameters());
        // System.out.printf("values: %s %n",values);

        Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(), values, closure.getEnvironment());
        // System.out.println("environment");
        // System.out.println(newEnv.dictionary);
        // System.out.println(closure);

        /* System.out.println(args);
        System.out.println(env.get(name).funValue());
        System.out.printf("result is %s",this.result); */
        // System.out.println(env.get(name).);
        // this.plotter.
        // System.out.println(this.plotter);
        
        
        return closure.getBody().visit(this, newEnv);
    }

    //to plot the graph
    public FnPlotValue<?> visitStmtPlot(PlotStatement defn, Environment<FnPlotValue<?>> env) throws FnPlotException{
        System.out.println("inside statement plot");
        int num1 = defn.getNum1();
        int num2 = defn.getNum2();
        String var = defn.getId();
        double[] range = this.plotter.sample(num1,num2);
        // System.out.println(defn.getE().);
        Exp expression = defn.getE();
        if ( expression instanceof ExpFunCall){
            String name  = ((ExpFunCall)expression).getName();
            
            // the closure is the binds of parameters with the environment
            Closure closure =  (Closure)env.get(env.get(name).toString()) ;
            ArrayList<String> para = closure.getParameters(); //gets the paramaters of the functin eg [x,y] for a funtion f = fun(x,y)->x+y

            // get arguments eg for a funtion call f(x,2) the arguments would be [x,2]
            ArrayList<Exp> args = ((ExpFunCall)expression).getArguments();
            ArrayList<String> newArg = new ArrayList<>();
            args.forEach((e)->{ newArg.add(e.toString()); });
            
            // System.out.println("params and arguments of closure ininstance of");
            // System.out.println(para);
            // System.out.println(args);
            // Exp temp = new ExpVar(var);
            
            // int index = args.indexOf(temp);
            int index = newArg.indexOf(var);
            // System.out.println("the index");
            // System.out.println(index);
            ArrayList< ArrayList<FnPlotValue<?>> > values = getValues(range,index,args,env);
            // System.out.println(values);
            // System.out.println(values.size() == range.length);
            ArrayList<Double> yVal = runClosureEnv(closure,values);
            System.out.println(yVal);
            Point2D[] points = new Point2D[range.length];
            for (int i = 0; i < range.length; i++) {
                Double x = range[i];
                Double y = yVal.get(i);
                Point2D point = new Point2D.Double(x,y);
                points[i] = point;

            }
            
            this.plotter.plot(points);
            // System.out.println(index);
            
            // System.out.println("close dictionary inside stmtplot");
            // System.out.println( closure.getEnvironment().dictionary );
            
            
        }else {
            // System.out.println("inside sequence");
            ExpVar bindVar = new ExpVar(var);
            // ExpLit newBind = new ExpLit(10);
            // // expression.
            // env.put(bindVar.getVar(),newBind.getVal());
            // FnPlotValue<?> ans =  visitStmtSequence( (StmtSequence)expression, env);
            // FnPlotValue<?> ans =  expression.visit(this,env);
            ArrayList<Double> yVal = evalExpression( env,expression,bindVar,range);
            System.out.println(yVal);

            Point2D[] points = new Point2D[range.length];
            for (int i = 0; i < range.length; i++) {
                Double x = range[i];
                Double y = yVal.get(i);
                Point2D point = new Point2D.Double(x,y);
                points[i] = point;

            }

            this.plotter.plot(points);

            
        }
        
        // System.out.println(  expression.toString()  );
        return new FnNone();
    }
    private ArrayList<Double> runClosureEnv(Closure closure,ArrayList< ArrayList<FnPlotValue<?>> > values) throws FnPlotException{
        ArrayList<Double> y = new ArrayList<>();
        for (ArrayList<FnPlotValue<?>> arrlst : values) {
            
            Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(), arrlst, closure.getEnvironment());
            y.add(closure.getBody().visit(this, newEnv).doubleValue());
        }

        return y;
        
    }
    private ArrayList< ArrayList<FnPlotValue<?>> > getValues(double[] range ,int index,ArrayList<Exp> args,Environment<FnPlotValue<?>> env) throws FnPlotException{
        // System.out.println("inside get values");
        ArrayList<ArrayList<Exp>> store = new ArrayList<>();

        for (double i : range) {
            
            ArrayList<Exp> args2 = (ArrayList<Exp>)args.clone();
            //replaces variable to a exp
            ExpLit lit = new ExpLit(i);
            if (index != -1){
                args2.set(index,lit);
            }
            
            // System.out.println("after set");
            store.add(args2);

        }
        
        System.out.println(store);
        ArrayList< ArrayList<FnPlotValue<?>> > values = new ArrayList<>();

        for (ArrayList<Exp> storeIndex : store) {
            ArrayList<FnPlotValue<?>> valuesTemp = new ArrayList<>();
            for (Exp e : storeIndex) {

                valuesTemp.add( e.visit(this, env) );

                
            }
            values.add(valuesTemp);
        }
        

        return values;
    }

    private ArrayList<Double> evalExpression(Environment<FnPlotValue<?>> env,Exp expression,ExpVar bindVar,double[] range)throws FnPlotException{
        
        ArrayList<Double> store = new ArrayList<>();
            // expression.
        for (double d : range) {
            ExpLit newBind = new ExpLit(d);
            env.put(bindVar.getVar(),newBind.getVal());
            double ans =  expression.visit(this,env).doubleValue();
            store.add(ans);
        }

        return store;
        
    }

    @Override
    public FnPlotValue<?> visitExpAdd(ExpAdd exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = exp.getExpL().visit(this, arg);
    val2 = exp.getExpR().visit(this, arg);
    if (val1.isInteger() && !val2.isInteger()){
        return val2.add(val1);
    }
    // System.out.printf("val1 is %s %n",val1.isInteger());
    // System.out.printf("val2 is %s %n",val2.isInteger());
	return val1.add(val2);
    }

    @Override
    public FnPlotValue<?> visitExpSub(ExpSub exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = exp.getExpL().visit(this, arg);
	val2 = exp.getExpR().visit(this, arg);
	return val1.sub(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMul(ExpMul exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
    val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
    
    // System.out.println("for multiplcation");
    // System.out.printf("val1 is %s %n",val1.isInteger());
    // System.out.printf("val2 is %s %n",val2.isInteger());
    if (val1.isInteger() && !val2.isInteger()){
        return val2.mul(val1);
    }
	return val1.mul(val2);
    }

    @Override
    public FnPlotValue<?> visitExpDiv(ExpDiv exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.div(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMod(ExpMod exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.mod(val2);
    }

    @Override
    public FnPlotValue<?> visitExpLit(ExpLit exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	return exp.getVal();
    }

    @Override
    public FnPlotValue<?> visitExpVar(ExpVar exp, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	return env.get(exp.getVar());
    }
}