#ifndef ASM_H
#define ASM_H
uint64_t readRANDnumber();
uint32_t pcg32_random_r();

extern uint64_t state;
extern uint64_t inc;
#endif 
