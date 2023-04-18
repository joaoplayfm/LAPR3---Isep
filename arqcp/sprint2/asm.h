

#ifndef ASM_H
#define ASM_H
#include <stdint.h>

typedef struct
{
 unsigned short id;  //offset 0
 unsigned char sensor_type; // offset 2
 //bit em branco
 unsigned short max_limit; // limites do sensor- offset 4
 unsigned short min_limit; // offset 6
unsigned long frequency; // frequency de leituras (em segundos)- offset 8
unsigned long readings_size; // tamanho do array de leituras - offset 16
 unsigned short *readings; // array de leituras diárias //offset 24
 // adicionar o que acharem conveniente
 } Sensor;

extern Sensor *sensors;
extern int num_sensors;


uint64_t readRANDnumber();
uint32_t pcg32_random_r();
void read_sensor_config_from_file(Sensor **sensors, int *num_sensors, const char *filename);


void add_values(long p, int k , int m);


int add_sensor(unsigned short id, unsigned char sensor_type, unsigned short max_limit, unsigned short min_limit, unsigned long frequency   );
void rem_sensor( unsigned short id);
void change_freq( unsigned short id, unsigned long frequency);

void fill_reading();
void free_sensor_config();
void print_struct();



extern uint64_t state;
extern uint64_t inc;
#endif 
