#define rand	pan_rand
#define pthread_equal(a,b)	((a)==(b))
#if defined(HAS_CODE) && defined(VERBOSE)
	#ifdef BFS_PAR
		bfs_printf("Pr: %d Tr: %d\n", II, t->forw);
	#else
		cpu_printf("Pr: %d Tr: %d\n", II, t->forw);
	#endif
#endif
	switch (t->forw) {
	default: Uerror("bad forward move");
	case 0:	/* if without executable clauses */
		continue;
	case 1: /* generic 'goto' or 'skip' */
		IfNotBlocked
		_m = 3; goto P999;
	case 2: /* generic 'else' */
		IfNotBlocked
		if (trpt->o_pm&1) continue;
		_m = 3; goto P999;

		 /* CLAIM p */
	case 3: // STATE 1 - _spin_nvr.tmp:3 - [(!(((seen<N)||(tour>MAX))))] (6:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[1][1] = 1;
		if (!( !(((((int)now.seen)<((int)now.N))||(((int)now.tour)>((int)now.MAX))))))
			continue;
		/* merge: assert(!(!(((seen<N)||(tour>MAX)))))(0, 2, 6) */
		reached[1][2] = 1;
		spin_assert( !( !(((((int)now.seen)<((int)now.N))||(((int)now.tour)>((int)now.MAX))))), " !( !(((seen<N)||(tour>MAX))))", II, tt, t);
		/* merge: .(goto)(0, 7, 6) */
		reached[1][7] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 4: // STATE 10 - _spin_nvr.tmp:8 - [-end-] (0:0:0 - 1)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported10 = 0;
			if (verbose && !reported10)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported10 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[1][10] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC :init: */
	case 5: // STATE 1 - brute68.pml:17 - [MAX = 68] (0:0:1 - 1)
		IfNotBlocked
		reached[0][1] = 1;
		(trpt+1)->bup.oval = ((int)now.MAX);
		now.MAX = 68;
#ifdef VAR_RANGES
		logval("MAX", ((int)now.MAX));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 6: // STATE 2 - brute68.pml:18 - [distance[1] = 20] (0:0:1 - 1)
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[1]);
		now.distance[1] = 20;
#ifdef VAR_RANGES
		logval("distance[1]", ((int)now.distance[1]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 7: // STATE 3 - brute68.pml:19 - [distance[4] = 20] (0:0:1 - 1)
		IfNotBlocked
		reached[0][3] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[4]);
		now.distance[4] = 20;
#ifdef VAR_RANGES
		logval("distance[4]", ((int)now.distance[4]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 8: // STATE 4 - brute68.pml:20 - [distance[2] = 42] (0:0:1 - 1)
		IfNotBlocked
		reached[0][4] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[2]);
		now.distance[2] = 42;
#ifdef VAR_RANGES
		logval("distance[2]", ((int)now.distance[2]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 9: // STATE 5 - brute68.pml:21 - [distance[6] = 30] (0:0:1 - 1)
		IfNotBlocked
		reached[0][5] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[6]);
		now.distance[6] = 30;
#ifdef VAR_RANGES
		logval("distance[6]", ((int)now.distance[6]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 10: // STATE 6 - brute68.pml:22 - [distance[3] = 35] (0:0:1 - 1)
		IfNotBlocked
		reached[0][6] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[3]);
		now.distance[3] = 35;
#ifdef VAR_RANGES
		logval("distance[3]", ((int)now.distance[3]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 11: // STATE 7 - brute68.pml:23 - [distance[7] = 34] (0:0:1 - 1)
		IfNotBlocked
		reached[0][7] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[7]);
		now.distance[7] = 34;
#ifdef VAR_RANGES
		logval("distance[7]", ((int)now.distance[7]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 12: // STATE 8 - brute68.pml:24 - [distance[8] = 42] (0:0:1 - 1)
		IfNotBlocked
		reached[0][8] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[8]);
		now.distance[8] = 42;
#ifdef VAR_RANGES
		logval("distance[8]", ((int)now.distance[8]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 13: // STATE 9 - brute68.pml:25 - [distance[12] = 35] (0:0:1 - 1)
		IfNotBlocked
		reached[0][9] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[12]);
		now.distance[12] = 35;
#ifdef VAR_RANGES
		logval("distance[12]", ((int)now.distance[12]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 14: // STATE 10 - brute68.pml:26 - [distance[9] = 30] (0:0:1 - 1)
		IfNotBlocked
		reached[0][10] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[9]);
		now.distance[9] = 30;
#ifdef VAR_RANGES
		logval("distance[9]", ((int)now.distance[9]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 15: // STATE 11 - brute68.pml:27 - [distance[13] = 34] (0:0:1 - 1)
		IfNotBlocked
		reached[0][11] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[13]);
		now.distance[13] = 34;
#ifdef VAR_RANGES
		logval("distance[13]", ((int)now.distance[13]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 16: // STATE 12 - brute68.pml:28 - [distance[11] = 12] (0:0:1 - 1)
		IfNotBlocked
		reached[0][12] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[11]);
		now.distance[11] = 12;
#ifdef VAR_RANGES
		logval("distance[11]", ((int)now.distance[11]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 17: // STATE 13 - brute68.pml:29 - [distance[14] = 12] (0:0:1 - 1)
		IfNotBlocked
		reached[0][13] = 1;
		(trpt+1)->bup.oval = ((int)now.distance[14]);
		now.distance[14] = 12;
#ifdef VAR_RANGES
		logval("distance[14]", ((int)now.distance[14]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 18: // STATE 14 - brute68.pml:30 - [dest = 0] (0:0:1 - 1)
		IfNotBlocked
		reached[0][14] = 1;
		(trpt+1)->bup.oval = ((int)now.dest);
		now.dest = 0;
#ifdef VAR_RANGES
		logval("dest", ((int)now.dest));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 19: // STATE 15 - brute68.pml:30 - [dest = 1] (0:0:1 - 1)
		IfNotBlocked
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((int)now.dest);
		now.dest = 1;
#ifdef VAR_RANGES
		logval("dest", ((int)now.dest));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 20: // STATE 16 - brute68.pml:30 - [dest = 2] (0:0:1 - 1)
		IfNotBlocked
		reached[0][16] = 1;
		(trpt+1)->bup.oval = ((int)now.dest);
		now.dest = 2;
#ifdef VAR_RANGES
		logval("dest", ((int)now.dest));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 21: // STATE 17 - brute68.pml:30 - [dest = 3] (0:0:1 - 1)
		IfNotBlocked
		reached[0][17] = 1;
		(trpt+1)->bup.oval = ((int)now.dest);
		now.dest = 3;
#ifdef VAR_RANGES
		logval("dest", ((int)now.dest));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 22: // STATE 20 - brute68.pml:9 - [(((city!=dest)&&(tour<=MAX)))] (0:0:0 - 1)
		IfNotBlocked
		reached[0][20] = 1;
		if (!(((((int)now.city)!=((int)now.dest))&&(((int)now.tour)<=((int)now.MAX)))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 23: // STATE 21 - brute68.pml:10 - [tour = (tour+distance[((4*city)+dest)])] (0:0:1 - 1)
		IfNotBlocked
		reached[0][21] = 1;
		(trpt+1)->bup.oval = ((int)now.tour);
		now.tour = (((int)now.tour)+((int)now.distance[ Index(((4*((int)now.city))+((int)now.dest)), 16) ]));
#ifdef VAR_RANGES
		logval("tour", ((int)now.tour));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 24: // STATE 22 - brute68.pml:11 - [city = dest] (0:0:1 - 1)
		IfNotBlocked
		reached[0][22] = 1;
		(trpt+1)->bup.oval = ((int)now.city);
		now.city = ((int)now.dest);
#ifdef VAR_RANGES
		logval("city", ((int)now.city));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 25: // STATE 23 - brute68.pml:12 - [(!(visited[city]))] (0:0:0 - 1)
		IfNotBlocked
		reached[0][23] = 1;
		if (!( !(((int)now.visited[ Index(((int)now.city), 4) ]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 26: // STATE 24 - brute68.pml:12 - [visited[city] = 1] (0:0:1 - 1)
		IfNotBlocked
		reached[0][24] = 1;
		(trpt+1)->bup.oval = ((int)now.visited[ Index(((int)now.city), 4) ]);
		now.visited[ Index(now.city, 4) ] = 1;
#ifdef VAR_RANGES
		logval("visited[city]", ((int)now.visited[ Index(((int)now.city), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 27: // STATE 25 - brute68.pml:12 - [seen = (seen+1)] (0:0:1 - 1)
		IfNotBlocked
		reached[0][25] = 1;
		(trpt+1)->bup.oval = ((int)now.seen);
		now.seen = (((int)now.seen)+1);
#ifdef VAR_RANGES
		logval("seen", ((int)now.seen));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 28: // STATE 33 - brute68.pml:33 - [-end-] (0:0:0 - 1)
		IfNotBlocked
		reached[0][33] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */
	case  _T5:	/* np_ */
		if (!((!(trpt->o_pm&4) && !(trpt->tau&128))))
			continue;
		/* else fall through */
	case  _T2:	/* true */
		_m = 3; goto P999;
#undef rand
	}

