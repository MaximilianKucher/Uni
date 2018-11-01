
/***********************************************************************************************
* Mit dieser Vorlage können Sie die einzelnen Teilaufgaben bei der Abnahme schnell anwählen    *
* Der Quelltext von Aufgabe a ist schon eingetragen. Für die anderen Teilaufgaben kopieren Sie *
* diesen Quelltext in die entsprechenden Bereiche der Vorlage und modifizieren ihn.            *
*                                                                                              *
* Welcher Quelltext dann übersetzt werden soll, bestimmen Sie in den Target Options / C166     *
* Dort tragen Sie im Feld "Define:" einfach "TEIL_A" oder "TEIL_B" oder "TEIL_C" usw. ein.     *
***********************************************************************************************/


#ifdef TEIL_A //Teilaufgabe a)

void main(void) {
	int fahr, celsius;
	int lower, upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = 5 * (fahr-32) / 9;
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe a)



#ifdef TEIL_B  //Teilaufgabe b)

int celsius;

void main(void) {
	int fahr;
	int lower, upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = 5 * (fahr-32) / 9;
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe b)



#ifdef TEIL_C //Teilaufgabe c)

int fahr2cels(int fahr) {
	return 5 * (fahr - 32) / 9;
}

void main(void) {
	int fahr,celsius;
	int lower, upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = fahr2cels(fahr);
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe c)



#ifdef TEIL_D1 //Teilaufgabe d)	mit long

long fahr2cels(long fahr) {
	return 5 * (fahr - 32) / 9;
}

void main(void) {
	long fahr,celsius;
	int lower, upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = fahr2cels(fahr);
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe d) mit long



#ifdef TEIL_D2 //Teilaufgabe d)	mit float

float fahr2cels(float fahr) {
	return 5 * (fahr - 32) / 9;
}

void main(void) {
	float fahr,celsius;
	int lower, upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = fahr2cels(fahr);
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe d) mit float



#ifdef TEIL_D3 //Teilaufgabe d)	mit double

double fahr2cels(double fahr) {
	return 5 * (fahr - 32) / 9;
}

void main(void) {
	double fahr,celsius;
	int lower,upper,step;

	lower = 0;
	upper = 300;
	step = 20;


	fahr = lower;
	while (fahr <= upper) {
		celsius = fahr2cels(fahr);
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe d) mit double



#ifdef TEIL_E //Teilaufgabe e)
/* Kleiner Tipp: Wann verwendet man eine while und wann eine for Schleife? */

double fahr2cels(double fahr) {
	return 5 * (fahr - 32) / 9;
}

void main(void) {
	double fahr,celsius;
	int lower,step,i;

	lower = 0;
	step = 20;


	fahr = lower;
	for (i = 0; i < 15; i++) {
		celsius = fahr2cels(fahr);
		fahr = fahr + step;
	}
}

#endif //Teilaufgabe e)


