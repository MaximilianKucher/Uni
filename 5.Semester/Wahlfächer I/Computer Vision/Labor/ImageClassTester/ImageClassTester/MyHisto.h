#pragma once

#include <fstream>
using namespace std;

class CMyImage;

class CMyHisto
{
  static const int HISTO_SIZE = 256;

  int m_data[HISTO_SIZE];
  int m_count;

public:
  CMyHisto(void);
  ~CMyHisto(void);

  int GetCount(){ return m_count; };

  void Reset();
  
  void Increment(unsigned char value);
  
  double CalcMeanValue();
  double CalcStandardDeviation(double mean);

  bool WriteHisto(const char* fileName);
  bool WriteNormalizedHisto(const char* fileName);

  int GetEntry(int i) const;
  double GetNormalizedEntry(int i) const;
};
