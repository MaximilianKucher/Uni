// String.cpp
#include <iostream>
using namespace std;

#include "String.h"

// Gibt die Länge eines Strings zurück (inklusive des '\0' terminators).
// Laesst den String unveraendert.
int getLengthOfString(const char* input) {
	int counter = 1;
	const char** adresseInput = &input;
	while (*input != '\0') {
		input++;
		counter++;
	}
	input = *adresseInput;
	return counter;
}

// Erzeugt einen String der Laenge 0
String::String() {
	size = 0;
	str = new char[1];
	str[0] = '\0';
}

// Erzeugt einen String der Laenge 1 der genau ein char zeichen enthält
String::String(char c) {
	size = 1;
	str = new char[2];
	str[0] = c;
	str[1] = '\0';
}

// Erzeugt einen String aus einem char-Array mit genau der Länge der Anzahl der Elemente des Arrays
String::String(const char *s) {
	size = getLengthOfString(s) - 1;
	str = new char[size];
	for (int i = 0; i < size; i++) {
		str[i] = *s;
		s++;
	}
}

// Erzeugt eine deep copy eines Strings
String::String(const String& s) {
	size = s.size;
	str = new char[size];
	for (int i = 0; i < size; i++) {
		str[i] = s.str[i];
	}
}

String::~String() {
	delete[] str;
	cout << "String-Destruktor" << endl;
}


char& String::operator[](int index) {
	return str[index];
}


// Aendern der Referenz von 
String& String::operator=(String& s) {
	return String(s);
}


// Konkateniert zwei Strings s1 und s2, die Referenz auf das Ergebnis ist s1
String& String::operator+=(String& s) {
	int counter = 0;
	int rememberSize = size;
	size += s.size;
	// hier wird this kopiert
	String buffer = *this;
	(*this).str = new char[size + 1];
	// buffer wieder in neues this kopieren
	for (int i = 0; i < rememberSize; i++) {
		str[i] = buffer.str[i];
	}
	// dahinter wird s angehängt
	for (int i = rememberSize; i < size; i++) {
		str[i] = s.str[counter];
		counter++;
	}
	return *this;
}