	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* CLAIM p */
;
		
	case 3: // STATE 1
		goto R999;

	case 4: // STATE 10
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC :init: */

	case 5: // STATE 1
		;
		now.MAX = trpt->bup.oval;
		;
		goto R999;

	case 6: // STATE 2
		;
		now.distance[1] = trpt->bup.oval;
		;
		goto R999;

	case 7: // STATE 3
		;
		now.distance[4] = trpt->bup.oval;
		;
		goto R999;

	case 8: // STATE 4
		;
		now.distance[2] = trpt->bup.oval;
		;
		goto R999;

	case 9: // STATE 5
		;
		now.distance[6] = trpt->bup.oval;
		;
		goto R999;

	case 10: // STATE 6
		;
		now.distance[3] = trpt->bup.oval;
		;
		goto R999;

	case 11: // STATE 7
		;
		now.distance[7] = trpt->bup.oval;
		;
		goto R999;

	case 12: // STATE 8
		;
		now.distance[8] = trpt->bup.oval;
		;
		goto R999;

	case 13: // STATE 9
		;
		now.distance[12] = trpt->bup.oval;
		;
		goto R999;

	case 14: // STATE 10
		;
		now.distance[9] = trpt->bup.oval;
		;
		goto R999;

	case 15: // STATE 11
		;
		now.distance[13] = trpt->bup.oval;
		;
		goto R999;

	case 16: // STATE 12
		;
		now.distance[11] = trpt->bup.oval;
		;
		goto R999;

	case 17: // STATE 13
		;
		now.distance[14] = trpt->bup.oval;
		;
		goto R999;

	case 18: // STATE 14
		;
		now.dest = trpt->bup.oval;
		;
		goto R999;

	case 19: // STATE 15
		;
		now.dest = trpt->bup.oval;
		;
		goto R999;

	case 20: // STATE 16
		;
		now.dest = trpt->bup.oval;
		;
		goto R999;

	case 21: // STATE 17
		;
		now.dest = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 23: // STATE 21
		;
		now.tour = trpt->bup.oval;
		;
		goto R999;

	case 24: // STATE 22
		;
		now.city = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 26: // STATE 24
		;
		now.visited[ Index(now.city, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 27: // STATE 25
		;
		now.seen = trpt->bup.oval;
		;
		goto R999;

	case 28: // STATE 33
		;
		p_restor(II);
		;
		;
		goto R999;
	}

