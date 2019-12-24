package fnplot.semantics;

import fnplot.syntax.StmtLet;
import fnplot.syntax.StmtFun;
import fnplot.syntax.Statement;
import fnplot.syntax.StatementAssign;
import fnplot.syntax.StmtDefinition;
import fnplot.syntax.StmtSequence;
import fnplot.syntax.inbuiltfunctions.CallFunction;
import fnplot.syntax.inbuiltfunctions.CarFunction;
import fnplot.syntax.inbuiltfunctions.CdrFunction;
import fnplot.syntax.inbuiltfunctions.InBuilt;
import fnplot.syntax.inbuiltfunctions.IsEqual;
import fnplot.syntax.inbuiltfunctions.IsEqv;
import fnplot.syntax.inbuiltfunctions.IsPairFunction;
import fnplot.syntax.inbuiltfunctions.ListFunction;
import fnplot.syntax.inbuiltfunctions.PairFunction;
import fnplot.syntax.inbuiltfunctions.SizeVectorFunction;
import fnplot.syntax.inbuiltfunctions.SubstrFunction;
import fnplot.syntax.inbuiltfunctions.VectorFunction;
import fnplot.syntax.inbuiltfunctions.VectorIndex;
import fnplot.syntax.inbuiltfunctions.ExpTuple;
import fnplot.syntax.StatementClear;
import fnplot.syntax.StatementPrint;
import fnplot.syntax.StatementPrintLn;
import fnplot.syntax.ExpLit;
import fnplot.syntax.ExpDiv;
import fnplot.syntax.ExpMul;
import fnplot.syntax.ExpNoLimitProc;
import fnplot.syntax.ExpNot;
import fnplot.syntax.ExpAdd;
import fnplot.syntax.ExpAnd;
import fnplot.syntax.ExpVar;
import fnplot.syntax.ExpVecSpec;
import fnplot.syntax.IfStatement;
import fnplot.syntax.ExpMod;
import fnplot.syntax.ExpExpo;
import fnplot.syntax.ExpSub;
// import fnplot.syntax.ExpTuple;
import fnplot.syntax.ExpComp; /// Gaza 
import fnplot.syntax.ExpCompound;
import fnplot.syntax.ExpLesser;
import fnplot.syntax.ExpGreaterEqual;
import fnplot.syntax.ExpLesserEqual;
import fnplot.syntax.ExpNotEqual;
import fnplot.syntax.ExpOr;
import fnplot.syntax.ExpGreater;
import fnplot.syntax.Binding;
import fnplot.syntax.CaseStatement;
import fnplot.syntax.Clause;
import fnplot.syntax.ArithProgram;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.ExpFunCall;
import fnplot.syntax.PlotStatement;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotReal;
import fnplot.values.FnPlotValue;
import fnplot.values.FnPlotBoolean;
import fnplot.values.FnPlotFunction;
import fnplot.values.FnInBuiltFunction;
import fnplot.values.FnNone;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.awt.geom.Point2D;
import fnplot.syntax.ExpConcat;
import fnplot.syntax.ExpConcat;

public class Evaluator implements Visitor<Environment<FnPlotValue<?>>, FnPlotValue<?>> {
    /*
     * For this visitor, the argument passed to all visit methods will be the
     * environment object that used to be passed to the eval method in the first
     * style of implementation.
     */

    // allocate state here
    protected FnPlotValue<?> result; // result of evaluation

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
     * @return The global environment used by this evaluator. This will be the
     *         parent environemnt of all environments that might arise during the
     *         tree walk of an AST that this Evaluator instance may perform.
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
     * 
     * @param plotter The plotting device to be used by this interpreter.
     */
    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
    }

    /**
     * Visit a node representing the overall program. This will be similar to
     * visiting the sequence of statements that make up the program, but is provided
     * as a separate method so that any top-level, one-time actions can be taken to
     * initialise the context for the program, if necessary.
     * 
     * @param p   The program node to be traversed.
     * @param arg The environment to be used while traversing the program.
     * @return The result of the last statement of the program, after evaluating all
     *         the preceding ones in order.
     * @throws FnPlotException if any of the statements in the body of the program
     *                         throws an exception.
     */
    @Override
    public FnPlotValue<?> visitArithProgram(ArithProgram p, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        result = p.getSeq().visit(this, arg);
        return result;
    }

    @Override
    public FnPlotValue<?> visitStmtSequence(StmtSequence sseq, Environment<FnPlotValue<?>> env) throws FnPlotException {
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
    public FnPlotValue<?> visitStmtLet(StmtLet let, Environment<FnPlotValue<?>> env) throws FnPlotException {
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
        Environment<FnPlotValue<?>> newEnv = new Environment<>(vars, vals, env);
        return body.visit(this, newEnv);
    }

    // just added this
    @Override
    public FnPlotValue<?> visitStmtFun(StmtFun let, Environment<FnPlotValue<?>> env) throws FnPlotException {
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
        Environment<FnPlotValue<?>> newEnv = new Environment<>(vars, vals, env);
        return body.visit(this, newEnv);
    }

    public FnPlotValue<?> visitStmtClear(StatementClear exp, Environment<FnPlotValue<?>> env) throws FnPlotException {
        this.plotter.clear();
        return null;
    }

    // added by me
    public FnPlotValue<?> visitFnDefn(ExpFunction defn, Environment<FnPlotValue<?>> env) throws FnPlotException {
        System.out.println("inside evaluator visitfn");

        Closure c = new Closure(defn.getParameters(), defn.getBody(), env);

        if (defn.getRestParameters() != null) {

            // ArrayList<String> withRest =
            // defn.getParameters().addAll(defn.getRestParameters());
            c.setRest(defn.getRestParameters());

        }

        if (defn.getId() != null) {
            c.setId(defn.getId());
        }

        // Closure c = new Closure(defn.getParameters(), defn.getBody(), env);

        FnPlotFunction funct = new FnPlotFunction(defn, env);
        env.put(funct.toString(), c);

        return funct;
    }

    // added by me
    @Override
    public FnPlotValue<?> visitExpExpo(ExpExpo exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        return val1.expo(val2);
    }

    public FnPlotValue<?> visitFnCall(ExpFunCall callExp, Environment<FnPlotValue<?>> env) throws FnPlotException {

        System.out.println("inside evaluator visitfncall");
        // System.out.println(callExp.toString());
        // String name = callExp.getName();

        // testing
        FnPlotFunction obj = (FnPlotFunction) callExp.getName().visit(this, env);
        // String name = obj.getFunExp().toString();
        String name = obj.toString();
        System.out.println("the name is " + name);

        // System.out.println(name);
        ArrayList<Exp> args = callExp.getArguments();
        ArrayList<FnPlotValue<?>> values = new ArrayList<>();
        for (Exp e : args) {
            values.add(e.visit(this, env));

        }
        // FnPlotValue<?> fun = env.get(name).funValue();
        // Environment newEnv = new Environment<>(fun.)

        // System.out.println(env.dictionary);
        // System.out.println(globalEnv.dictionary);
        // System.out.println(env.parent);
        // System.out.println(env.);
        // System.out.println(values);
        System.out.println(env.dictionary);
        System.out.println(obj.getClosingEnv().dictionary);

        // Closure closure = (Closure) env.get(name);
        Closure closure = (Closure) obj.getClosingEnv().get(name);

        System.out.println("below");

        // checking for ID then it is proc <id> <body>
        if (closure.getId() != null) {
            System.out.println("in closure id");
            List<Exp> evalExp = values.stream().map(v -> new ExpLit(v)).collect(Collectors.toList());

            ArrayList<Exp> evalExpArrayList = new ArrayList<>(evalExp);
            ListFunction list = new ListFunction(evalExpArrayList);

            System.out.println(list);
            System.out.println(closure.getId());

            ArrayList<FnPlotValue<?>> tempValues = new ArrayList<>();

            Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(), tempValues,
                    closure.getEnvironment());

            newEnv.put(closure.getId(), list.visit(this, env));

            System.out.println("new env below");
            System.out.println(newEnv.dictionary);

            return closure.getBody().visit(this, newEnv);

        }

        // checks that the rest paramters are there therefore it would be proc(p1, . . .
        // , pn . prest) <body>
        if (closure.getRestParameters() != null) {
            int lenParam = closure.getParameters().size();
            int lenArgs = values.size();

            if (lenArgs > lenParam) {

                List<Exp> tempFirst = values.subList(0, lenParam).stream().map(v -> new ExpLit(v))
                        .collect(Collectors.toList());
                List<Exp> tempAfter = values.subList(lenParam, lenArgs).stream().map(v -> new ExpLit(v))
                        .collect(Collectors.toList());

                ArrayList<Exp> first = new ArrayList<>(tempFirst);
                ArrayList<Exp> after = new ArrayList<>(tempAfter);

                ListFunction list = new ListFunction(after);
                // list.visit(this, env);
                ArrayList<FnPlotValue<?>> tempValues = new ArrayList<>();
                for (Exp e : first) {
                    tempValues.add(e.visit(this, env));

                }
                Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(),
                        tempValues, closure.getEnvironment());

                newEnv.put(closure.getRestParameters(), list.visit(this, env));

                return closure.getBody().visit(this, newEnv);

            }

        }

        Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(), values,
                closure.getEnvironment());
        // System.out.println("environment");
        // System.out.println(newEnv.dictionary);
        // System.out.println(closure);

        /*
         * System.out.println(args); System.out.println(env.get(name).funValue());
         * System.out.printf("result is %s",this.result);
         */
        // System.out.println(env.get(name).);
        // this.plotter.
        // System.out.println(this.plotter);

        return closure.getBody().visit(this, newEnv);
    }

    // to plot the graph
    public FnPlotValue<?> visitStmtPlot(PlotStatement defn, Environment<FnPlotValue<?>> env) throws FnPlotException {
        System.out.println("inside statement plot");
        int num1 = defn.getNum1();
        int num2 = defn.getNum2();
        String var = defn.getId();
        double[] range = this.plotter.sample(num1, num2);
        // System.out.println(defn.getE().);
        Exp expression = defn.getE();
        if (expression instanceof ExpFunCall) {
            // String name = ((ExpFunCall) expression).getName();

            String name = ((FnPlotFunction) ((ExpFunCall) expression).getName().visit(this, env)).getFunExp().getId();
            // FnPlotFunction obj = (FnPlotFunction)callExp.getName().visit(this, env);
            // String name = obj.getFunExp().getId();

            // the closure is the binds of parameters with the environment
            Closure closure = (Closure) env.get(env.get(name).toString());
            ArrayList<String> para = closure.getParameters(); // gets the paramaters of the functin eg [x,y] for a
                                                              // funtion f = fun(x,y)->x+y

            // get arguments eg for a funtion call f(x,2) the arguments would be [x,2]
            ArrayList<Exp> args = ((ExpFunCall) expression).getArguments();
            ArrayList<String> newArg = new ArrayList<>();
            args.forEach((e) -> {
                newArg.add(e.toString());
            });

            // System.out.println("params and arguments of closure ininstance of");
            // System.out.println(para);
            // System.out.println(args);
            // Exp temp = new ExpVar(var);

            // int index = args.indexOf(temp);
            int index = newArg.indexOf(var);
            // System.out.println("the index");
            // System.out.println(index);
            ArrayList<ArrayList<FnPlotValue<?>>> values = getValues(range, index, args, env);
            // System.out.println(values);
            // System.out.println(values.size() == range.length);
            ArrayList<Double> yVal = runClosureEnv(closure, values);
            System.out.println(yVal);
            Point2D[] points = new Point2D[range.length];
            for (int i = 0; i < range.length; i++) {
                Double x = range[i];
                Double y = yVal.get(i);
                Point2D point = new Point2D.Double(x, y);
                points[i] = point;

            }

            this.plotter.plot(points);
            // System.out.println(index);

            // System.out.println("close dictionary inside stmtplot");
            // System.out.println( closure.getEnvironment().dictionary );

        } else {
            // System.out.println("inside sequence");
            ExpVar bindVar = new ExpVar(var);
            // ExpLit newBind = new ExpLit(10);
            // // expression.
            // env.put(bindVar.getVar(),newBind.getVal());
            // FnPlotValue<?> ans = visitStmtSequence( (StmtSequence)expression, env);
            // FnPlotValue<?> ans = expression.visit(this,env);
            ArrayList<Double> yVal = evalExpression(env, expression, bindVar, range);
            System.out.println(yVal);

            Point2D[] points = new Point2D[range.length];
            for (int i = 0; i < range.length; i++) {
                Double x = range[i];
                Double y = yVal.get(i);
                Point2D point = new Point2D.Double(x, y);
                points[i] = point;

            }

            this.plotter.plot(points);

        }

        // System.out.println( expression.toString() );
        return new FnNone();
    }

    private ArrayList<Double> runClosureEnv(Closure closure, ArrayList<ArrayList<FnPlotValue<?>>> values)
            throws FnPlotException {
        ArrayList<Double> y = new ArrayList<>();
        for (ArrayList<FnPlotValue<?>> arrlst : values) {

            Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(closure.getParameters(), arrlst,
                    closure.getEnvironment());
            y.add(closure.getBody().visit(this, newEnv).doubleValue());
        }

        return y;

    }

    private ArrayList<ArrayList<FnPlotValue<?>>> getValues(double[] range, int index, ArrayList<Exp> args,
            Environment<FnPlotValue<?>> env) throws FnPlotException {
        // System.out.println("inside get values");
        ArrayList<ArrayList<Exp>> store = new ArrayList<>();

        for (double i : range) {

            ArrayList<Exp> args2 = (ArrayList<Exp>) args.clone();
            // replaces variable to a exp
            ExpLit lit = new ExpLit(i);
            if (index != -1) {
                args2.set(index, lit);
            }

            // System.out.println("after set");
            store.add(args2);

        }

        System.out.println(store);
        ArrayList<ArrayList<FnPlotValue<?>>> values = new ArrayList<>();

        for (ArrayList<Exp> storeIndex : store) {
            ArrayList<FnPlotValue<?>> valuesTemp = new ArrayList<>();
            for (Exp e : storeIndex) {

                valuesTemp.add(e.visit(this, env));

            }
            values.add(valuesTemp);
        }

        return values;
    }

    private ArrayList<Double> evalExpression(Environment<FnPlotValue<?>> env, Exp expression, ExpVar bindVar,
            double[] range) throws FnPlotException {

        ArrayList<Double> store = new ArrayList<>();
        // expression.
        for (double d : range) {
            ExpLit newBind = new ExpLit(d);
            env.put(bindVar.getVar(), newBind.getVal());
            double ans = expression.visit(this, env).doubleValue();
            store.add(ans);
        }

        return store;

    }

    @Override
    public FnPlotValue<?> visitExpAdd(ExpAdd exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        if (val1.isInteger() && !val2.isInteger()) {
            return val2.add(val1);
        }
        // System.out.printf("val1 is %s %n",val1.isInteger());
        // System.out.printf("val2 is %s %n",val2.isInteger());
        return val1.add(val2);
    }

    @Override
    public FnPlotValue<?> visitExpSub(ExpSub exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, arg);
        val2 = exp.getExpR().visit(this, arg);
        return val1.sub(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMul(ExpMul exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);

        // System.out.println("for multiplcation");
        // System.out.printf("val1 is %s %n",val1.isInteger());
        // System.out.printf("val2 is %s %n",val2.isInteger());
        if (val1.isInteger() && !val2.isInteger()) {
            return val2.mul(val1);
        }
        return val1.mul(val2);
    }

    @Override
    public FnPlotValue<?> visitExpDiv(ExpDiv exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        return val1.div(val2);
    }

    // dean
    @Override
    public FnPlotValue<?> visitExpComp(ExpComp exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        // FnPlotValue<FnNone> result=true;
        return val1.eequals(val2);
    }

    @Override
    public FnPlotValue<?> visitExpNotEqual(ExpNotEqual exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        return val1.notequal(val2);
    }

    @Override
    public FnPlotValue<?> visitExpLesserEqual(ExpLesserEqual exp, Environment<FnPlotValue<?>> arg)
            throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        return val1.lesserequal(val2);
    }

    @Override
    public FnPlotValue<?> visitExpLesser(ExpLesser exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        return val1.lesser(val2);
    }

    @Override
    public FnPlotValue<?> visitExpGreaterEqual(ExpGreaterEqual exp, Environment<FnPlotValue<?>> arg)
            throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        return val1.greaterequal(val2);
    }

    @Override
    public FnPlotValue<?> visitExpGreater(ExpGreater exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {

        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        // System.out.println(val1);
        // System.out.println(val2);
        return val1.greater(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMod(ExpMod exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        FnPlotValue<?> val1, val2;
        val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
        val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
        return val1.mod(val2);
    }

    @Override
    public FnPlotValue<?> visitExpLit(ExpLit exp, Environment<FnPlotValue<?>> arg) throws FnPlotException {
        return exp.getVal();
    }

    @Override
    public FnPlotValue<?> visitExpVar(ExpVar exp, Environment<FnPlotValue<?>> env) throws FnPlotException {
        return env.get(exp.getVar());
    }

    @Override
    public FnPlotValue<?> visitExpPair(PairFunction pairFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {

        return new FnInBuiltFunction(pairFunction, env);
    }

    @Override
    public FnPlotValue<?> visitCarFunction(CarFunction carFunction, Environment<FnPlotValue<?>> state)
            throws FnPlotException {

        FnInBuiltFunction pair = ((FnInBuiltFunction) carFunction.getPair().visit(this, state));

        PairFunction p = ((PairFunction) pair.getFunExp());

        Exp exp = p.getArguments().get(0);

        return exp.visit(this, state);
    }

    // Britt
    @Override
    public FnPlotValue<?> visitExpConcat(ExpConcat exp, Environment<FnPlotValue<?>> state) throws FnPlotException {
        FnPlotValue<?> lst1 = exp.getExpL().visit(this, state);
        FnPlotValue<?> lst2 = exp.getExpR().visit(this, state);

        FnInBuiltFunction ListFunction1 = ((FnInBuiltFunction) lst1);
        FnInBuiltFunction ListFunction2 = ((FnInBuiltFunction) lst2);

        ListFunction list1 = ((ListFunction) ListFunction1.getFunExp());
        ListFunction list2 = ((ListFunction) ListFunction2.getFunExp());

        ArrayList<Exp> list3 = new ArrayList<Exp>();

        list3.addAll(list1.getArguments());
        list3.addAll(list2.getArguments());

        ListFunction result = new ListFunction(list3);

        return new FnInBuiltFunction(result, state);
    }

    @Override
    public FnPlotValue<?> visitCdrFunction(CdrFunction cdrFunction, Environment<FnPlotValue<?>> state)
            throws FnPlotException {

        FnInBuiltFunction pair = ((FnInBuiltFunction) cdrFunction.getPair().visit(this, state));

        PairFunction p = ((PairFunction) pair.getFunExp());

        Exp exp = p.getArguments().get(1);

        return exp.visit(this, state);
    }

    @Override
    public FnPlotValue<?> visitIsPairFunction(IsPairFunction isPairFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {

        Exp isPair = isPairFunction.getPair();
        boolean checkPair = isPair instanceof PairFunction;

        result = FnPlotValue.make(checkPair);

        return result;
    }

    @Override
    public FnPlotValue<?> visitListFunction(ListFunction listFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        return new FnInBuiltFunction(listFunction, env);
    }

    @Override
    public FnPlotValue<?> visitIsEqvFunction(IsEqv isEqv, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub

        boolean isEqvBool = false;

        FnPlotValue<?> expLVal = isEqv.getExpL().visit(this, env);
        FnPlotValue<?> expRVal = isEqv.getExpR().visit(this, env);

        if (expRVal instanceof FnInBuiltFunction && expLVal instanceof FnInBuiltFunction) {
            FnInBuiltFunction expLFn = ((FnInBuiltFunction) expLVal);
            FnInBuiltFunction expRFn = ((FnInBuiltFunction) expRVal);

            String stringEvalL = expLFn.getFunExp().toString();
            String stringEvalR = expRFn.getFunExp().toString();

            int refL = expLFn.getFunExp().getRef();
            int refR = expRFn.getFunExp().getRef();
            if (stringEvalR.equals(stringEvalL) && refL == refR) {
                isEqvBool = true;
            }
        }

        result = FnPlotValue.make(isEqvBool);

        return result;
    }

    @Override
    public FnPlotValue<?> visitIsEqualFunction(IsEqual isEqual, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        FnPlotValue<?> expLVal = isEqual.getExpL().visit(this, env);
        FnPlotValue<?> expRVal = isEqual.getExpR().visit(this, env);
        boolean isEqvBool = false;

        if (expLVal.toString().equals(expRVal.toString())) {

            isEqvBool = true;
        }

        result = FnPlotValue.make(isEqvBool);

        return result;
    }

    @Override
    public FnPlotValue<?> visitSubstrFunction(SubstrFunction substrFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        Exp str = substrFunction.getStr();
        Exp start = substrFunction.getStart();
        Exp end = substrFunction.getEnd();

        FnPlotValue<?> strVal = str.visit(this, env);
        FnPlotValue<?> startVal = start.visit(this, env);
        FnPlotValue<?> endVal = end.visit(this, env);

        String strString = strVal.stringValue();
        int startInt = startVal.intValue();
        int endInt = endVal.intValue();

        // System.out.println(strString);
        // System.out.println(startInt);
        // System.out.println(endInt);

        String val = "";
        int strLen = strString.length();
        if (endInt > startInt) {
            if (startInt < strLen) {
                val = strString.substring(startInt, endInt);
            }

        }
        result = FnPlotValue.make(val);
        return result;
    }

    @Override
    public FnPlotValue<?> visitNoLimitProcDefn(ExpNoLimitProc expNoLimitProc, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // System.out.println("inside evaluator visitfn");

        // Closure c = new Closure(expNoLimitProc.getParameters(),
        // expNoLimitProc.getBody(), env);

        // // Closure c = new Closure(expNoLimitProc.getParameters(),
        // expNoLimitProc.getBody(), env);

        // FnPlotFunction funct = new FnPlotFunction(expNoLimitProc, env);
        // env.put(funct.toString(), c);

        // return funct;
        return null;
    }

    @Override
    public FnPlotValue<?> visitCallFunction(CallFunction callFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        Exp funcExp = callFunction.getfunct();
        Exp listExp = callFunction.getList();

        FnPlotFunction fn = (FnPlotFunction) funcExp.visit(this, env);
        ExpFunction expFn = fn.getFunExp();

        ListFunction listFun = (ListFunction) listExp;

        ArrayList<FnPlotValue<?>> values = new ArrayList<>();
        for (Exp e : listFun.getArguments()) {
            values.add(e.visit(this, env));

        }
        Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(expFn.getParameters(), values,
                fn.getClosingEnv());

        return expFn.getBody().visit(this, newEnv);
    }

    @Override
    public FnPlotValue<?> visitExpVecSpec(ExpVecSpec expVecSpec, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        Exp size = expVecSpec.geSize();
        Exp fn = expVecSpec.getFunct();

        FnPlotFunction fun = (FnPlotFunction) fn.visit(this, env);
        ExpFunction expFn = fun.getFunExp();

        FnPlotValue<?> val = size.visit(this, env);

        ArrayList<Integer> a = new ArrayList<>(
                IntStream.rangeClosed(0, val.intValue() - 1).boxed().collect(Collectors.toList()));

        /*
         * ArrayList<FnPlotValue<?>> values = new ArrayList<>(); ArrayList<Exp>
         * valuesExp = new ArrayList<>(); for (Integer e : a) {
         * values.add(FnPlotValue.make(e)); valuesExp.add(new ExpLit(e));
         * 
         * } ListFunction list = new ListFunction(valuesExp);
         */

        Environment<FnPlotValue<?>> newEnv = new Environment<FnPlotValue<?>>(new ArrayList<String>(),
                new ArrayList<FnPlotValue<?>>(), fun.getClosingEnv());

        // ArrayList<FnPlotValue<?>> values = new ArrayList<>();
        ArrayList<Exp> valuesExp = new ArrayList<>();

        for (Integer integer : a) {
            FnPlotValue<?> i = FnPlotValue.make(integer);
            newEnv.put(expFn.getParameters().get(0), i);
            FnPlotValue<?> j = expFn.getBody().visit(this, newEnv);
            valuesExp.add(new ExpLit(j));
        }

        ListFunction list = new ListFunction(valuesExp);

        return new FnInBuiltFunction(list, env);
    }

    @Override
    public FnPlotValue<?> visitVectorFunction(VectorFunction vectorFunction, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        // System.out.println(
        // ((ExpVecSpec)vectorFunction.getArguments().get(1)).visit(this, env) );
        ArrayList<Exp> exp = vectorFunction.getArguments();
        ArrayList<Exp> store = new ArrayList<>();
        for (Exp exp2 : exp) {
            if (exp2 instanceof ExpVecSpec) {
                FnInBuiltFunction spec = ((FnInBuiltFunction) ((ExpVecSpec) exp2).visit(this, env));
                ArrayList<Exp> an = ((ListFunction) spec.getFunExp()).getArguments();
                store.addAll(an);

            } else {
                Exp temp = new ExpLit(exp2.visit(this, env));
                store.add(temp);
            }
        }
        VectorFunction ans = new VectorFunction(store);
        return new FnInBuiltFunction(ans, env);
    }

    @Override
    public FnPlotValue<?> visitVectorFunction(VectorIndex vectorIndex, Environment<FnPlotValue<?>> state)
            throws FnPlotException {
        // TODO Auto-generated method stub
        FnInBuiltFunction val = (FnInBuiltFunction) vectorIndex.getVector().visit(this, state);
        VectorFunction vec = (VectorFunction) val.getFunExp();
        Exp exp = vec.getArguments().get(vectorIndex.getIndex().visit(this, state).intValue());
        return exp.visit(this, state);
    }

    @Override
    public FnPlotValue<?> visitSizeVectorFunction(SizeVectorFunction sizeVectorFunction,
            Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        VectorFunction v = (VectorFunction) ((FnInBuiltFunction) sizeVectorFunction.getVector().visit(this, env))
                .getFunExp();
        int len = v.getArguments().size();
        return FnPlotValue.make(len);
    }

    @Override
    public FnPlotValue<?> visitStmtIf(IfStatement ifStatement, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        // System.out.println("eval if");
        Exp pred = ifStatement.getPred();
        Exp thenConsq = ifStatement.getThenConsq();
        Exp elseConsq = ifStatement.getElseConsq();

        FnPlotValue<?> predVisited = pred.visit(this, env);
        FnPlotValue<?> thenConsqVisted = thenConsq.visit(this, env);
        FnPlotValue<?> elseConsqVisited = elseConsq.visit(this, env);

        FnPlotValue<?> ans;

        if (predVisited.booleanValue()) {

            ans = thenConsqVisted;

        } else {

            ans = elseConsqVisited;

        }
        return ans;
    }

    @Override
    public FnPlotValue<?> visitStmtCase(CaseStatement caseStatement, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        ArrayList<Clause> caseList = caseStatement.getClause();
        FnPlotValue<?> ans = new FnNone();
        for (Clause clause : caseList) {
            Exp ant = clause.getAnTqExp();
            Exp consq = clause.getConsqExp();

            boolean found = false;
            if (ant instanceof ExpVar) {
                String var = ((ExpVar) ant).getVar();

                if (var.equals("else")) {
                    found = true;
                }

            }

            if (found) {
                return consq.visit(this, env);
            }

            FnPlotValue<?> evalAnt = ant.visit(this, env);
            FnPlotValue<?> evalConsq = consq.visit(this, env);

            if (evalAnt.booleanValue()) {

                ans = evalConsq;
                break;

            }

        }
        return ans;
    }

    @Override
    public FnPlotValue<?> visitExpCompount(ExpCompound expCompound, Environment<FnPlotValue<?>> arg)
            throws FnPlotException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FnPlotValue<?> visitStmtPrint(StatementPrint statementPrint, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        System.out.print(statementPrint.getSeq().visit(this, env));
        return new FnNone();
    }

    @Override
    public FnPlotValue<?> visitStmtPrintLn(StatementPrintLn statementPrintLn, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        System.out.println(statementPrintLn.getSeq().visit(this, env));
        return new FnNone();
    }

    @Override
    public FnPlotValue<?> visitExpAnd(ExpAnd expAnd, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        FnPlotValue<?> left = expAnd.getExpL().visit(this, env);
        FnPlotValue<?> right = expAnd.getExpR().visit(this, env);

        return left.and(right);
    }

    @Override
    public FnPlotValue<?> visitExpOr(ExpOr expOr, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        FnPlotValue<?> left = expOr.getExpL().visit(this, env);
        FnPlotValue<?> right = expOr.getExpR().visit(this, env);
        return left.or(right);
    }

    @Override
    public FnPlotValue<?> visitExpNot(ExpNot expNot, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        FnPlotValue<?> left = expNot.getExp().visit(this, env);
        return left.not();
    }

    @Override
    public FnPlotValue<?> visitStmtAssign(StatementAssign statementAssign, Environment<FnPlotValue<?>> env)
            throws FnPlotException {
        // TODO Auto-generated method stub
        result = statementAssign.getExp().visit(this, env);
        ExpVar temp = new ExpVar(statementAssign.getVar());
        temp.visit(this, env);
        env.put(statementAssign.getVar(), result);
        return result;
    }

    @Override
    public FnPlotValue<?> visitExpTuple(ExpTuple expTuple, Environment<FnPlotValue<?>> env) throws FnPlotException {
        // TODO Auto-generated method stub
        ArrayList<Exp> multiExp = expTuple.getArguments();
        ArrayList<Exp> temp = new ArrayList<>();
        for (Exp exp : multiExp) {

            temp.add(new ExpLit( exp.visit(this, env) ));
            
        }
        ExpTuple tup = new ExpTuple(temp);
        return new FnInBuiltFunction(tup, env);
    }
}
