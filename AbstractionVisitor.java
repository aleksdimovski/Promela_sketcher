/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;
import java.io.*;

public class AbstractionVisitor extends PromelaBaseVisitor {
    PromelaParser parser;
	PrintWriter out1, out2; 
	String inputFile; 
	int indent;
	boolean inAssign = false, isFeature = false, inCond = false, inDo=false; 
	Map<String,ArrayList<Integer>> featureMap = new HashMap<String,ArrayList<Integer>>(); 
	String currFeat; 
	static int currDown, currUp; 
	String regExp=null;
	String regExpSecond=""; 
	int lineNumber = 0; 
	int lineFrom = 0; // line where starts the sketch construct
	int lineTo = 0; // line where the sketch construct ends 
	int lineJump = 0; 
/*	int lineFrom2 = 0; // line where starts the sketch construct
	int lineTo2 = 0; // line where the sketch construct ends 
	int lineJump2 = 0; 	
	int numberHoles = 0;  */
	String rightWithHole; // right expression with hole
	String leftWithHole;
	String exprWithHole; 
	
    public AbstractionVisitor(PromelaParser parser, PrintWriter out1, PrintWriter out2, String inputFile) {
		this.parser = parser;
        this.out1 = out1;
		this.out2 = out2;
		this.inputFile = inputFile; 
	}
    /** Listen to matches of stmnt */
    @Override
    public Void visitSpec(PromelaParser.SpecContext ctx){
        //System.out.println("enter spec ");
		return (Void)this.visitChildren((RuleNode)ctx);
    }
	
    @Override
    public Void visitFtype(PromelaParser.FtypeContext ctx) {
		String id = ctx.name().getText();
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (PromelaParser.ConstantContext cctx : ctx.constant()) {
                c.add(Integer.parseInt(cctx.getText()));
            }
		featureMap.put(id,c);
        //System.out.println("\t"+id);
		return null;
    }

    @Override
    public Void visitIf(PromelaParser.IfContext ctx) {	
			if (!inDo) {
			String ass = ctx.getText(); 
			ass = ass.replace("if","if "); 
			ass = ass.replace("fi"," fi"); 
			this.print_indent(this.indent);
			this.out1.println(ass+";"); lineNumber++;
			this.out2.println(ass+";");	 } 
			else {
				int childCount = ctx.getChildCount();
        		for (int i = 0; i < childCount; ++i) this.visit(ctx.getChild(i));
			
			}
			return null;
	}

    @Override
    public Void visitLtl(PromelaParser.LtlContext ctx) {	
		int childCount = ctx.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (ctx.getChild(i).getPayload() instanceof Token) { this.out1.print(ctx.getChild(i)); this.out2.print(ctx.getChild(i)); }
			else {
            //    if (i != childCount - 1) {
            this.out1.print(" "+ctx.getChild(i).getText() + " ");		
			this.out2.print(" "+ctx.getChild(i).getText() + " "); }	
			i++;
		}
		/*		
			String ass = ctx.getText(); 
			ass = ass.replace("if","if "); 
			ass = ass.replace("fi"," fi"); 
			this.print_indent(this.indent);
			this.out1.println(ass+";"); lineNumber++;
			this.out2.println(ass+";");	*/
			return null;
	}	
	
    @Override
    public Void visitDo(PromelaParser.DoContext doContext) {
        this.parser.getTokenStream();
        final int size = doContext.sequence().size();
        int i = 0;
		inDo = true; 
        //this.out.println();
        //this.print_indent(this.indent);
		//this.out1.print(" do :: "); this.out2.print(" do :: "); lineNumber++;
		String toPrint = "do  :: "; //this.indent;
		while (i < size) {
			String seq = doContext.sequence().get(i).getText();
        	this.visit((ParseTree)doContext.sequence().get(i));		
			lineNumber++;
			toPrint += seq+"\n"; 			
      		if (i != size - 1) {
					//System.out.println("enters i!=size-1 = "+i+" "+size+" "+this.indent);
                	for (int j = 0; j < this.indent+1; ++j) toPrint += "\t";
                	toPrint += ":: ";
            }
			++i;
		}
		for (int j = 0; j < this.indent; ++j) toPrint += "\t"; toPrint += "od;"; 
		if (isFeature) {
				//System.out.println("LINES = lineNumber "+lineNumber+" size "+size);
				lineNumber = lineNumber - size; 
				String feat = "?"+currFeat; 
				exprWithHole = toPrint; 
				String right2 = toPrint.replace(feat,String.valueOf(currDown));
				String right3 = rightWithHole.replace("*","\\*");
				right3 = right3.replace("(","\\(");
				right3 = right3.replace(")","\\)");
				//right3 = right3.replace(">","\\>");
				regExp = "\\("+right3.replace(feat,"\\d+")+"\\)";
				this.print_indent(this.indent);
				this.out1.println("if "); lineNumber++; 
				
				lineFrom = lineNumber+1; 				
				
				this.out2.println(right2);
				for (int j=currDown; j<=currUp; j++) {
					right2 = toPrint.replace(feat,String.valueOf(j));
					this.print_indent1(this.indent);
					this.out1.println(":: true -> "+right2); lineNumber+=(size+1);
				}
				this.print_indent1(this.indent);
				
				lineTo = lineNumber; 
				
				this.out1.println("fi;"); lineNumber++;		
				
				lineJump = size+1; 
			
				isFeature = false; 
				inCond = false;			
		}
		else { 	this.print_indent(this.indent); 
			  	this.out1.print(toPrint+"\n"); 
				this.out2.print(toPrint+"\n"); lineNumber++;
			 }
		//System.out.println("\t"+" is feat = "+isFeature);
		//this.print_indent(--this.indent);
        //this.out1.println(" od;"); this.out2.println(" od;"); lineNumber++;
        this.out1.flush(); this.out2.flush();
		inDo = false; 
        return null;
    }
	
    public Void visitStandard(PromelaParser.StandardContext ctx)  {
		inAssign = true; 
		String id = ctx.varref().getText(); 
        String right = ctx.any_expr().getText();
		
		int childCount = ctx.getChildCount();
        //System.out.println("\t"+" assign "+id+" child "+childCount);
		//this.visit(ctx.getChild(0));
		this.visit(ctx.getChild(2));

		
		if (isFeature) {
			rightWithHole = right; 
			leftWithHole = id; 
			exprWithHole = id+" = "+right+";"; 
			String feat = "?"+currFeat; 
			String right2 = right.replace(feat,String.valueOf(currDown));
			String right3 = right.replace("*","\\*");
			String idReg = id; 
			if (id.indexOf('[')!=-1) {
				idReg = id.replace("[","\\[");
				idReg = idReg.replace("]","\\]");
			}
			regExp = idReg+" = \\("+right3.replace(feat,"\\d+")+"\\)";
			regExpSecond = idReg+" = "+right3.replace(feat,"(\\d+)");
			this.print_indent(this.indent);
			this.out1.println("if "); lineNumber++; lineFrom = lineNumber+1; 
			this.out2.println(id+" = "+right2+"; ");
			for (int i=currDown; i<=currUp; i++) {
				right2 = right.replace(feat,String.valueOf(i));
				this.print_indent1(this.indent);
				this.out1.println("\t :: "+id+" = "+right2); lineNumber++;
			}
			this.print_indent1(this.indent);
			lineTo = lineNumber; 
			lineJump = 1; 
			this.out1.println("fi;"); lineNumber++;
			//System.out.println("\t"+" assign feat = "+currFeat+" "+currDown+" "+currUp);
			
		} else {
			String ass = ctx.getText(); 
			this.print_indent(this.indent);
			this.out1.println(ass+";"); lineNumber++;
			this.out2.println(ass+";");
		}
		//System.out.println("\t"+" assign after "+id);
		isFeature = false; 
		inAssign = false;
		return null;
    }	

    public Void visitIncrement(PromelaParser.IncrementContext ctx) {
		//this.out1.println(ctx.getText()); lineNumber++;
		//this.out2.println(ctx.getText());
		return null;
    }	

    public Void visitDecrement(PromelaParser.DecrementContext ctx) {
		//this.out1.println(ctx.getText()); lineNumber++;
		//this.out2.println(ctx.getText());
		return null;
    }	

    public Void visitAssert(PromelaParser.AssertContext ctx) {
		//System.out.println("indent is "+this.indent); 
		this.print_indent(this.indent);
		this.out1.println(ctx.getText()); lineNumber++;
		this.out2.println(ctx.getText()); 
		return null;
    }	

    public Void visitCondition(PromelaParser.ConditionContext ctx) {
		String right = ctx.getText();
		
		String id = null; 
		int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; ++i) {
				//if (ctx.getChild(i).getPayload() instanceof PromelaParser.VarrefContext)  System.out.println("HERE then "+right);
				//else System.out.println("HERE else "+right);
                this.visit(ctx.getChild(i));
			
				if (isFeature && !inAssign) {
					rightWithHole = right; 
					leftWithHole = id; 
					inCond = true; 
				} else if (!isFeature && !inDo) { //&& !this.inputFile.equals("salesman.pml")) {
					String ass = ctx.getText(); 
					this.print_indent(this.indent);
					this.out1.println(ass+";"); lineNumber++;
					this.out2.println(ass+";");					
				}
        }
        return null;
    }	
	
    public Void visitBreak(PromelaParser.BreakContext ctx) {
		//this.out1.println(ctx.getText()); lineNumber++;
		//this.out2.println(ctx.getText());
		return null;
    }	
	
    @Override
    public Void visitAny_expr(final PromelaParser.Any_exprContext ctx) {

		int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; ++i) {
                this.visit(ctx.getChild(i));						
        }
        return null;
    }		
	
    public Void visitConstant(PromelaParser.ConstantContext ctx) {
		//System.out.println("\t"+" inAssign constant = "+inAssign);
		//if (inAssign) {
			if ( ctx.getParent().getRuleIndex() == PromelaParser.RULE_any_expr) { 
				String feat = ctx.getText();
				if (feat.startsWith("?")) {
					feat = feat.substring(1); 
					if (featureMap.containsKey(feat)) {
						isFeature = true; 
						currFeat = feat; 
						ArrayList<Integer> list = featureMap.get(feat); 
						currDown = list.get(0);
						currUp = list.get(1);
						//numberHoles++;
					} 
				}
				//System.out.println("\t"+ctx.getText());
			}
			//else System.out.println("\t"+" constant ");
		//}
		return null;
    }	
	
    @Override
    public Void visitSequence(final PromelaParser.SequenceContext ctx) {
		int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            if (ctx.getChild(i).getPayload() instanceof Token) {
                    //this.out.print(ctx.getChild(i) + " ");
            }
            else {
                this.visit(ctx.getChild(i));
            }
        }
        return null;
    }	

    @Override
    public Void visitDecl_lst(final PromelaParser.Decl_lstContext ctx) {
        for (int size = ctx.one_decl().size(), i = 0; i < size; ++i) {
            this.visit((ParseTree)ctx.one_decl().get(i));
            //if (i != size - 1) 
			this.out1.println("; "); lineNumber++;
			this.out2.println("; ");
        }
        return null;
    }
    
    @Override
    public Void visitOne_decl(final PromelaParser.One_declContext one_declContext) {
        final TokenStream tokenStream = this.parser.getTokenStream();
        this.print_indent(this.indent);
        if (one_declContext.visible() != null) {
            this.out1.print(" " + tokenStream.getText((RuleContext)one_declContext.visible()));
			this.out2.print(" " + tokenStream.getText((RuleContext)one_declContext.visible()));
        }
        this.out1.print(tokenStream.getText((RuleContext)one_declContext.typename()));
		this.out2.print(tokenStream.getText((RuleContext)one_declContext.typename()));
        for (int size = one_declContext.ivar().size(), i = 0; i < size; ++i) {
            final String text = tokenStream.getText((RuleContext)one_declContext.ivar().get(i));
            if (i > 0) { this.out1.print(", " + text); this.out2.print(", " + text); }
            else { this.out1.print(" " + text); this.out2.print(" " + text); }
        }
        return null;
    }	
	
    @Override
    public Void visitProctype(final PromelaParser.ProctypeContext ctx) {
        this.out1.println(); this.out2.println(); lineNumber++;
        this.out1.println(); this.out2.println(); lineNumber++;
        final int childCount = ctx.getChildCount();
        int i = 0;
        ++this.indent;
        while (i < childCount) {
            if (ctx.getChild(i).getPayload() instanceof Token) {
                if (i != childCount - 1) {
                    this.out1.print(ctx.getChild(i) + " ");
					this.out2.print(ctx.getChild(i) + " ");
                }
                else {
                    this.out1.println(); this.out2.println(); lineNumber++;
                    this.out1.print(ctx.getChild(i) + " ");
					this.out2.print(ctx.getChild(i) + " ");
                }
            }
            else if (ctx.getChild(i).getPayload() instanceof PromelaParser.SequenceContext) {
                this.out1.println(); this.out2.println(); lineNumber++;
                this.visit(ctx.getChild(i));
            }
            else {
				this.out1.print(ctx.getChild(i).getText()+" ");
				this.out2.print(ctx.getChild(i).getText()+" ");
                //this.visit(ctx.getChild(i));
            }
            ++i;
        }
        this.indent = 0;
        return null;
    }	

    @Override
    public Void visitInline(final PromelaParser.InlineContext ctx) {
		//System.out.println("Enters Inline "); 
        this.out1.println(); this.out2.println(); lineNumber++;
        this.out1.println(); this.out2.println(); lineNumber++;
        final int childCount = ctx.getChildCount();
        int i = 0;
        ++this.indent;
        while (i < childCount) {
            if (ctx.getChild(i).getPayload() instanceof Token) {
                if (i != childCount - 1) {
                    this.out1.print(ctx.getChild(i) + " ");
					this.out2.print(ctx.getChild(i) + " ");
                }
                else {
                    this.out1.println(); this.out2.println(); lineNumber++;
                    this.out1.print(ctx.getChild(i) + " ");
					this.out2.print(ctx.getChild(i) + " ");
                }
            }
            else if (ctx.getChild(i).getPayload() instanceof PromelaParser.SequenceContext) {
                this.out1.println(); this.out2.println(); lineNumber++;
				//System.out.println(ctx.getChild(i).getText()+" "+i);
                this.visit(ctx.getChild(i));
            }
            else {
				this.out1.print(ctx.getChild(i).getText()+" ");
				this.out2.print(ctx.getChild(i).getText()+" ");
                //this.visit(ctx.getChild(i));
            }
            ++i;
        }
        this.indent = 0;
        return null;
    }	
	
    @Override
    public Void visitInit(final PromelaParser.InitContext ctx) {
        this.out1.println(); this.out2.println(); lineNumber++;
        this.out1.println(); this.out2.println(); lineNumber++;
        final int childCount = ctx.getChildCount();
        int i = 0;
        ++this.indent;
        while (i < childCount) {
            if (ctx.getChild(i).getPayload() instanceof Token) {
                if (i == childCount - 1) {this.out1.println(); this.out2.println(); lineNumber++; }
                this.out1.print(ctx.getChild(i) + " ");
				this.out2.print(ctx.getChild(i) + " ");
            }
            else if (ctx.getChild(i).getPayload() instanceof PromelaParser.SequenceContext) {
                this.out1.println(); this.out2.println(); lineNumber++;
                this.visit(ctx.getChild(i));
            }
            else { this.out1.print(ctx.getChild(i).getText()+" "); this.out2.print(ctx.getChild(i).getText()+" "); }
            ++i;
        }
        this.indent = 0;
        return null;
    }	
	
	
    public void print_indent(final int n) {
        for (int i = 0; i < n; ++i) {
            this.out1.print("\t"); this.out2.print("\t");
        }
    }	
	
    public void print_indent1(final int n) {
        for (int i = 0; i < n; ++i) {
            this.out1.print("\t");
        }
    }		
	
    /** Listen to matches of methodDeclaration */
/*    @Override
    public void enterStandard(
        PromelaParser.StandardContext ctx
    )
    {
		inAssign = true; 
        String id = ctx.any_expr().getText();
		//int id2 = ctx.start.getType();
		//int typeTokenType = 0; //ctx.any_expr().start.getType();
		
        System.out.println("\t"+" assign "+id);
    }

	    @Override
    public void exitStandard(
        PromelaParser.StandardContext ctx
    )
    {
		inAssign = false;
		if (isFeature) System.out.println("\t"+" assign feat = "+currFeat+" "+currDown+" "+currUp);
		isFeature = false; 
    }
	
    public void enterConstant(
        PromelaParser.ConstantContext ctx
    )
    {
		//System.out.println("\t"+" inAssign = "+inAssign);
		if (inAssign) {
			if ( ctx.getParent().getRuleIndex() == PromelaParser.RULE_any_expr) { 
				String feat = ctx.getText();
				if (feat.startsWith("?")) {
					feat = feat.substring(1); 
					if (featureMap.containsKey(feat)) {
						isFeature = true; 
						currFeat = feat; 
						ArrayList<Integer> list = featureMap.get(feat); 
						currDown = list.get(0);
						currUp = list.get(1);
					} 
				}
				System.out.println("\t"+ctx.getText());
			}
			else System.out.println("\t"+" constant ");
		}
    }	
	
    @Override
    public void enterFtype(
        PromelaParser.FtypeContext ctx
    )
    {
		String id = ctx.name().getText();
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (PromelaParser.ConstantContext cctx : ctx.constant()) {
                c.add(Integer.parseInt(cctx.getText()));
            }
		featureMap.put(id,c);
        System.out.println("\t"+id);
    }	*/
}
