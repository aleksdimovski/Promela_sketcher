features int[0,255] F1

active proctype foo ( ) { 
	byte x=10; 
	int y=0; 
	do :: (x>?F1) -> x--; y++
	   :: else-> break
	od
	assert(y<6)
} 
