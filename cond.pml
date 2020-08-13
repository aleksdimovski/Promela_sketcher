features int[0,7] F1

active proctype foo() {
	byte x=0; 
	int y=0;      
	do :: break 
		:: x++
	od;	
	do :: (x>0) -> x--; if :: (y<?F1) -> y++ :: else -> y-- fi
	   :: else -> break 
	od 		
	assert(y<=1)		
}			
