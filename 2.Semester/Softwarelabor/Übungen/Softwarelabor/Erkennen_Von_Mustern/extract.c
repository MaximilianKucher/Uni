#include <stdio.h>
#include <stdlib.h>

typedef enum {
	OK,
	FAIL
} Test;


char* extract(char* input) {

	int countDoublePoints = 0;
	char* output = input;


	// solange der string noch nicht zu ende ist
	while (*input != '\0') {
		if (*input == ':') {
			countDoublePoints++;
		}
		else {
			countDoublePoints = 0;
		}
		if ((countDoublePoints >= 2) & (*(input + 1) != ':')) {
			output = input + 1;
			countDoublePoints = 0;
		}
		input++;
	}
	return output;
}

void testExtract() {
	Test t = OK;
	char* testsExtract[10] = { "",
		"::",
		":HALO",
		":::",
		"Hall:oo::ooo:",
		"a",
		"5:1:",
		"::asdfasdf:::",
		"input:Test",
		"input2::::Te::s:t" };


	char* testsExtractExpectedOutputs[10] = { "",
		"",
		":HALO",
		"",
		"ooo:",
		"a",
		"5:1:",
		"",
		"input:Test",
		"s:t" };


	int i;
	int k = 0;
	int counter = 0;
	char* outputExtract;

	for (i = 0; i < 10; i++) {
		printf("           input   %s\n", testsExtract[i]);
		printf("exptected output   %s\n", testsExtractExpectedOutputs[i]);
		printf("          output   %s\n", extract(testsExtract[i]));

		outputExtract = extract(testsExtract[i]);

		// Vergleichen der Strings
		while (*testsExtractExpectedOutputs[i] != '\0') {
			if (*testsExtractExpectedOutputs[i] == *outputExtract) {
				t = OK;
				k++;
				testsExtractExpectedOutputs[i]++;
				outputExtract++;
			}
			else {
				t = FAIL;
				break;
			}
		}

		if (t == OK) {
			printf("Test %d OK!\n\n", (i + 1));
		}
		else {
			printf("Test %d FAILED!\n\n", (i + 1));
		}
	}
}

void extract2(char* input, char** output) {
	*output = extract(input);
}


// noch nicht fertig!
char* extract3(char* pattern, char* input) {
	char null = ' ';
	char* output = &null;
	return output;
}

int main() {
	//char example[] = "::asdfasdf::";
	//char* examplePointer = example;
	//char** examplePointer2 = &examplePointer;
	//
	//extract2(example, examplePointer2);
	//
	//printf("%s\n", extract(example));
	//printf("%s\n\n\n", *examplePointer2);

	testExtract();

	return 0;
}

