package fnplot.semantics;

import fnplot.syntax.Statement;
import fnplot.syntax.StmtDefinition;
import fnplot.syntax.StmtLet;
import fnplot.syntax.StmtFun;
import fnplot.syntax.StmtSequence;
import fnplot.syntax.inbuiltfunctions.CallFunction;
import fnplot.syntax.inbuiltfunctions.CarFunction;
import fnplot.syntax.inbuiltfunctions.CdrFunction;
import fnplot.syntax.inbuiltfunctions.IsEqual;
import fnplot.syntax.inbuiltfunctions.IsEqv;
import fnplot.syntax.inbuiltfunctions.IsPairFunction;
import fnplot.syntax.inbuiltfunctions.ListFunction;
import fnplot.syntax.inbuiltfunctions.PairFunction;
import fnplot.syntax.inbuiltfunctions.SizeVectorFunction;
import fnplot.syntax.inbuiltfunctions.SubstrFunction;
import fnplot.syntax.inbuiltfunctions.VectorFunction;
import fnplot.syntax.inbuiltfunctions.VectorIndex;
import fnplot.syntax.ExpComp; //added by dean 
import fnplot.syntax.ExpCompound;
import fnplot.syntax.ExpGreater;
import fnplot.syntax.ExpDiv;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.ExpLesser;
import fnplot.syntax.ExpGreaterEqual;
import fnplot.syntax.ExpLesserEqual;
import fnplot.syntax.ExpNotEqual;
import fnplot.syntax.ExpFunCall;
import fnplot.syntax.ExpLit;
import fnplot.syntax.ExpMul;
import fnplot.syntax.ExpNoLimitProc;
import fnplot.syntax.ExpSub;
import fnplot.syntax.ExpMod;
import fnplot.syntax.ExpVar;
import fnplot.syntax.ExpVecSpec;
import fnplot.syntax.IfStatement;
import fnplot.syntax.ExpAdd;
import fnplot.syntax.ExpExpo;
import fnplot.syntax.StatementClear;
import fnplot.syntax.StatementPrint;
import fnplot.syntax.StatementPrintLn;
import fnplot.syntax.PlotStatement;
import fnplot.syntax.ArithProgram;
import fnplot.syntax.CaseStatement;
import fnplot.sys.FnPlotException;
import fnplot.syntax.ExpConcat;

/**
 * The generic Visitor interface for the Arithmetic parser
 * example.
 * @param <S> The type of the information needed by the visitor
 * @param <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T> {

    // program
    public T visitArithProgram(ArithProgram p, S arg) throws FnPlotException;

    // statements

    /**
     * Visit a sequence of statements.
     * @param exp The statement sequence AST to be visited
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the given statement sequence.
     * @throws FnPlotException If an error arises while visiting the node.
     */
    public T visitStmtSequence(StmtSequence exp, S arg) throws FnPlotException ;

    /**
     * Visit an assignment (or definition) statement.
     * @param sd The assignment AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the given statement sequence.
     * @throws FnPlotException If an error arises while visiting the node.
     */
    public T visitStmtDefinition(StmtDefinition sd, S arg) throws FnPlotException;
    
    /**
     * Visit a let expression.
     * @param letExp The let AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitStmtLet(StmtLet letExp, S arg) throws FnPlotException;

    // expressions
    /**
     * Visit an add expression.
     * @param exp The addition AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */

    // added by me
    public T visitStmtFun(StmtFun letFun, S arg) throws FnPlotException;

    public T visitFnDefn(ExpFunction defn, S arg) throws FnPlotException;

    public T visitFnCall(ExpFunCall defn, S arg) throws FnPlotException;

    public T visitStmtPlot(PlotStatement defn, S arg) throws FnPlotException;
    
    public T visitExpExpo(ExpExpo exp, S arg) throws FnPlotException;

    public T visitStmtClear(StatementClear exp, S arg) throws FnPlotException;
    //above added by me
    
    //dean
    public T visitExpComp(ExpComp exp,S arg) throws FnPlotException; 
    
    public T visitExpGreater(ExpGreater exp,S arg) throws FnPlotException; 
    
    public T visitExpLesser(ExpLesser exp,S arg) throws FnPlotException; 
    
    public T visitExpGreaterEqual(ExpGreaterEqual exp,S arg) throws FnPlotException; 

    public T visitExpLesserEqual(ExpLesserEqual exp,S arg) throws FnPlotException; 

    public T visitExpNotEqual(ExpNotEqual exp,S arg) throws FnPlotException;
    //dean
    public T visitExpAdd(ExpAdd exp, S arg) throws FnPlotException ;
    
    /**
     * Visit a subtraction expression.
     * @param exp The subtraction AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpSub(ExpSub exp, S arg) throws FnPlotException;
    
    /**
     * Visit a multiplication expression.
     * @param exp The multiplication AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpMul(ExpMul exp, S arg) throws FnPlotException;
    
    /**
     * Visit a division expression.
     * @param exp The division AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpDiv(ExpDiv exp, S arg) throws FnPlotException;
    
    /**
     * Visit a modulo expression.
     * @param exp The modulo AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpMod(ExpMod exp, S arg) throws FnPlotException;
    
    /**
     * Visit a literal expression.
     * @param exp The literal AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpLit(ExpLit exp, S arg) throws FnPlotException;
    
    /**
     * Visit a variable reference expression.
     * @param exp The variable reference AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpVar(ExpVar exp, S arg) throws FnPlotException;

	public T visitExpPair(PairFunction pairFunction, S state) throws FnPlotException;

    public T visitCarFunction(CarFunction carFunction, S state) throws FnPlotException;
    
    public T visitCdrFunction(CdrFunction cdrFunction, S state) throws FnPlotException;

    //britt
    public T visitExpConcat(ExpConcat exp, S state) throws FnPlotException;
	
    public T visitIsPairFunction(IsPairFunction isPairFunction, S state) throws FnPlotException;

	public T visitListFunction(ListFunction listFunction, S state) throws FnPlotException;

	public T visitIsEqvFunction(IsEqv isEqv, S state) throws FnPlotException;

	public T visitIsEqualFunction(IsEqual isEqual, S state) throws FnPlotException;

	public T visitSubstrFunction(SubstrFunction substrFunction, S state) throws FnPlotException;

	public T visitNoLimitProcDefn(ExpNoLimitProc expNoLimitProc, S state) throws FnPlotException;

	public T visitCallFunction(CallFunction callFunction, S state) throws FnPlotException;

	public T visitExpVecSpec(ExpVecSpec expVecSpec, S arg) throws FnPlotException;

	public T visitVectorFunction(VectorFunction vectorFunction, S state) throws FnPlotException;

	public T visitVectorFunction(VectorIndex vectorIndex, S state) throws FnPlotException;

	public T visitSizeVectorFunction(SizeVectorFunction sizeVectorFunction, S state) throws FnPlotException;

	public T visitStmtIf(IfStatement ifStatement, S arg) throws FnPlotException;

	public T visitStmtCase(CaseStatement caseStatement, S state) throws FnPlotException;

	public T visitExpCompount(ExpCompound expCompound, S arg) throws FnPlotException;

	public T visitStmtPrint(StatementPrint statementPrint, S arg) throws FnPlotException;

	public T visitStmtPrintLn(StatementPrintLn statementPrintLn, S arg) throws FnPlotException;

}
