#include "String.h"

ostream& operator<< (ostream &out, String &s) {
	for (int i = 0; i < s.size; i++) {
		out << s.str[i];
	}

	return out;
}


int main() {
	/*String s1("asdf");
	String s2("Hello");
	String s3(s2);

	s1 += s2;
	s2 = s3;
	s1[5] = 'E';

	cout << s1 << endl;
	cout << s2 << endl;
	cout << s2[2] << endl;
	cout << s1[5] << endl;
	cout << s1.getSize() << endl;

	s1.~String();
	s2.~String();
	s3.~String();*/
	String s1("asdf");
	cout << "1" << endl;
	String s2("Hello");
	cout << "2" << endl;
	String s3(s2);
	cout << "3" << endl;
	s1 += s2;
	cout << "4" << endl;
	s2 = s3;
	cout << "5" << endl;
	cout << s1 << endl;
	cout << s2 << endl;
	cout << s2[2] << endl;
	cout << s3 << endl;
};