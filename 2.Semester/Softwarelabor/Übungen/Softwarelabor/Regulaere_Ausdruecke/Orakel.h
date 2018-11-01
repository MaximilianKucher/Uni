#include "RE.h"
#include <iostream>

RE* deriv(RE* r, char l) {

	switch (r->ofType()) {

	case PhiType: // leere Sprache enth�lt keine W�rter, 
		return r;	// also wird die leere Sprache(r) zur�ckgegeben

	case EpsType: // das leere Wort kann keinen Pr�fix haben
		return new Phi(); // also wird die leere Sprache zur�ckgegeben

	case ChType:
		if (((Ch*)r)->getChar() == l) {	// ein einzelnes Zeichen kann nur Pr�fix des leeren Wortes sein
			return new Eps();
		}
		else {	// falls r != l, dann gibt es keine W�rter von denen r Pr�fix sein kann,
			return new Phi();	// also wird die leere Sprache zur�ckgegeben
		}

	case StarType: {
		RE* r1 = ((Star*)r)->getRE();
		return new Conc(deriv(r1, l), r);
	}

	case AltType: {
		RE* r1 = ((Alt*)r)->getLeft();
		RE* r2 = ((Alt*)r)->getRight();
		return new Alt(deriv(r1, l), deriv(r2, l));
	}

	case ConcType: {
		RE* r1 = ((Conc*)r)->getLeft();
		RE* r2 = ((Conc*)r)->getRight();
		if (r1->containsEps()) {
			return new Alt(new Conc(deriv(r1, l), r2), deriv(r2, l));
		}
		else {
			return new Conc(deriv(r1, l), r2);
		}
	}

	}// switch

}

bool match(RE* r, string s) {
	for (int i = 0; i < s.length(); i++) {
		r = deriv(r, s[i]);
	}
	return r->containsEps();
}

bool orakel(RE* r, RE* rSimp, string s) {
	cout << "Regulaerer Ausdruck Orginal:" << r->pretty() << endl;
	cout << "Regulaerer Ausdruck Vereinfacht:" << r->simp()->pretty() << endl;
	cout << "Teste auf " << s << endl;
	if (match(r, s) == match(rSimp, s)) {
		cout << "Test OK!" << endl;
		cout << endl;
		return true;
	}
	else {
		cout << "Test FAIL!" << endl;
		cout << endl;
		return false;
	}
}