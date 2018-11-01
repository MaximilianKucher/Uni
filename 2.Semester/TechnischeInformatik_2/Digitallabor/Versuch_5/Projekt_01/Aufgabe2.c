#include "EigenerHeader.h"

#define OUTPUTMASKE 0x0080
#define INPUTMASKE 	0x0000

#define T_1 		P0_IN_P2
#define T_2 		P0_IN_P3
#define S_1			P0_IN_P0
#define S_2			P0_IN_P1
#define LED1_ROT 	P0_OUT_P4
#define LED2_GELB 	P0_OUT_P5
#define LED3_GRUEN  P0_OUT_P6

void aufgabe1 () {

	if(!(P0_IN & T_1) ) {
		P0_OUT &= ~LED1_ROT;
	} else {
		P0_OUT |= LED1_ROT;
	}

	if(!(P0_IN & T_2) ) {
		P0_OUT &= ~LED2_GELB;
	} else {
		P0_OUT |= LED2_GELB;
	}

}

void aufgabe2 () {

	if((!(P0_IN & T_1) ) && (P0_IN & S_1)) {
			P0_OUT &= ~LED1_ROT;
		} else {
			P0_OUT |= LED1_ROT;
		}

		if((!(P0_IN & T_2) ) && (P0_IN & S_2)) {
			P0_OUT &= ~LED2_GELB;
		} else {
			P0_OUT |= LED2_GELB;
		}

}


void main (void) {

	portinit();

	while(1) {
		aufgabe2();				
	}
}

void portinit() {
	// Outputs initialisieren
	P0_IOCR04 = OUTPUTMASKE;
	P0_IOCR05 = OUTPUTMASKE;
	P0_IOCR06 = OUTPUTMASKE;
	P0_IOCR07 = OUTPUTMASKE;
	
	//Inputs initialisieren
	P0_IOCR00 = INPUTMASKE;
	P0_IOCR01 = INPUTMASKE;
	P0_IOCR02 = INPUTMASKE;
	P0_IOCR03 = INPUTMASKE;	
}