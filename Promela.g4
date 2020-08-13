/**
*
* A promela grammar for ANTLR 4 derived from Spin documentation
* available at http://spinroot.com/spin/Man/grammar.html
*
*/
grammar Promela;

spec	: module+;

module	: proctype	/* proctype declaration */
	| inline 
	| init		/* init process       */
	| never		/* never claim        */
	| trace		/* event trace        */
	| utype		/* user defined types */
	| mtype		/* mtype declaration  */
	| ftype		/* mtype declaration  */	
	| decl_lst	/* global vars, chans */
	| ltl 
	;

proctype: active? PROCTYPE name LPAR decl_lst? RPAR priority? enabler? LBRAKET sequence RBRAKET;

inline	: INLINE name LPAR name RPAR LBRAKET sequence RBRAKET;

ltl		: LTL name LBRAKET '[' ']'  expr RBRAKET;

init	: INIT priority? LBRAKET sequence RBRAKET;

never	: NEVER	LBRAKET sequence RBRAKET;

trace	: TRACE LBRAKET sequence RBRAKET;

utype	: TYPEDEF name LBRAKET decl_lst RBRAKET;

mtype	: MTYPE '='? LBRAKET name (',' name)* RBRAKET;

ftype	: FEATURES typename '[' constant ',' constant ']' name;

decl_lst: one_decl (';' one_decl)*;

one_decl: visible? typename  ivar (',' ivar)*;

typename: BIT | BOOL | BYTE | SHORT | INT | MTYPE | CHAN | uname;

active  : ACTIVE ('[' constant ']')?;	/* instantiation */

priority: PRIORITY constant;	/* simulation priority */

enabler : PROVIDED LPAR expr RPAR;	/* execution constraint */

visible	: HIDDEN_ | SHOW;

sequence: step ((SEMICOL|RARROW)? step)*;

step    : stmnt	(UNLESS stmnt)?
        | decl_lst
	    | XR varref (',' varref)*
	    | XS varref (',' varref)*
	    ;

ivar    : name ('[' constant ']')? ('=' any_expr | '=' ch_init)?;

ch_init : '[' constant ']' OF '{' typename (',' typename)* '}';

varref	: name ('[' any_expr ']')? ('.' varref)?;

send    : varref '!' send_args		/* normal fifo send */
	    | varref '!!' send_args	/* sorted send */
	    ;

receive : varref '?' recv_args		/* normal receive */
        | varref '??' recv_args	/* random receive */
	    | varref '?' '<' recv_args '>'	/* poll with side-effect */
	    | varref '??' '<' recv_args '>'	/* ditto */
	    ;

poll    : varref '?' '[' recv_args ']'	/* poll without side-effect */
	    | varref '??' '[' recv_args ']'	/* ditto */
	    ;

send_args: arg_lst | any_expr LPAR arg_lst RPAR;

arg_lst  : any_expr (',' any_expr)*;

recv_args: recv_arg (',' recv_arg)*  |  recv_arg LPAR recv_args RPAR;

recv_arg : varref | EVAL LPAR varref RPAR | '-'? constant;

assign  : varref '=' any_expr	#standard
	    | varref '++'	#increment
	    | varref '--'	#decrement
	    ;


stmnt	: IF stmnt_options FI		#if
	    | DO (DCOLON sequence)+ OD		#do
	    | FOR LPAR range RPAR LBRAKET sequence RBRAKET		#for
	    | ATOMIC LBRAKET sequence RBRAKET	#atomic
	    | D_STEP LBRAKET sequence RBRAKET	#det_atomic
	    | SELECT LPAR range RPAR	#value_selection
	    | LBRAKET sequence RBRAKET	#normal_sequence
	    | send		#send_stm
	    | receive	#receive_stm
	    | assign	#assign_stm
	    | ELSE			#else
	    | BREAK			#break
	    | GOTO name		#goto
	    | name ':' stmnt	#labeled_stm
	    | PRINT LPAR string (',' arg_lst)? RPAR	#print_stm
	    | ASSERT expr	#assert
	    | expr			#condition
	    ;

range	: varref ':' expr '..' expr
	    | varref IN varref
	    ;

stmnt_options : (DCOLON sequence)+;


andor	: '&&' | '||';

binarop	: '+' | '-' | '*' | '/' | '%' | '&' | '^' | '|'
	    | '>' | '<' | '>' '=' | '<=' | '==' | '!='
	    | '<<' | '>>' | andor;

unarop  : '~' | '-' | '!';

any_expr: LPAR any_expr RPAR
        | any_expr binarop any_expr
	    | unarop any_expr
	    | LPAR any_expr RARROW any_expr ':' any_expr RPAR
	    | LEN LPAR varref RPAR	/* nr of messages in chan */
	    | poll
	    | varref
	    | constant
	    | TIMEOUT
	    | NP_			/* non-progress system state */
	    | ENABLED LPAR any_expr RPAR		/* refers to a pid */
	    | PC_VALUE LPAR any_expr RPAR		/* refers to a pid */
	    | name '[' any_expr ']' '@' name	/* refers to a pid */
	    | RUN name LPAR arg_lst? RPAR priority?
	    | GET_PRIORITY LPAR expr RPAR			/* expr refers to a pid */
	    | SET_PRIORITY LPAR expr ',' expr RPAR		/* first expr refers to a pid */
        ;

expr	: any_expr
    	| LPAR expr RPAR
    	| expr andor expr
	    | chanpoll LPAR varref RPAR	/* may not be negated */
        ;

chanpoll: FULL | EMPTY | NFULL | NEMPTY;

uname   : name;
name	: NameLiteral;

constant	: TRUE | FALSE | SKIP_ | NumberLiteral | HOLE | '?'name;

string	: StringLiteral;

// LEXER

// Keywords

LPAR: '(';
RPAR: ')';
LBRAKET: '{';
RBRAKET: '}';
RARROW: '->';
SEMICOL: ';';
PROCTYPE: 'proctype';
NEVER: 'never';
TRACE: 'trace';
TYPEDEF: 'typedef';
MTYPE: 'mtype';
BIT: 'bit';
BOOL: 'bool';
BYTE: 'byte';
SHORT: 'short';
INT: 'int';
CHAN: 'chan';
ACTIVE: 'active';
PRIORITY: 'priority';
PROVIDED: 'provided';
HIDDEN_: 'hidden';
SHOW: 'show';
UNLESS: 'unless';
XR: 'xr';
XS: 'xs';
OF: 'of';
EVAL: 'eval';
IF: 'if';
FI: 'fi';
DO: 'do';
OD: 'od';
FOR: 'for';
ATOMIC: 'atomic';
D_STEP: 'd_step';
SELECT: 'select';
ELSE: 'else';
BREAK: 'break';
GOTO: 'goto';
PRINT: 'print';
IN: 'in';
ASSERT: 'assert';
LEN: 'len';
TIMEOUT: 'timeout';
NP_: 'np_';
ENABLED: 'enabled';
PC_VALUE: 'pc_value';
RUN: 'run';
GET_PRIORITY: 'get_priority';
SET_PRIORITY: 'set_priority';
INIT: 'init';
INLINE: 'inline'; 
LTL: 'ltl'; 
TRUE: 'true';
FALSE: 'false';
SKIP_: 'skip';
FULL: 'full';
EMPTY: 'empty';
NFULL: 'nfull';
NEMPTY: 'nempty';
HOLE: '???';
FEATURES: 'features';
DCOLON: '::';

// Literals

NameLiteral  : Alpha (Alpha | Digit)*;
StringLiteral: '"' StringCharacters? '"';
NumberLiteral: '0'
             | NonZeroDigit Digits?
             ;

WS: [ \t\r\n]+ -> skip;

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;

// Fragments

fragment StringCharacters:	StringCharacter+;
fragment StringCharacter:	~["\\\r\n];

fragment Alpha	: [a-zA-Z];
fragment NonZeroDigit: [1-9];
fragment Digits: Digit+;
fragment Digit	: [0-9];