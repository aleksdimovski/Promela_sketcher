features int[0,7] F1

active proctype foo() {
	byte x=0; 
	int y=0;      
	do :: break 
		:: x++
	od;	
	y=?F1*x;			
	assert(y==x+x)		
}			
