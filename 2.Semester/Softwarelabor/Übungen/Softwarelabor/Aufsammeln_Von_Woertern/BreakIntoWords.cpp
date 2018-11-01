#include "stdio.h"
#include <stdlib.h>


typedef enum {
	OK,
	FAIL
} Test;

typedef enum {
	TRUE = 1,
	FALSE = 0
} Boolean;


// Gibt die Länge eines Strings zurück (inklusive des '\0' terminators).
// Laesst den String unveraendert.
int getLengthOfString(char* input) {
	int counter = 1;
	char** adresseInput = &input;
	while (*input != '\0') {
		input++;
		counter++;
	}
	input = *adresseInput;
	return counter;
}


// Vergleicht ob zwei strings den gleichen Inhalt haben.
// Lässt die Strings unveraendert.
// Rueckgabe: True/False.
Boolean stringsSindGleich(char* input1, char* input2) {
	int i;
	char** adresseInput1 = &input1;
	char** adresseInput2 = &input2;
	int lengthInput1 = getLengthOfString(input1);
	if (lengthInput1 != getLengthOfString(input2)) {
		return FALSE;
	}
	else {
		for (i = 0; i < lengthInput1; i++) {
			while (*input1 != '\0') {
				if (*input1 == *input2) {
					input1++;
					input2++;
				}
				else {
					input1 = *adresseInput1;
					input2 = *adresseInput2;
					return FALSE;
				}
			}
		}
		input1 = *adresseInput1;
		input2 = *adresseInput2;
		return TRUE;
	}
}

// Ueberspringe alle Leerzeichen
// Rueckgabe: Zeiger auf das erste Nichtleerzeichen
char* leerzeichen(char* input) {
	while (*input == ' ')
		input++;
	return input;
}

// Scanne durch string solange bis wir auf ein
// Leerzeichen oder das Ende des Strings treffen.
// Effektiv ueberspringen wir ein Wort.
// Rueckgabe: Zeiger auf Ende oder Leerzeichen.
char* zeichen(char* input) {
	while (*input != '\0' && *input != ' ')
		input++;
	return input;
}


// line enthält einen String, welcher sich eventuell in einzelne woerter unterteilen lassen kann
// line wird kopiert und bleibt unverändert
// maxwords bestimmt die maximale anzahl der woerter die extrahiert werden
// in words[] werden die extrahierten wörter zu finden sein
int breakIntoWords(char* line, int maxwords, char* words[]) {
	int lengthOfLine = getLengthOfString(line);
	int i;
	char* copyLineBuffer = (char*)malloc(lengthOfLine * sizeof(char));
	char* copyLine = copyLineBuffer;
	char* newWord;
	int counter = 0;

	// kopieren von line in copyLineBuffer, copyLine zeigt am Ende noch auf copyLineBuffer
	for (i = 0; i < lengthOfLine; i++, copyLineBuffer++, line++) {
		*copyLineBuffer = *line;
	}

	// anfang des ersten Wortes merken
	newWord = copyLine;

	// so lange line noch nicht zu ende ist und noch nicht die maximale Anzahl der Wörter in words gespeichert wurde mache weiter
	while ((maxwords > 0) && (*copyLine != '\0')) {

		// ueberspringe alle leerzeichen
		copyLine = leerzeichen(copyLine);

		// das nächste Wort markieren
		newWord = copyLine;

		// ende des Wortes finden
		copyLine = zeichen(copyLine);

		// falls line noch nicht auf das Ende zeigt befinden wir uns auf einem leerzeichen und schreiben '\0' um das Wort zu "extrahieren", dann erhöhe copyLine um 1
		if (*copyLine != '\0') {
			*copyLine = '\0';
			copyLine++;
		}

		// extrahiere ein wort
		words[counter] = newWord;

		maxwords--;
		counter++;
	}

	return counter;
}

Test testBreakIntoWords(char* line, const int maxwords, char* expectedWords[], char* words[]) {
	Test t;
	int i;
	printf("input:  %s\n\noutput:\n", line);
	breakIntoWords(line, maxwords, words);
	for (i = 0; i < maxwords; i++) {
		printf("        %s\n", words[i]);
		if (stringsSindGleich(words[i], expectedWords[i]) == TRUE) {
			t = OK;
		}
		else {
			t = FAIL;
			return t;
		}
	}
	return t;
}

int main() {
	char* expectedWords1[4] = { "wort1","wort2","wort3","4" };
	char* words1[4];
	char* expectedWords2[4] = { "wort1","wort2","wort3","4" };
	char* words2[4];
	char* expectedWords3[6] = { "wort1","wort2","3","4444","fuenf","sechs6" };
	char* words3[6];

	if (testBreakIntoWords("wort1 wort2 wort3 4", 2, expectedWords1, words1) == OK) {
		printf("Test1: OK!\n\n");
	}
	else {
		printf("Test1: FAIL!\n\n");
	}

	if (testBreakIntoWords(" wort1 wort2 wort3 4 ", 4, expectedWords2, words2) == OK) {
		printf("Test2: OK!\n\n");
	}
	else {
		printf("Test2: FAIL!\n\n");
	}

	if (testBreakIntoWords("   wort1 wort2 3 4444 fuenf sechs6    ", 6, expectedWords3, words3) == OK) {
		printf("Test2: OK!\n\n");
	}
	else {
		printf("Test2: FAIL!\n\n");
	}
	return 0;
}

