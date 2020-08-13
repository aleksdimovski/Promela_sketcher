

active proctype foo ( ) { 
	byte x=0; 
	int y=0; 
	do :: break
		 :: x++
	 od;
	if :: y = 0*x
		 :: y = 1*x
		 :: y = 2*x
		 :: y = 3*x
		 :: y = 4*x
		 :: y = 5*x
	fi;
	assert(y<=x+x)

} 