
// SameGameView.h: Schnittstelle der Klasse CSameGameView
//

#pragma once


class CSameGameView : public CView
{
protected: // Nur aus Serialisierung erstellen
	CSameGameView();
	DECLARE_DYNCREATE(CSameGameView)

// Attribute
public:
	CSameGameDoc* GetDocument() const;

// Vorg�nge
public:

// �berschreibungen
public:
	virtual void OnDraw(CDC* pDC);  // �berschrieben, um diese Ansicht darzustellen
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:

// Implementierung
public:
	void ResizeWindow();
	virtual ~CSameGameView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generierte Funktionen f�r die Meldungstabellen
protected:
	DECLARE_MESSAGE_MAP()
public:
	virtual void OnInitialUpdate();

};

#ifndef _DEBUG  // Debugversion in SameGameView.cpp
inline CSameGameDoc* CSameGameView::GetDocument() const
   { return reinterpret_cast<CSameGameDoc*>(m_pDocument); }
#endif

