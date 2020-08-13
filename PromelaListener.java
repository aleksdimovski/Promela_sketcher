// Generated from Promela.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PromelaParser}.
 */
public interface PromelaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PromelaParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSpec(PromelaParser.SpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSpec(PromelaParser.SpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(PromelaParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(PromelaParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#proctype}.
	 * @param ctx the parse tree
	 */
	void enterProctype(PromelaParser.ProctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#proctype}.
	 * @param ctx the parse tree
	 */
	void exitProctype(PromelaParser.ProctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#inline}.
	 * @param ctx the parse tree
	 */
	void enterInline(PromelaParser.InlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#inline}.
	 * @param ctx the parse tree
	 */
	void exitInline(PromelaParser.InlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#ltl}.
	 * @param ctx the parse tree
	 */
	void enterLtl(PromelaParser.LtlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#ltl}.
	 * @param ctx the parse tree
	 */
	void exitLtl(PromelaParser.LtlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(PromelaParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(PromelaParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#never}.
	 * @param ctx the parse tree
	 */
	void enterNever(PromelaParser.NeverContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#never}.
	 * @param ctx the parse tree
	 */
	void exitNever(PromelaParser.NeverContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#trace}.
	 * @param ctx the parse tree
	 */
	void enterTrace(PromelaParser.TraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#trace}.
	 * @param ctx the parse tree
	 */
	void exitTrace(PromelaParser.TraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#utype}.
	 * @param ctx the parse tree
	 */
	void enterUtype(PromelaParser.UtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#utype}.
	 * @param ctx the parse tree
	 */
	void exitUtype(PromelaParser.UtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#mtype}.
	 * @param ctx the parse tree
	 */
	void enterMtype(PromelaParser.MtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#mtype}.
	 * @param ctx the parse tree
	 */
	void exitMtype(PromelaParser.MtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#ftype}.
	 * @param ctx the parse tree
	 */
	void enterFtype(PromelaParser.FtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#ftype}.
	 * @param ctx the parse tree
	 */
	void exitFtype(PromelaParser.FtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#decl_lst}.
	 * @param ctx the parse tree
	 */
	void enterDecl_lst(PromelaParser.Decl_lstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#decl_lst}.
	 * @param ctx the parse tree
	 */
	void exitDecl_lst(PromelaParser.Decl_lstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#one_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_decl(PromelaParser.One_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#one_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_decl(PromelaParser.One_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(PromelaParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(PromelaParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#active}.
	 * @param ctx the parse tree
	 */
	void enterActive(PromelaParser.ActiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#active}.
	 * @param ctx the parse tree
	 */
	void exitActive(PromelaParser.ActiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#priority}.
	 * @param ctx the parse tree
	 */
	void enterPriority(PromelaParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#priority}.
	 * @param ctx the parse tree
	 */
	void exitPriority(PromelaParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#enabler}.
	 * @param ctx the parse tree
	 */
	void enterEnabler(PromelaParser.EnablerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#enabler}.
	 * @param ctx the parse tree
	 */
	void exitEnabler(PromelaParser.EnablerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#visible}.
	 * @param ctx the parse tree
	 */
	void enterVisible(PromelaParser.VisibleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#visible}.
	 * @param ctx the parse tree
	 */
	void exitVisible(PromelaParser.VisibleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(PromelaParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(PromelaParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(PromelaParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(PromelaParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#ivar}.
	 * @param ctx the parse tree
	 */
	void enterIvar(PromelaParser.IvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#ivar}.
	 * @param ctx the parse tree
	 */
	void exitIvar(PromelaParser.IvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#ch_init}.
	 * @param ctx the parse tree
	 */
	void enterCh_init(PromelaParser.Ch_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#ch_init}.
	 * @param ctx the parse tree
	 */
	void exitCh_init(PromelaParser.Ch_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#varref}.
	 * @param ctx the parse tree
	 */
	void enterVarref(PromelaParser.VarrefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#varref}.
	 * @param ctx the parse tree
	 */
	void exitVarref(PromelaParser.VarrefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#send}.
	 * @param ctx the parse tree
	 */
	void enterSend(PromelaParser.SendContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#send}.
	 * @param ctx the parse tree
	 */
	void exitSend(PromelaParser.SendContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#receive}.
	 * @param ctx the parse tree
	 */
	void enterReceive(PromelaParser.ReceiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#receive}.
	 * @param ctx the parse tree
	 */
	void exitReceive(PromelaParser.ReceiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#poll}.
	 * @param ctx the parse tree
	 */
	void enterPoll(PromelaParser.PollContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#poll}.
	 * @param ctx the parse tree
	 */
	void exitPoll(PromelaParser.PollContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#send_args}.
	 * @param ctx the parse tree
	 */
	void enterSend_args(PromelaParser.Send_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#send_args}.
	 * @param ctx the parse tree
	 */
	void exitSend_args(PromelaParser.Send_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#arg_lst}.
	 * @param ctx the parse tree
	 */
	void enterArg_lst(PromelaParser.Arg_lstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#arg_lst}.
	 * @param ctx the parse tree
	 */
	void exitArg_lst(PromelaParser.Arg_lstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#recv_args}.
	 * @param ctx the parse tree
	 */
	void enterRecv_args(PromelaParser.Recv_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#recv_args}.
	 * @param ctx the parse tree
	 */
	void exitRecv_args(PromelaParser.Recv_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#recv_arg}.
	 * @param ctx the parse tree
	 */
	void enterRecv_arg(PromelaParser.Recv_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#recv_arg}.
	 * @param ctx the parse tree
	 */
	void exitRecv_arg(PromelaParser.Recv_argContext ctx);
	/**
	 * Enter a parse tree produced by the {@code standard}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterStandard(PromelaParser.StandardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code standard}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitStandard(PromelaParser.StandardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code increment}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(PromelaParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code increment}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(PromelaParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decrement}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterDecrement(PromelaParser.DecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decrement}
	 * labeled alternative in {@link PromelaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitDecrement(PromelaParser.DecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterIf(PromelaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitIf(PromelaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code do}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterDo(PromelaParser.DoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code do}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitDo(PromelaParser.DoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterFor(PromelaParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitFor(PromelaParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(PromelaParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(PromelaParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code det_atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterDet_atomic(PromelaParser.Det_atomicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code det_atomic}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitDet_atomic(PromelaParser.Det_atomicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value_selection}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterValue_selection(PromelaParser.Value_selectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value_selection}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitValue_selection(PromelaParser.Value_selectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normal_sequence}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterNormal_sequence(PromelaParser.Normal_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normal_sequence}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitNormal_sequence(PromelaParser.Normal_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code send_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterSend_stm(PromelaParser.Send_stmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code send_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitSend_stm(PromelaParser.Send_stmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code receive_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterReceive_stm(PromelaParser.Receive_stmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code receive_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitReceive_stm(PromelaParser.Receive_stmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stm(PromelaParser.Assign_stmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stm(PromelaParser.Assign_stmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code else}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterElse(PromelaParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code else}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitElse(PromelaParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterBreak(PromelaParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitBreak(PromelaParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterGoto(PromelaParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goto}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitGoto(PromelaParser.GotoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code labeled_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterLabeled_stm(PromelaParser.Labeled_stmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code labeled_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitLabeled_stm(PromelaParser.Labeled_stmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stm(PromelaParser.Print_stmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print_stm}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stm(PromelaParser.Print_stmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterAssert(PromelaParser.AssertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assert}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitAssert(PromelaParser.AssertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condition}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PromelaParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condition}
	 * labeled alternative in {@link PromelaParser#stmnt}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PromelaParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(PromelaParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(PromelaParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#stmnt_options}.
	 * @param ctx the parse tree
	 */
	void enterStmnt_options(PromelaParser.Stmnt_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#stmnt_options}.
	 * @param ctx the parse tree
	 */
	void exitStmnt_options(PromelaParser.Stmnt_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#andor}.
	 * @param ctx the parse tree
	 */
	void enterAndor(PromelaParser.AndorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#andor}.
	 * @param ctx the parse tree
	 */
	void exitAndor(PromelaParser.AndorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#binarop}.
	 * @param ctx the parse tree
	 */
	void enterBinarop(PromelaParser.BinaropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#binarop}.
	 * @param ctx the parse tree
	 */
	void exitBinarop(PromelaParser.BinaropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#unarop}.
	 * @param ctx the parse tree
	 */
	void enterUnarop(PromelaParser.UnaropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#unarop}.
	 * @param ctx the parse tree
	 */
	void exitUnarop(PromelaParser.UnaropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#any_expr}.
	 * @param ctx the parse tree
	 */
	void enterAny_expr(PromelaParser.Any_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#any_expr}.
	 * @param ctx the parse tree
	 */
	void exitAny_expr(PromelaParser.Any_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PromelaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PromelaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#chanpoll}.
	 * @param ctx the parse tree
	 */
	void enterChanpoll(PromelaParser.ChanpollContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#chanpoll}.
	 * @param ctx the parse tree
	 */
	void exitChanpoll(PromelaParser.ChanpollContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#uname}.
	 * @param ctx the parse tree
	 */
	void enterUname(PromelaParser.UnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#uname}.
	 * @param ctx the parse tree
	 */
	void exitUname(PromelaParser.UnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PromelaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PromelaParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PromelaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PromelaParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromelaParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(PromelaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromelaParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(PromelaParser.StringContext ctx);
}