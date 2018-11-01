
// SameGame.h: Hauptheaderdatei für die SameGame-Anwendung
//
#pragma once

#ifndef __AFXWIN_H__
	#error "'stdafx.h' vor dieser Datei für PCH einschließen"
#endif

#include "resource.h"       // Hauptsymbole


// CSameGameApp:
// Siehe SameGame.cpp für die Implementierung dieser Klasse
//

class CSameGameApp : public CWinApp
{
public:
	CSameGameApp();


// Überschreibungen
public:
	virtual BOOL InitInstance();

// Implementierung
	afx_msg void OnAppAbout();
	DECLARE_MESSAGE_MAP()
};

extern CSameGameApp theApp;
