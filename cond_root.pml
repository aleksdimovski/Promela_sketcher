//features int[0,3] F1

active proctype foo() {
	byte x=0; 
	int y=0;      
	do :: break 
		:: x++
	od;	
	if 
	:: true -> 	do :: (x>0) -> x--; if :: (y<0) -> y++ :: else -> y-- fi
	   				:: else -> break 
				od
	:: true -> do :: (x>0) -> x--; if :: (y<1) -> y++ :: else -> y-- fi
	   				:: else -> break 
				od
	:: true -> do :: (x>0) -> x--; if :: (y<2) -> y++ :: else -> y-- fi
	   				:: else -> break 
				od
	fi;	
	assert(y<=1)		
}			
