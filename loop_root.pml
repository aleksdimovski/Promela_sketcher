//features int[0,3] F1

active proctype foo ( ) { 
	byte x=10; 
	int y=0; 
	if 
	:: true -> do :: (x>6) -> x--; y++
	   	  :: else-> break
		od
	:: true -> do :: (x>7) -> x--; y++
	   		:: else-> break
		od
	:: true -> do :: (x>8) -> x--; y++;
	  	 :: else-> break
		od
	fi;
	assert(y>2)

} 
