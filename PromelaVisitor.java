// Generated from Promela.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PromelaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PromelaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PromelaParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(PromelaParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(PromelaParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#proctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProctype(PromelaParser.ProctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#inline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline(PromelaParser.InlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#ltl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtl(PromelaParser.LtlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(PromelaParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#never}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNever(PromelaParser.NeverContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#trace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrace(PromelaParser.TraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#utype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtype(PromelaParser.UtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#mtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMtype(PromelaParser.MtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#ftype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFtype(PromelaParser.FtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#decl_lst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_lst(PromelaParser.Decl_lstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#one_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOne_decl(PromelaParser.One_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(PromelaParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#active}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActive(PromelaParser.ActiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(PromelaParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#enabler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnabler(PromelaParser.EnablerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#visible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisible(PromelaParser.VisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(PromelaParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(PromelaParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#ivar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIvar(PromelaParser.IvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#ch_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCh_init(PromelaParser.Ch_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#varref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarref(PromelaParser.VarrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#send}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend(PromelaParser.SendContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#receive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceive(PromelaParser.ReceiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#poll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoll(PromelaParser.PollContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#send_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend_args(PromelaParser.Send_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#arg_lst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_lst(PromelaParser.Arg_lstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#recv_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecv_args(PromelaParser.Recv_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#recv_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecv_arg(PromelaParser.Recv_argContext ctx);
	/**
	 * Visit a parse tree produced by the {@code standard}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandard(PromelaParser.StandardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code increment}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrement(PromelaParser.IncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decrement}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrement(PromelaParser.DecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(PromelaParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code do}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo(PromelaParser.DoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(PromelaParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic(PromelaParser.AtomicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code det_atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDet_atomic(PromelaParser.Det_atomicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value_selection}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_selection(PromelaParser.Value_selectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normal_sequence}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_sequence(PromelaParser.Normal_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code send_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend_stm(PromelaParser.Send_stmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code receive_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceive_stm(PromelaParser.Receive_stmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stm(PromelaParser.Assign_stmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code else}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(PromelaParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(PromelaParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto(PromelaParser.GotoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code labeled_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeled_stm(PromelaParser.Labeled_stmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stm(PromelaParser.Print_stmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert(PromelaParser.AssertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condition}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PromelaParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(PromelaParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#stmnt_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmnt_options(PromelaParser.Stmnt_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#andor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndor(PromelaParser.AndorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#binarop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarop(PromelaParser.BinaropContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#unarop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarop(PromelaParser.UnaropContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#any_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_expr(PromelaParser.Any_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PromelaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#chanpoll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChanpoll(PromelaParser.ChanpollContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#uname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUname(PromelaParser.UnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(PromelaParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PromelaParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromelaParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(PromelaParser.StringContext ctx);
}