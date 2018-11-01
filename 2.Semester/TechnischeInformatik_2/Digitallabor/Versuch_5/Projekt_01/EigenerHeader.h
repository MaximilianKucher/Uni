#ifndef __Eigener_Header__

#define __Eigener_Header__

// Port 0 Input Register
#define P0_IN                  (*((volatile unsigned short*) 0xFF80))
#define P0_IN_P0               (1)
#define P0_IN_P1               (1<<1)
#define P0_IN_P10              (1<<10)
#define P0_IN_P11              (1<<11)
#define P0_IN_P12              (1<<12)
#define P0_IN_P13              (1<<13)
#define P0_IN_P14              (1<<14)
#define P0_IN_P15              (1<<15)
#define P0_IN_P2               (1<<2)
#define P0_IN_P3               (1<<3)
#define P0_IN_P4               (1<<4)
#define P0_IN_P5               (1<<5)
#define P0_IN_P6               (1<<6)
#define P0_IN_P7               (1<<7)
#define P0_IN_P8               (1<<8)
#define P0_IN_P9               (1<<9)


// Port 0 Input/Output Control Register
#define P0_IOCR00              (*((volatile unsigned short*) 0xE800))
#define P0_IOCR01              (*((volatile unsigned short*) 0xE802))
#define P0_IOCR02              (*((volatile unsigned short*) 0xE804))
#define P0_IOCR03              (*((volatile unsigned short*) 0xE806))
#define P0_IOCR04              (*((volatile unsigned short*) 0xE808))
#define P0_IOCR05              (*((volatile unsigned short*) 0xE80A))
#define P0_IOCR06              (*((volatile unsigned short*) 0xE80C))
#define P0_IOCR07              (*((volatile unsigned short*) 0xE80E))


// Port 0 Output Register
#define P0_OUT                  (*((volatile unsigned short*) 0xFFA2))
#define P0_OUT_P0               (1)
#define P0_OUT_P1               (1<<1)
#define P0_OUT_P10              (1<<10)
#define P0_OUT_P11              (1<<11)
#define P0_OUT_P12              (1<<12)
#define P0_OUT_P13              (1<<13)
#define P0_OUT_P14              (1<<14)
#define P0_OUT_P15              (1<<15)
#define P0_OUT_P2               (1<<2)
#define P0_OUT_P3               (1<<3)
#define P0_OUT_P4               (1<<4)
#define P0_OUT_P5               (1<<5)
#define P0_OUT_P6               (1<<6)
#define P0_OUT_P7               (1<<7)
#define P0_OUT_P8               (1<<8)
#define P0_OUT_P9               (1<<9)

void portinit();

#endif