
// SameGame.h: Hauptheaderdatei f�r die SameGame-Anwendung
//
#pragma once

#ifndef __AFXWIN_H__
	#error "'stdafx.h' vor dieser Datei f�r PCH einschlie�en"
#endif

#include "resource.h"       // Hauptsymbole


// CSameGameApp:
// Siehe SameGame.cpp f�r die Implementierung dieser Klasse
//

class CSameGameApp : public CWinApp
{
public:
	CSameGameApp();


// �berschreibungen
public:
	virtual BOOL InitInstance();

// Implementierung
	afx_msg void OnAppAbout();
	DECLARE_MESSAGE_MAP()
};

extern CSameGameApp theApp;
