features int[60,315] F1

byte N = 4;
byte MAX = 0; 
byte distance[16];
byte city, dest, tour, seen;
bool visited[4]

inline travel2 (dest) {

	(city != dest && tour <= MAX) ->

	tour = tour + distance[4*city+dest]
	city = dest
	if
	:: !visited[city] ->
		visited[city] = true;  
		seen++
	:: else
	fi
}

init {
	MAX = ?F1
	distance[1] = 20;	distance[4] = 20
	distance[2] = 42;	distance[6] = 30
	distance[3] = 35;	distance[7] = 34

	distance[8] = 42;	distance[12] = 35
	distance[9] = 30;	distance[13] = 34
	distance[11] = 12;	distance[14] = 12

	// find shortest route to visit all nodes starting and ending at 0
	do
	:: select(dest : 0 .. 3) -> travel2(dest)
	od

}

ltl p { [] ((seen < N) || (tour > MAX)) }

// exercises:
// 1.	change it so that the distance going from a higher
//	city number to a lower number is half that of going
//	the other way (downhill/uphill)
// 2.	change it to find the longest iso shortest tour
