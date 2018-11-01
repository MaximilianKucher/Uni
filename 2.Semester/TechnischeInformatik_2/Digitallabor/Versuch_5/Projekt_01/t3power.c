#include "XE164F_HS.h"

#define VT128		0x4
#define T3_TIMER	0x0

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


void t3power(void)
{
  unsigned int PWD, temp;
 
    SCU_SLC = 0xAAAA;            
    SCU_SLC = 0x5554;              

    PWD = SCU_SLS & 0x00FF;
    PWD = (~PWD) & 0x00FF;

    SCU_SLC = 0x9600 | PWD;    
    SCU_SLC = 0x0000;                

		
	GPT12E_KSCCFG = 3;
	temp = GPT12E_KSCCFG;

}


void t3init(void) {
	t3power();
	T3CON =  VT128	 	// vorteiler
			|T3_TIMER	// timer mode
			|T3UD		// count down
			|T3OE;		// Pin frei

	T3CON |= T3R; // starte T3
	
}


void main(void) {
	portinit();
	t3init();

	while(1) {
	
	/*if(T3CON & T3OTL) {
		P0_OUT &= ~LED3_GRUEN;
	} */

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
}