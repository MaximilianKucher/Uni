#include <stdio.h>

#define LOWMASK 0x00ff
#define HIGHMASK 0xff00


typedef enum {
	Stop = 0,
	Start = 1,
	Finish = 5,
	Fail = 255
} Status;

typedef enum {
	One = 1,
	Fifteen = 15,
	Last = 255
} Numbers;

typedef enum {
	OK,
	FAIL
} Test;

typedef struct {
	Status input1;
	Numbers input2;
} TestSD;


unsigned short int switchLowHighByte(unsigned short int i) {

	return (i & LOWMASK) << 8 | (i & HIGHMASK) >> 8;
}



Test testLowHigh(unsigned short int i) {
	Test t;

	// Test execution
	if (i == switchLowHighByte(switchLowHighByte(i)))
		t = OK;
	else
		t = FAIL;

	return t;
}



void serialize(Status s, Numbers n, unsigned short int* data) {

	*data = (unsigned short int)(s | (n << 8));
}



void deserialize(unsigned short int data, Status* s, Numbers* n) {

	*s = (Status)(data & LOWMASK);
	*n = (Numbers)((data & HIGHMASK) >> 8);
}



Test testSD(Status s, Numbers n) {
	Test t;
	unsigned short int data;
	Status s2;
	Numbers n2;

	// Test execution
	serialize(s, n, &data);
	deserialize(data, &s2, &n2);

	if (s2 == s && n2 == n) {
		t = OK;
	}
	else {
		t = FAIL;
	}
	return t;
}



void runTests() {
	const int no1 = 5;
	const int no2 = 3;
	unsigned short int testsLowHigh[5] = { 0x6528, 0xa528, 0x65a8, 0xf5b8, 0xeeff };
	TestSD testsSD[3] = { { Stop, Fifteen },{ Start,Last },{ Fail,Fifteen } };
	int i;
	int j;

	unsigned short int data;


	for (i = 0; i < no1; ++i) {
		if (testLowHigh(testsLowHigh[i]) == OK) {
			printf("input: %x, output: %x\n", testsLowHigh[i], switchLowHighByte(testsLowHigh[i]));
			printf("Test %d: OK \n\n", i + 1);
		}
		else {
			printf("input: %x, output: %x\n", testsLowHigh[i], switchLowHighByte(testsLowHigh[i]));
			printf("Test %d: FAIL \n\n", i + 1);
		}
	}


	for (j = 0; j < no2; ++j) {
		if (testSD(testsSD[j].input1, testsSD[j].input2) == OK) {
			printf("Serialize:\n");
			serialize(testsSD[j].input1, testsSD[j].input2, &data);
			printf("input: %x und %x, output: %x\n", testsSD[j].input1, testsSD[j].input2, data);
			deserialize(data, &testsSD[j].input1, &testsSD[j].input2);
			printf("Deserialize:\n");
			printf("input: %x, output: %x und %x\n", data, testsSD[j].input1, testsSD[j].input2);
			printf("Test %d: OK\n\n\n", j + 1);
		}
		else {
			printf("input: %x und %x, output: \n", testsSD[j].input1, testsSD[j].input2);
			printf("Test %d: FAIL\n\n\n", j + 1);
		}
	}
}



main() {
	runTests();
}
