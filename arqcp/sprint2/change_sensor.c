#include <stdio.h>
#include <stdlib.h>
#include "asm.h"



int add_sensor(unsigned short id, unsigned char sensor_type, unsigned short max_limit, unsigned short min_limit, unsigned long frequency){
    for(int i =0; i<num_sensors;i++){
        if(sensors[i].id==id) {
            printf("\n\nID already exists!");
            return 0;
        }
    }
    
        if(sensor_type<1 || sensor_type>6) {
            printf("\n\nType doesn't exists!");
            return 0;
        }
    
    sensors = (Sensor*) realloc(sensors, (num_sensors+1)*sizeof(Sensor));
    num_sensors++;
    sensors[num_sensors-1].id=id;
    sensors[num_sensors-1].sensor_type=sensor_type;
    sensors[num_sensors-1].max_limit=max_limit;
    sensors[num_sensors-1].min_limit=min_limit;
    sensors[num_sensors-1].frequency=frequency;
    unsigned long reading_size= 86400/frequency;
    sensors[num_sensors-1].readings_size=reading_size;
    sensors[num_sensors-1].readings=(unsigned short *) malloc ((reading_size)*sizeof(unsigned short));
    printf("\nSensor sucessfully added!");
    return 1;
}

void rem_sensor( unsigned short id){
    int index=0;
    int a=0;
    for (int i = 0; i < num_sensors; i++)
    {
        if (sensors[i].id==id)
        {
            index=i;
            a++;
            break;
        }
    }
    if (a == 0)
  {

    printf("A sensor with id %hd was not found.\n", id);
    return;
  }
     unsigned short *readings = sensors[index].readings;
    for (int k = index; k < num_sensors-1; k++)
    {
        sensors[k]=sensors[k+1];
    }

  sensors = (Sensor*)realloc(sensors, (num_sensors - 1) * sizeof(Sensor));

  num_sensors--;

  free(readings);
    printf("\nSensor sucessfully removed!");
        
}

void change_freq( unsigned short id, unsigned long frequency){
    int index=0;
    int a=0;
    for (int i = 0; i < num_sensors; i++)
    {
        if (sensors[i].id==id)
        {
            index=i;
            a++;
            break;
        }
    }
     if (a == 0)
  {

    printf("A sensor with id %hd was not found.\n", id);
    return;
  }
    free(sensors[index].readings);
    sensors[index].frequency=frequency;
    unsigned long reading_size= 86400/sensors[index].frequency;
    sensors[index].readings_size=reading_size;
    sensors[index].readings=(unsigned short *) malloc ((reading_size)*sizeof(unsigned short));
    printf("\nSensor sucessfully altered!");
}



