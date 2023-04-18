    #define VALORES 3
    #define Sensores 6
    #include "asm.h"
    #include <stdio.h>
    #include <stdlib.h>
    short matrix[Sensores][VALORES];
    short valorMax(int n){
    short valorMax = sensors[n].readings[0];
    	for(int i = 0; i < sensors[n].readings_size; i++){
            if(valorMax < sensors[n].readings[i]){
                valorMax = sensors[n].readings[i];
            }
    	}
    	return valorMax;
    }
    short valorMin(int n){
    short valorMin = sensors[n].readings[0];
       for(int i = 0; i < sensors[n].readings_size; i++){
                if(valorMin > sensors[n].readings[i]){
                    valorMin = sensors[n].readings[i];
                }
        	}
        	return valorMin;
    }
    short valorMedia(int n){
    short soma = 0;
    short med = 0;
        for(int i = 0; i < sensors[n].readings_size; i++){
                soma += sensors[n].readings[i];
        	}
        	med = soma/sensors[n].readings_size;
        	return med;
    }
    short valorMaxS(int n){
    short valorMax = sensors[n].readings[0];
    	for(int i = 0; i < sensors[n].readings_size; i++){
            if(valorMax < sensors[n].readings[i]){
                valorMax = sensors[n].readings[i];
            }
    	}
    	return valorMax;
    }
    short valorMinS(int n){
    short valorMin = sensors[n].readings[0];
        for(int i = 0; i < sensors[n].readings_size; i++){
                if(valorMin > sensors[n].readings[i]){
                    valorMin = sensors[n].readings[i];
                }
        	}
        	return valorMin;
    }
    short valorMediaS(int n){
    short soma = 0;
    short med = 0;
        for(int i = 0; i < sensors[n].readings_size; i++){
                soma += sensors[n].readings[i];
        }
        med = soma/sensors[n].readings_size;
        return med;
    }

    void printMatrix(){
      for (int i = 0; i < Sensores; i++)
      {
         matrix[i][0] = valorMax(i);
        matrix[i][1] = valorMin(i);
        matrix[i][2] = valorMedia(i);

      }

        printf("Matrix com valor:\n              |maximo|       |minimo|        |média|\n");
            for (int i=0; i < Sensores; i++) {
               for (int j=0; j <VALORES; j++) {

                    printf("\t\t%d ", matrix[i][j]);
            }
            printf("\n");
        }
        }


    void writeDailyMatrix()
{
  FILE *fp;
  fp = fopen("dailyMatrix.csv", "w");
  if (fp == NULL)
  {
    perror("Error opening file");
    return;
  }

  fprintf(fp, "maximo,minimo,média;\n");
  for (int i = 0; i < Sensores; i++)
  {
    for (int j = 0; j < VALORES; j++)
    {
      fprintf(fp, "%d,", matrix[i][j]);
    }
    fprintf(fp, "\n");
  }

  fclose(fp);
}
    void writeReadings (){
        FILE *file = fopen("sensors.csv", "w");

// write the header row
fprintf(file, "id,sensor_type,max_limit,min_limit,frequency,readings_size,readings\n");

// iterate through the sensors array
for (int i = 0; i < num_sensors; i++)
{
  // write the data for the current sensor
  fprintf(file, "%hd,%d,%hd,%hd,%ld,%ld,",
          sensors[i].id, sensors[i].sensor_type,
          sensors[i].max_limit, sensors[i].min_limit,
          sensors[i].frequency, sensors[i].readings_size);

  // write the readings array for the current sensor
  for (int j = 0; j < sensors[i].readings_size; j++)
  {
    fprintf(file, "%hd", sensors[i].readings[j]);
    if (j < sensors[i].readings_size - 1)
    {
      fprintf(file, ",");
    }
  }

  fprintf(file, "\n");
}

// close the file
fclose(file);}



