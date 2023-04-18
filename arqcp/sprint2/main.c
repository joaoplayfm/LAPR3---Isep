#include <stdio.h>
#include <stdint.h>
#include "asm.h"
#include "sensores.h"
#include "read_rnd.c"
#include "daily_matrix.h"
#include "daily_matrix.c"
#include <stdlib.h>
#include "fill_reading.c"

#define MAXLIMITETEMP 40
#define MINLIMITETEMP -5
#define MAXLIMITEVENTO 200
#define MINLIMITEVENTO 0
#define MAXLIMITEDIR 360
#define MINLIMITEDIR 0
#define MAXLIMITEHUMIDADEATM 100
#define MINLIMITEHUMIDADEATM 0
#define MAXLIMITEHUMIDADESOLO 100
#define MINLIMITEHUMIDADESOLO 0
#define MAXLIMITEPLUV 110
#define MINLIMITEPLUV 0
#define ERRORTIMES 3
#define VALORES 3
#define SENSORS 6

uint64_t state = 0; // unsigned long long 8 bytes
uint64_t inc = 0;   // unsigned long long 8 bytes


Sensor *sensors;
int num_sensors;


  int main()
{
 
 int opcao;


          printf("|-------------------------------------------|\n");
          printf("|                  LDR LDA                  |\n");
          printf("|-------------------------------------------|\n");

    do {
      int a=0;
  int b=0;
  int c=0;
  int d=0;
  int e=0;
 

        printf("|-------------------------------------------|\n");
        printf("|                   MENU                    |\n");
        printf("|-------------------------------------------|");
        
        printf("\n|   1 - Ler dados                           |");
        printf("\n|   2 - Inserir dados                       |");
        printf("\n|   3 - Remover Sensor                      |");
        printf("\n|   4 - Alterar Frequência do Sensor        |");
        printf("\n|   5 - Gerar numeros randomizados          |");
        printf("\n|   6 - Inserir Sensor                      |");
        printf("\n|   7 - Exportar Matriz Diária              |");
        printf("\n|   8 - Exportar Dados                      |");
        printf("\n|   9 - Consultar Sensores                  |");
        printf("\n|   0 - Sair                                |");
        printf("\n|-------------------------------------------|");

        printf("\nOpcão: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 0:
     
                printf("Encerrando.......\n\n\n");
                sleep(2);
                // Libertar a memória alocada para os sensores
                free_sensor_config();
                return 0;
            case 1:
           // Lê a configuração dos sensores a partir de um arquivo de texto
           printf("\n\n Loading...\n");
              read_sensor_config_from_file(&sensors, &num_sensors, "data.txt");
          
            sleep(2);
            printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;

            case 2:
           
                fill_reading();
               

            
                break;
            case 3:
            print_struct();
           
                printf("\nID of the sensor you wish to remove: \n");
                scanf("%d",&a);
              
               rem_sensor(a);
               printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            case 4:
          print_struct();
           printf("\nID of the sensor you wish to alter: \n");
                        scanf("%d",&a);
             
                  printf("\nNew Frequency of the sensor you wish to change: \n");
                scanf("%d",&b);

                  change_freq(a,b);
                  printf("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;

            case 6:
            
            
            
                printf("\nID of the sensor you wish to add: \n");
                scanf("%d",&a);
                printf("\n Type of sensor you wish to add: \n");
                printf("\n 1- Temperatura");
                printf("\n 2- Velocidade do vento");
                printf("\n 3- Direcção do vento");
                printf("\n 4- Humidade atmosférica");
                printf("\n 5- Humidade do solo");
                printf("\n 6- Pluviosidade\n");
                scanf("%d",&b);
                printf("\nMax Limit of the sensor you wish to add: \n");
                scanf("%d",&c);
                printf("\nMin Limit of the sensor you wish to add: \n");
                scanf("%d",&d);
                printf("\nFrequency of the sensor you wish to add: \n");
                scanf("%d",&e);
                add_sensor(a,b,c,d,e);
                printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
           
             
                       
        
                  
                break;

            case 5:
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
                

                break;
            case 7:
                  printMatrix();
                  writeDailyMatrix();
                  break;
            case 8:
                   writeReadings();
                   printf("Csv created!\n");
                break;
            case 9:
                  print_struct();
                  
                break;
            

        }
        
        
    } while (opcao != 0);


    
  
    return 0;
  }