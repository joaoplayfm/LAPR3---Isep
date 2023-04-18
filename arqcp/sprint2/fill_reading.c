#include <stdio.h>
#include <stdlib.h>
#include "asm.h"
#include "sensores.h"
#define ERRORTIMES 3
char temp_atual = 15;
char vent_vel_atual = 15;
short vent_dir_atual = 260;
char humd_solo_atual = 25;
char humd_atm_atual = 35;
char pluvio_atual = 3;
int count1=0;



void add_values(long p, int k , int m) {



if (sensors[k].readings[m] >= sensors[k].min_limit && sensors[k].readings[m]  <= sensors[k].max_limit)
    {
   

      printf(" \033[0;32m"); // Set the text to the color green
      printf("Valor do sensor %d = %hhd \n\n",k+1, sensors[k].readings[m]);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count1 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Error:Out of bounds!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count1++;
      }
      else
      {
        p = 0;
        count1 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }




}



    
    
 

void fill_reading()
{
    int k = 0;
    int x = 0;
    int y = 0;


    for(int i=0;i<num_sensors;i++){
      if(sensors[i].sensor_type==1){
        x=i;
        break;
      }
    }


    for(int i=0;i<num_sensors;i++){
      if(sensors[i].sensor_type==6){
        y=i;
        break;
      }
    }




    while (k < num_sensors)
    {
      
        long p;
        char o;
        char u;
        /*--------------------------------------------------------*/
        if (sensors[k].sensor_type == 1)
        {
            printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
            printf("\nSensor of temperature\n\n");
            for (int m = 0; m < sensors[k].readings_size; m++)
            {
                p = pcg32_random_r();
                o = (char)p;

                u = 50;
                o = o / u;
               
                temp_atual = sens_temp(temp_atual, o);
                sensors[k].readings[m] = temp_atual;
                
                
               add_values(p,k,m);
                 
            }
          
            
        }
        if (sensors[k].sensor_type == 2)
        {
              printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
            printf("\nSensor of wind velocity\n\n");
            for (int m = 0; m <sensors[k].readings_size; m++)
            {
                p = pcg32_random_r();
                o = (char)p;
                vent_vel_atual = sens_velc_vento(vent_vel_atual, o);
                sensors[k].readings[m] = vent_vel_atual;
                 add_values(p,k,m);
            }
            
        }
        if (sensors[k].sensor_type == 3)
        {
             printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
            printf("\nSensor of wind Direction\n\n");
            for (int m = 0; m < sensors[k].readings_size; m++)
            {
                p = pcg32_random_r();
                short r = (short)p;
                short t = 250;
                r = r / t;
                vent_dir_atual = sens_dir_vento(vent_dir_atual, r);
                sensors[k].readings[m] = vent_dir_atual;
                add_values(p,k,m);
            }
            
        }
        if (sensors[k].sensor_type == 4)
        {
           printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
        printf("\nSensor of atmospheric humidity\n\n");
            for (int m = 0; m < sensors[k].readings_size; m++)
            {
               
                p = pcg32_random_r();
                o = (char)p;
                u = 2;
                char aa = (char)sensors[y].readings[m];
              
                o = o / u;
                humd_atm_atual = sens_humd_atm(humd_atm_atual, aa, o);
                sensors[k].readings[m] = humd_atm_atual;
                add_values(p,k,m);
                
            }
           
        }
        if (sensors[k].sensor_type == 5)
        {
            printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
            printf("\nSensor of soil moisture\n\n");
            for (int m = 0; m < sensors[k].readings_size; m++)
            {
                p = pcg32_random_r();
                o = (char)p;
                u = 2;
                char aa = (char)sensors[y].readings[m];
                o = o / u;
                humd_solo_atual = sens_humd_solo(humd_solo_atual, aa, o);
                sensors[k].readings[m] = humd_solo_atual;
                add_values(p,k,m);
            }
           
        }
        if (sensors[k].sensor_type == 6)
        {
             printf("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
            printf("\nSensor of rainfall\n\n");
            for (int m = 0; m < sensors[k].readings_size; m++)
            {
                 
      
                p = pcg32_random_r();
                o = (char)p;
                u = 2;
                char aaa = (char)sensors[x].readings[m];
                o = o / u;
                pluvio_atual = sens_pluvio(pluvio_atual, aaa, o);
                sensors[k].readings[m] = pluvio_atual;
                add_values(p,k,m);
                
            }
            
        }
       
        k++;
         
    }
}