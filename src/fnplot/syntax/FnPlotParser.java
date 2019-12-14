
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package fnplot.syntax;

import java_cup.runtime.*;
import java.io.*;
import java.util.*;
import fnplot.sys.SyntaxFnPlotException;
import fnplot.values.FnPlotValue;
import fnplot.values.FnPlotReal;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class FnPlotParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public FnPlotParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public FnPlotParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public FnPlotParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\037\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\004" +
    "\000\002\012\003\000\002\012\005\000\002\012\003\000" +
    "\002\006\006\000\002\011\005\000\002\007\004\000\002" +
    "\007\003\000\002\010\005\000\002\010\003\000\002\005" +
    "\006\000\002\013\005\000\002\013\005\000\002\013\003" +
    "\000\002\020\005\000\002\020\003\000\002\014\005\000" +
    "\002\014\005\000\002\014\005\000\002\014\003\000\002" +
    "\016\003\000\002\016\003\000\002\015\003\000\002\015" +
    "\003\000\002\015\005\000\002\017\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\016\004\024\017\022\021\004\030\006\031" +
    "\017\032\015\001\002\000\016\004\024\017\022\021\004" +
    "\030\006\031\017\032\015\001\002\000\024\005\uffe9\011" +
    "\uffe9\012\uffe9\013\062\014\063\015\061\020\uffe9\023\uffe9" +
    "\024\uffe9\001\002\000\026\005\uffe8\011\uffe8\012\uffe8\013" +
    "\uffe8\014\uffe8\015\uffe8\020\uffe8\023\uffe8\024\uffe8\025\uffe8" +
    "\001\002\000\022\002\ufffd\004\ufffd\017\ufffd\021\ufffd\022" +
    "\ufffd\030\ufffd\031\ufffd\032\ufffd\001\002\000\022\002\ufffe" +
    "\004\ufffe\017\ufffe\021\ufffe\022\ufffe\030\ufffe\031\ufffe\032" +
    "\ufffe\001\002\000\016\005\uffef\011\uffef\012\uffef\020\uffef" +
    "\023\uffef\024\uffef\001\002\000\026\005\uffe6\011\uffe6\012" +
    "\uffe6\013\uffe6\014\uffe6\015\uffe6\020\uffe6\023\uffe6\024\uffe6" +
    "\025\uffe6\001\002\000\004\002\060\001\002\000\012\005" +
    "\ufffb\020\ufffb\023\ufffb\024\ufffb\001\002\000\022\011\uffe5" +
    "\012\uffe5\013\uffe5\014\uffe5\015\uffe5\016\055\024\uffe5\025" +
    "\uffe5\001\002\000\020\002\001\004\024\017\022\021\004" +
    "\030\006\031\017\032\015\001\002\000\026\005\uffe7\011" +
    "\uffe7\012\uffe7\013\uffe7\014\uffe7\015\uffe7\020\uffe7\023\uffe7" +
    "\024\uffe7\025\uffe7\001\002\000\004\024\053\001\002\000" +
    "\026\005\uffed\011\uffed\012\uffed\013\uffed\014\uffed\015\uffed" +
    "\020\uffed\023\uffed\024\uffed\025\051\001\002\000\006\020" +
    "\uffe3\032\037\001\002\000\016\005\ufff9\011\030\012\031" +
    "\020\ufff9\023\ufff9\024\ufff9\001\002\000\016\004\024\017" +
    "\022\021\004\030\006\031\017\032\025\001\002\000\026" +
    "\005\uffe5\011\uffe5\012\uffe5\013\uffe5\014\uffe5\015\uffe5\020" +
    "\uffe5\023\uffe5\024\uffe5\025\uffe5\001\002\000\004\005\027" +
    "\001\002\000\026\005\uffe4\011\uffe4\012\uffe4\013\uffe4\014" +
    "\uffe4\015\uffe4\020\uffe4\023\uffe4\024\uffe4\025\uffe4\001\002" +
    "\000\012\004\024\030\006\031\017\032\025\001\002\000" +
    "\012\004\024\030\006\031\017\032\025\001\002\000\016" +
    "\005\ufff0\011\ufff0\012\ufff0\020\ufff0\023\ufff0\024\ufff0\001" +
    "\002\000\016\005\ufff1\011\ufff1\012\ufff1\020\ufff1\023\ufff1" +
    "\024\ufff1\001\002\000\004\020\ufff5\001\002\000\006\020" +
    "\uffe3\023\044\001\002\000\004\020\042\001\002\000\004" +
    "\016\040\001\002\000\016\004\024\017\022\021\004\030" +
    "\006\031\017\032\025\001\002\000\006\020\ufff7\023\ufff7" +
    "\001\002\000\016\004\024\017\022\021\004\030\006\031" +
    "\017\032\025\001\002\000\012\005\ufff8\020\ufff8\023\ufff8" +
    "\024\ufff8\001\002\000\004\032\037\001\002\000\004\020" +
    "\ufff3\001\002\000\004\020\ufff6\001\002\000\006\020\uffe3" +
    "\023\044\001\002\000\004\020\ufff4\001\002\000\012\004" +
    "\024\030\006\031\017\032\025\001\002\000\024\005\uffee" +
    "\011\uffee\012\uffee\013\uffee\014\uffee\015\uffee\020\uffee\023" +
    "\uffee\024\uffee\001\002\000\022\002\ufffc\004\ufffc\017\ufffc" +
    "\021\ufffc\022\ufffc\030\ufffc\031\ufffc\032\ufffc\001\002\000" +
    "\022\002\uffff\004\uffff\017\uffff\021\uffff\022\uffff\030\uffff" +
    "\031\uffff\032\uffff\001\002\000\016\004\024\017\022\021" +
    "\004\030\006\031\017\032\025\001\002\000\004\024\057" +
    "\001\002\000\022\002\ufff2\004\ufff2\017\ufff2\021\ufff2\022" +
    "\ufff2\030\ufff2\031\ufff2\032\ufff2\001\002\000\004\002\000" +
    "\001\002\000\012\004\024\030\006\031\017\032\025\001" +
    "\002\000\012\004\024\030\006\031\017\032\025\001\002" +
    "\000\012\004\024\030\006\031\017\032\025\001\002\000" +
    "\016\005\uffeb\011\uffeb\012\uffeb\020\uffeb\023\uffeb\024\uffeb" +
    "\001\002\000\016\005\uffec\011\uffec\012\uffec\020\uffec\023" +
    "\uffec\024\uffec\001\002\000\016\005\uffea\011\uffea\012\uffea" +
    "\020\uffea\023\uffea\024\uffea\001\002\000\020\004\024\017" +
    "\022\021\004\022\070\030\006\031\017\032\015\001\002" +
    "\000\012\005\ufffa\020\ufffa\023\ufffa\024\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\030\002\012\003\015\004\007\005\006\006" +
    "\013\012\017\013\022\014\010\015\020\016\011\020\004" +
    "\001\001\000\026\003\066\004\007\005\006\006\013\012" +
    "\017\013\022\014\010\015\020\016\011\020\004\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\024\004" +
    "\053\005\006\006\013\012\017\013\022\014\010\015\020" +
    "\016\011\020\004\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\007\035\011\034\017\033" +
    "\001\001\000\002\001\001\000\020\006\013\012\025\013" +
    "\022\014\010\015\020\016\011\020\004\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\014" +
    "\032\015\020\016\011\020\004\001\001\000\012\014\031" +
    "\015\020\016\011\020\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\010\045\017\044" +
    "\001\001\000\002\001\001\000\002\001\001\000\020\006" +
    "\013\012\040\013\022\014\010\015\020\016\011\020\004" +
    "\001\001\000\002\001\001\000\020\006\013\012\042\013" +
    "\022\014\010\015\020\016\011\020\004\001\001\000\002" +
    "\001\001\000\004\011\046\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\010\047\017\044\001\001\000\002" +
    "\001\001\000\010\015\020\016\011\020\051\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\020" +
    "\006\013\012\055\013\022\014\010\015\020\016\011\020" +
    "\004\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\014\065\015\020\016\011\020\004\001" +
    "\001\000\012\014\064\015\020\016\011\020\004\001\001" +
    "\000\012\014\063\015\020\016\011\020\004\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\024" +
    "\004\053\005\006\006\013\012\017\013\022\014\010\015" +
    "\020\016\011\020\004\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$FnPlotParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$FnPlotParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$FnPlotParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

	  
    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

		try {
		    return lexer.next_token();
		} catch (java.io.IOException ioe) {
                    String msg = "Line " + lexer.getLine() + ", pos " +
				       lexer.getColumn() +
				       ": Unrecognised token <" +
				       lexer.getText() + ">";
		    throw new SyntaxFnPlotException(msg, ioe);
		}
	  
    }


		FnPlotLexer lexer;

		public FnPlotParser(FnPlotLexer l) {
		    // As of CUP v0.11, need to pass Lexer to superclass
		    super(l);
		    lexer = l;
		}

		public void report_error(String message, Object info) {
		    System.err.println(message);
		}

		public void syntax_error(Symbol cur_token) {
		    System.err.print("Line " + lexer.getLine() +
				     " near char " + lexer.getChar() + ": ");
		    report_error("Syntax error", cur_token);
		    System.err.println ("Last token read is " +
					 lexer.getText());
		}
	    

/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$FnPlotParser$actions {
  private final FnPlotParser parser;

  /** Constructor */
  CUP$FnPlotParser$actions(FnPlotParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$FnPlotParser$do_action_part00000000(
    int                        CUP$FnPlotParser$act_num,
    java_cup.runtime.lr_parser CUP$FnPlotParser$parser,
    java.util.Stack            CUP$FnPlotParser$stack,
    int                        CUP$FnPlotParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$FnPlotParser$result;

      /* select the action based on the action number */
      switch (CUP$FnPlotParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= stmtList 
            {
              ArithProgram RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		StmtSequence s = (StmtSequence)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = new ArithProgram(s); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		ArithProgram start_val = (ArithProgram)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		RESULT = start_val;
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$FnPlotParser$parser.done_parsing();
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // stmtList ::= stmtList stmt 
            {
              StmtSequence RESULT =null;
		int lstleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int lstright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		StmtSequence lst = (StmtSequence)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		lst.add(s); 
		RESULT = lst;
		
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("stmtList",1, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // stmtList ::= stmt 
            {
              StmtSequence RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		RESULT = new StmtSequence(s);
		
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("stmtList",1, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmt ::= definition 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		StmtDefinition d = (StmtDefinition)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = d; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmt ::= expression SEMI 
            {
              Statement RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		 RESULT = e; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expression ::= letExp 
            {
              Exp RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		StmtLet l = (StmtLet)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = l; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("expression",8, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expression ::= LBRACE stmtList RBRACE 
            {
              Exp RESULT =null;
		int bodyleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int bodyright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		StmtSequence body = (StmtSequence)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		 RESULT = body; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("expression",8, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expression ::= arithExp 
            {
              Exp RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp a = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = a; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("expression",8, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // letExp ::= LET bindings IN expression 
            {
              StmtLet RESULT =null;
		int bsleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int bsright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		ArrayList<Binding> bs = (ArrayList<Binding>)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int bodyleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int bodyright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp body = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
			RESULT = new StmtLet(bs, body);
           
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("letExp",4, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-3)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // binding ::= VARIABLE ASSIGN expression 
            {
              Binding RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		RESULT = new Binding(v, e);
	    
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("binding",7, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // bindings ::= binding bindingsAux 
            {
              ArrayList<Binding> RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		Binding b = (Binding)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		int blleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int blright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		ArrayList<Binding> bl = (ArrayList<Binding>)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		bl.add(0,b);
		RESULT = bl;
	     
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("bindings",5, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // bindings ::= empty 
            {
              ArrayList<Binding> RESULT =null;
		 RESULT = new ArrayList(); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("bindings",5, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // bindingsAux ::= COMMA binding bindingsAux 
            {
              ArrayList<Binding> RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		Binding b = (Binding)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		int blleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int blright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		ArrayList<Binding> bl = (ArrayList<Binding>)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		  bl.add(0,b);
		  RESULT = bl;
		
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("bindingsAux",6, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // bindingsAux ::= empty 
            {
              ArrayList<Binding> RESULT =null;
		 RESULT = new ArrayList(); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("bindingsAux",6, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // definition ::= VARIABLE ASSIGN expression SEMI 
            {
              StmtDefinition RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-3)).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		
		   RESULT = new StmtDefinition(v, e);
		
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("definition",3, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-3)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // arithExp ::= arithExp PLUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
			RESULT = new ExpAdd(e, t); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("arithExp",9, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // arithExp ::= arithExp MINUS term 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
			RESULT = new ExpSub(e, t); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("arithExp",9, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // arithExp ::= term 
            {
              Exp RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = t; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("arithExp",9, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // power ::= factor EXPO power 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp p = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT= new ExpExpo(f,p); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("power",14, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // power ::= factor 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT=f; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("power",14, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // term ::= power MUL term 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		RESULT = new ExpMul(f, t); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // term ::= power DIV term 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		RESULT = new ExpDiv(f, t); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // term ::= power MOD term 
            {
              Exp RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).right;
		Exp f = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp t = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		
		RESULT = new ExpMod(f, t); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // term ::= power 
            {
              Exp RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Exp p = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT= p; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // number ::= INTEGER 
            {
              FnPlotValue< ? > RESULT =null;
		int ilitleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int ilitright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Integer ilit = (Integer)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = FnPlotValue.make( ilit ); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("number",12, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // number ::= DOUBLE 
            {
              FnPlotValue< ? > RESULT =null;
		int ilitleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int ilitright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		Double ilit = (Double)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = FnPlotValue.make(ilit); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("number",12, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // factor ::= number 
            {
              Exp RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		FnPlotValue< ? > n = (FnPlotValue< ? >)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = new ExpLit( n ); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("factor",11, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // factor ::= VARIABLE 
            {
              Exp RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.peek()).value;
		 RESULT = new ExpVar(var); 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("factor",11, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // factor ::= LPAREN expression RPAREN 
            {
              Exp RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-1)).value;
		 RESULT = e; 
              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("factor",11, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.elementAt(CUP$FnPlotParser$top-2)), ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // empty ::= 
            {
              Object RESULT =null;

              CUP$FnPlotParser$result = parser.getSymbolFactory().newSymbol("empty",13, ((java_cup.runtime.Symbol)CUP$FnPlotParser$stack.peek()), RESULT);
            }
          return CUP$FnPlotParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$FnPlotParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$FnPlotParser$do_action(
    int                        CUP$FnPlotParser$act_num,
    java_cup.runtime.lr_parser CUP$FnPlotParser$parser,
    java.util.Stack            CUP$FnPlotParser$stack,
    int                        CUP$FnPlotParser$top)
    throws java.lang.Exception
    {
              return CUP$FnPlotParser$do_action_part00000000(
                               CUP$FnPlotParser$act_num,
                               CUP$FnPlotParser$parser,
                               CUP$FnPlotParser$stack,
                               CUP$FnPlotParser$top);
    }
}

}
