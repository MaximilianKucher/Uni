// Main fuer Teilaufgabe 1
// Bitte weitere Testfaelle hinzufuegen.


#include "RE.h"
#include "Orakel.h"
#include <iostream>

using namespace std;

int main() {

	// phi | c
	RE* r3 = new Alt(new Phi(), new Ch('c'));
	orakel(r3, r3->simp(), "c");

	// c | phi
	RE* r4 = new Alt(new Ch('c'), new Phi());
	orakel(r4, r4->simp(), "c");

	// c**
	RE* r5 = new Star(new Star(new Ch('c')));
	orakel(r5, r5->simp(), "c");

	// phi*
	RE* r6 = new Star(new Phi());
	orakel(r6, r6->simp(), "something");

	// (phi | c) | c**
	RE* r7 = new Alt(r3, r5);
	orakel(r7, r7->simp(), "c");

	// ((phi | c) | c**)*
	RE* r8 = new Star(r7);
	orakel(r8, r8->simp(), "c");

	// (0|1)*((01)|(10))
	RE* r9 = new Conc(new Star(new Alt(new Ch('0'), new Ch('1'))), new Alt(new Conc(new Ch('0'), new Ch('1')), new Conc(new Ch('1'), new Ch('0'))));
	orakel(r9, r9->simp(), "01");

}