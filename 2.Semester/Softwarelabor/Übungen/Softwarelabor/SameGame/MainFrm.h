
// MainFrm.h: Schnittstelle der Klasse CMainFrame
//

#pragma once

class CMainFrame : public CFrameWnd
{
	
protected: // Nur aus Serialisierung erstellen
	CMainFrame();
	DECLARE_DYNCREATE(CMainFrame)

// Attribute
public:

// Vorg�nge
public:

// �berschreibungen
public:
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);

// Implementierung
public:
	virtual ~CMainFrame();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif


// Generierte Funktionen f�r die Meldungstabellen
protected:
	DECLARE_MESSAGE_MAP()

};


