/* 
 a problem due to W. Feijen
  [described in D. Gries, "The Science of Programming,"
  Springer, New York, 1981]
 a, b, and c are three ordered lists of integers
 (originally: three magnetic tapes with sorted lists of names;
  a list of welfare recipients, a payroll list of a company,
  and a list of University students)
 At least one element appears in all three lists.
 Find the smallest indices i, j, and k such that a[i] == b[j] == c[k]
 (i.e., the first name in alphabetical order
  that appears in all three lists)
*/

features int[15,270] F1

int a[5], b[5], c[5]

active proctype cr()
{	byte i, j, k

	a[0] = 1; a[1] = 3; a[2] =  4; a[3] = 23; a[4] = 48
	b[0] = 1; b[1] = 4; b[2] = 18; b[3] = 23; b[4] = 45
	c[0] = 5; c[1] = 8; c[2] = 12;  c[3] = 14; 
	c[4] = ?F1;

	do	/* non-deterministic */
	:: a[i] < b[j] && i<4 -> i++
	:: b[j] < c[k] && j<4 -> j++
	:: c[k] < a[i] && k<4 -> k++
	:: else -> break
	od;
	assert(a[i] == b[j] && b[j] == c[k])
	assert(i < 5 && j < 5 && k < 5)
}
