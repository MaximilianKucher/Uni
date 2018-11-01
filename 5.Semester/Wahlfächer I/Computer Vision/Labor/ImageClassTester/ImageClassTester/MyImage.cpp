#include "StdAfx.h"
#include "MyImage.h"
#include "math.h"

CMyImage::CMyImage(void)
{
  m_width = 0;
  m_height = 0;
  m_pData = NULL;
}

CMyImage::CMyImage(const CMyImage& toCopy)
{
  m_pData = NULL;
  Copy(toCopy);
}

CMyImage::~CMyImage(void)
{
  if (m_pData != NULL)
    free(m_pData);
}

bool CMyImage::ReadBmpHeader(istream& is, int& width, int& height, int& palEntries) const
{
  int i, offset;
  unsigned char ch;
  short int si, bpp;

  // ************************************ Header = 14 byte ****************************

  // ASCII-Text BM = 2 bytes
  is.read((char*)&ch, 1);
  if (ch != 'B')
    return false;
  is.read((char*)&ch, 1);
  if (ch != 'M')
    return false;

  // Size of File in bytes = Header + BitmapInfo + Paletteneintraege + Bitmap
  is.read((char*)&i, 4);
  // Further Use, must be 0
  is.read((char*)&i, 4);
  // Offset bis Bitmap in bytes = Header + BitmapInfo + Paletteneintraege
  is.read((char*)&offset, 4);

  // ************************* Bitmap Information = 44 bytes *************************
  
  // Number of Bytes in Header (wieso 40?)
  is.read((char*)&i, 4);
  if ( i != 40 )
    return false;

  // Breite und Hoehe in pixel
  is.read((char*)&width, 4);
  is.read((char*)&height, 4);
  // Number of Planes, must be 1
  is.read((char*)&si, 2);
  if (si != 1)
    return false;
  
  // bits per pixel, must be 8;
  is.read((char*)&bpp, 2);
  if (bpp != 8)
    return false;

  // Kompression 0 = keine Kompression
  is.read((char*)&i, 4);
  if (i != 0)
    return false;
  // Groesse des Bildes in bytes
  is.read((char*)&i, 4);
  
  // Aufloesung, must be 0
  is.read((char*)&i, 4); 
  is.read((char*)&i, 4); 
  // Number of Color Indizes used und important
  is.read((char*)&i, 4); 
  is.read((char*)&i, 4);

  palEntries = (offset - 54);

  return true;
}

bool CMyImage::ReadBmpFile(const char* fileName)
{
  ifstream is(fileName, ios::binary);
  if (!is)
    return false;

  int width, height, palEntries;
  short int bpp = 8;
  if (!ReadBmpHeader(is, width, height, palEntries))
    return false;

  unsigned char pixel;
  unsigned char* p = m_pData;
  char ch;
  int i;
  for (i = 0; i < palEntries; i++)
    is.read((char*)&ch, 1);

  Resize(width, height);

  // Bytes pro Zeile erhoehen, so dass Anzahl durch 4byte teilbar
  int rest = m_width%4;
  if (rest != 0)
    rest = 4 - rest;

  for (int y = 0; y < m_height; y++ )
  {
    p = m_pData + (m_height - y - 1)*m_width;
    for (int x = 0; x < m_width; x++)
    {
      is.read((char*)&ch, 1);
      pixel = unsigned char(ch);
      *p++ = pixel;
    }

    for (i = 0; i < rest; i++)
    {
      is.read((char*)&ch, 1);
    }
  }
  return true;
}

void CMyImage::WriteBmpHeader(ostream& os, int offset, int sizeOfFile, int sizeOfImage) const
{
  int i;
  short int bbp = 8;
  short int si;
  unsigned char ch;

  // ************************************ Header = 14 byte ****************************
  
  // ASCII-Text BM = 2 bytes
  ch = 0x42;
  os.write((char*)&ch, 1);
  ch = 0x4D;
  os.write((char*)&ch, 1);
 
  // SizeOfFile
  os.write((char*)&sizeOfFile, 4);

  // Further Use, must be 0
  i = 0;
  os.write((char*)&i, 4);

  // Offset bis Bitmap in bytes = Header + BitmapInfo
  os.write((char*)&offset, 4);

  /************************* Bitmap Information = 44 bytes *************************/
  
  // Number of Bytes in Header (wieso 40?)
  i = 40;
  os.write((char*)&i, 4);

  // Breite und Hoehe in pixel
  os.write((char*)&m_width, 4);
  os.write((char*)&m_height, 4);
  
  // Number of Planes, must be 1
  si = 1;
  os.write((char*)&si, 2);
  // bits per pixel;
  os.write((char*)&bbp, 2);
  // Kompression 0 = keine Kompression
  i = 0;
  os.write((char*)&i, 4);
  // Groesse des Bildes in bytes
  os.write((char*)&sizeOfImage, 4);
  // Aufloesung, must be 0
  i = 0;
  os.write((char*)&i, 4); 
  os.write((char*)&i, 4); 
  // Number of Color Indizes used und important
  i = 0; //256;
  os.write((char*)&i, 4); 
  os.write((char*)&i, 4);
}

bool CMyImage::WriteBmpFile(const char* fileName) const
{
  ofstream os(fileName, ios::binary);
  if (!os)
    return false;

  int i, x, y;
  unsigned char pixel = 0, pixeldummy = 0;
  char ch;
  const unsigned char* p = m_pData;

  // Bytes pro Zeile erhoehen, so dass Anzahl durch 4byte teilbar
  int bytesProZeile = m_width; 
  if ((bytesProZeile%4) != 0)
    bytesProZeile = (((bytesProZeile/4)+1)*4);
  int rest = bytesProZeile - m_width;

  // Offset bis Bitmap in bytes = Header + BitmapInfo
  int offset      = 1078;  // = 14 + 44 + 1024
  // Size of File in bytes = Header + BitmapInfo + Bitmap
  int sizeOfFile  = offset + m_height * bytesProZeile;
  // Groesse des Bildes in bytes
  int sizeOfImage = m_height * bytesProZeile;
  WriteBmpHeader(os, offset, sizeOfFile, sizeOfImage);

  // ************************* Paletteneintraege = 1024 bytes *********************
 
  pixeldummy = 0;
  for (int j = 0; j < 256; j++)
  {
    ch = j;
    os.write((char*)&ch, 1);
    os.write((char*)&ch, 1);
    os.write((char*)&ch, 1);
    os.write((char*)&ch, 1);
  };

  // ********* Bitmap = bildHoehe * bytesProZeile *********************************

  pixeldummy = 0;
  for (y = 0; y < m_height; y++)
  {
    p = m_pData + (m_height - y - 1)*m_width;
    for (x = 0; x < m_width; x++)
    {
      pixel = *p++;
      os.write((char*)&(pixel), 1);
    }
    for (i = 0; i < rest; i++)
      os.write((char*)&pixeldummy, 1);
  }

  os.close();

  return true;
}


void CMyImage::Copy(const CMyImage& toCopy)
{
  // todo
}

void CMyImage::Resize(int width, int height)
{
  // todo
}
