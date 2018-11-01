#include <stdio.h>
#include <iostream>
#include <string>

#define CallByRef(t,x) t* x

#define DeRef(x) *x

#define PassByRef(x) &x








int inc(int x) {
	x++;
	return x;
}

void incByRef(int x, CallByRef(int, y)) {
	x++;
	DeRef(y) = x;
}

