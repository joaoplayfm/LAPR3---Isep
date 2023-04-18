#include <stdio.h>
#include <stdint.h>
#include "asm.h"
#include "sensores.h"
#include "read_rnd.c"
#include "daily_matrix.h"
#include "daily_matrix.c"
#define MAXLIMITETEMP 40
#define MINLIMITETEMP -5
#define MAXLIMITEVENTO 200
#define MINLIMITEVENTO 0
#define MAXLIMITEDIR 360
#define MINLIMITEDIR 0
#define MAXLIMITEHUMIDADESOLO 100
#define MINLIMITEHUMIDADESOLO 0
#define MAXLIMITEHUMIDADEATM 100
#define MINLIMITEHUMIDADEATM 0
#define MAXLIMITEPLUV 110
#define MINLIMITEPLUV 0
#define ERRORTIMES 3
#define VALORES 3
#define SENSORS 6

uint64_t state = 0; // unsigned long long 8 bytes
uint64_t inc = 0;   // unsigned long long 8 bytes
char temp_atual = 29;
char temp_arr[10];
char* ptr_temp_atual = temp_arr;
char vent_vel_atual = 15;
char vent_vel_arr[10];
char* ptr_vel_atual = vent_vel_arr;
short vent_dir_atual = 260;
short vent_dir_arr[10];
short* ptr_dir_atual = vent_dir_arr;
char humd_solo_atual = 25;
char humd_solo_arr[10];
char* ptr_humd_solo = humd_solo_arr;
char humd_atm_atual = 35;
char humd_atm_arr[10];
char* ptr_humd_atm = humd_atm_arr;
char pluvio_atual = 60;
char pluvio_arr[10];
char* ptr_pluvio_atual = pluvio_arr;
int count1 = 0;
int count2 = 0;
int count3 = 0;
int count4 = 0;
int count5 = 0;
int count6 = 0;


int main()
{
  state = readRANDnumber();
  inc = readRANDnumber();

  printf("Random Generated Numbers: \n");
  printf(" ------------------------- \n");
  printf("|                         |\n");
  int i;
  for (i = 0; i < 32; i++)
  {

    printf("|       %8x          |\n", pcg32_random_r());
  }
  printf("|                         |\n");
  printf(" ------------------------- \n");
  int k = 0;
  while (k < 5)
  {

    /*--------------------------------------------------------*/

    sleep(1);
    long p = pcg32_random_r();
    char o = (char)p;
    char u = 50;
    o = o / u;
    temp_atual = sens_temp(temp_atual, o);
     *ptr_temp_atual = temp_atual;
    ptr_temp_atual++;
    if (temp_atual > MINLIMITETEMP && temp_atual < MAXLIMITETEMP)
    {
   

      printf(" \033[0;32m"); // Set the text to the color green
      printf("Temperatura atual= %hhd \n\n", temp_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count1 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Temperatura atual não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count1++;
      }
      else
      {
        p = 0;
        count1 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor1 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }

    /*--------------------------------------------------------*/

    p = pcg32_random_r();
    o = (char)p;
    vent_vel_atual = sens_velc_vento(vent_vel_atual, o);
    *ptr_vel_atual = vent_vel_atual;
    ptr_vel_atual++;
    if (vent_vel_atual > MINLIMITEVENTO && vent_vel_atual < MAXLIMITEVENTO)
    {
    
      printf(" \033[0;32m"); // Set the text to the color green
      printf("Velocidade do vento atual= %hhd \n\n", vent_vel_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count2 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Velocidade do vento atual não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count2++;
      }
      else
      {
        p = 0;
        count2 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor 2 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }

    /*--------------------------------------------------------*/

    p = pcg32_random_r();
    short r = (short)p;
    short t = 250;
    r = r / t;
    vent_dir_atual = sens_dir_vento(vent_dir_atual, r);
     *ptr_dir_atual = vent_dir_atual;
    ptr_dir_atual++;
    if (vent_dir_atual > MINLIMITEDIR && vent_dir_atual < MAXLIMITEDIR)
    {
   
      printf(" \033[0;32m"); // Set the text to the color green
      printf("Direção do vento atual= %hd \n\n", vent_dir_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count3 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Direção do vento não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count3++;
      }
      else
      {
        p = 0;
        count3 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor 3 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }
    /*--------------------------------------------------------*/

    p = pcg32_random_r();
    o = (char)p;
    u = 2;
    o = o / u;
    pluvio_atual = sens_pluvio(pluvio_atual, temp_atual, o);
    *ptr_pluvio_atual = pluvio_atual;
    ptr_pluvio_atual++;
    if (pluvio_atual > MINLIMITEPLUV && pluvio_atual < MAXLIMITEPLUV)
    {
    
      printf(" \033[0;32m"); // Set the text to the color green
      printf("Pluviovidade atual= %hhd \n\n", pluvio_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count4 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Pluviosidade atual não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count4++;
      }
      else
      {
        p = 0;
        count4 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor 4 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }

    /*--------------------------------------------------------*/

    p = pcg32_random_r();
    o = (char)p;
    u = 2;
    o = o / u;
    humd_atm_atual = sens_humd_atm(humd_atm_atual, pluvio_atual, o);
      *ptr_humd_atm = humd_atm_atual;
    ptr_humd_atm++;
    if (humd_atm_atual > MINLIMITEHUMIDADEATM && humd_atm_atual < MAXLIMITEHUMIDADEATM)
   
    {
   
      printf(" \033[0;32m"); // Set the text to the color green
      printf("Humidade atmosférica atual= %hhd \n\n", humd_atm_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count5 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Humidade atmosférica não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count5++;
      }
      else
      {
        p = 0;
        count5 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor 5 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }
    /*--------------------------------------------------------*/

    p = pcg32_random_r();
    o = (char)p;
    u = 2;
    o = o / u;
    humd_solo_atual = sens_humd_solo(humd_solo_atual, pluvio_atual, o);
 *ptr_humd_solo = humd_solo_atual;
    ptr_humd_solo++;
    if (humd_solo_atual > MINLIMITEHUMIDADESOLO && humd_solo_atual < MAXLIMITEHUMIDADESOLO)
    {
   
      printf(" \033[0;32m"); // Set the text to the color green
      printf("Humidade do solo atual= %hhd \n\n", humd_solo_atual);
      printf("\033[0m"); // Resets the text to default color
    }
    else
    {
      if (count6 < ERRORTIMES)
      {
        printf("\033[0;31m"); // Set the text to the color red
        printf("Erro: Humidade do solo não está dentro dos limites!\n\n");
        printf("\033[0m"); // Resets the text to default color
        count6++;
      }
      else
      {
        p = 0;
        count6 = 0;
        printf("\033[0;36m"); // Set the text to the color red
        printf("\n\nSensor 6 Reset --> Value: %ld\n\n", p);
        printf("\033[0m"); // Resets the text to default color
      }
    }
    k++;
   
    printf("\n--------------------------------------------------------------------\n");
  }

      /*--------------------------------------------------------*/
   
    short matrix[VALORES][SENSORS];

       matrix[0][0] = valorMax(temp_arr, k);
        matrix[0][1] = valorMin(temp_arr, k);
         matrix[0][2] = valorMedia(temp_arr, k);
       
        matrix[1][0] = valorMax(vent_vel_arr, k);
         matrix[1][1] = valorMin(vent_vel_arr, k);
          matrix[1][2] = valorMedia(vent_vel_arr, k);
      
        matrix[2][0] = valorMaxS(vent_dir_arr, k);
         matrix[2][1] = valorMinS(vent_dir_arr, k);
          matrix[2][2] = valorMediaS(vent_dir_arr, k);
       
        matrix[3][0] = valorMax(humd_solo_arr, k);
         matrix[3][1] = valorMin(humd_solo_arr, k);
          matrix[3][2] = valorMedia(humd_solo_arr, k);
       
        matrix[4][0] = valorMax(humd_atm_arr, k);
         matrix[4][1] = valorMin(humd_atm_arr, k);
          matrix[4][2] = valorMedia(humd_atm_arr, k);
        
        matrix[5][0] = valorMax(pluvio_arr, k);
         matrix[5][1] = valorMin(pluvio_arr, k);
          matrix[5][2] = valorMedia(pluvio_arr, k);
       

       printf("Matrix com valor:\n              |maximo|       |minimo|        |média|\n");
          for (int i=0; i < SENSORS; i++) {
            for (int j=0; j <VALORES; j++) {

                printf("\t\t%d ", matrix[i][j]);
            }
            printf("\n");
        }

     
      
  
    return 0;
  }