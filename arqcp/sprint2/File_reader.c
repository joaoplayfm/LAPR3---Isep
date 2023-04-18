#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include "asm.h"

// Função para ler a configuração dos sensores a partir de um arquivo de texto
void read_sensor_config_from_file(Sensor **sensors, int *num_sensors, const char *filename) {
  // Abrir o arquivo de configuração para leitura
  FILE *fp = fopen(filename, "r");
  if (fp == NULL) {
    fprintf(stderr, "Error opening file: %s\n", filename);
    exit(1);
  }

  // Lê a quantidade de tipos de sensores do arquivo
  fscanf(fp, "%d", num_sensors);

  // Alocar o array dinâmico de sensores
  *sensors = malloc(sizeof(Sensor) * (*num_sensors));

  // Lê os dados de cada tipo de sensor do arquivo
  for (int i = 0; i < *num_sensors; i++) {
    fscanf(fp, "%hu %hhu %hu %hu %lu", &((*sensors)[i].id), &((*sensors)[i].sensor_type), &((*sensors)[i].max_limit), &((*sensors)[i].min_limit), &((*sensors)[i].frequency));

    // Calcular o tamanho do array de leituras com base na frequência de leituras
    (*sensors)[i].readings_size = 86400 / (*sensors)[i].frequency; // 86400 é o número de segundos em um dia

    // Alocar o array de leituras
    (*sensors)[i].readings = malloc(sizeof(unsigned short) * (*sensors)[i].readings_size);
  }

  // Fechar o arquivo
  fclose(fp);
}

void free_sensor_config() {

  for (int i = 0; i <num_sensors; i++) {
    free(sensors[i].readings);

}
free(sensors);
// Set the sensors and num_sensors pointers to NULL
  sensors = NULL;
  num_sensors = 0;
}

void print_struct(){

   // Imprime os dados de cada sensor
  for (int i = 0; i <num_sensors; i++) {
    printf("Sensor %d:\n", i+1);
    printf("  ID: %hu\n", sensors[i].id);
    printf("  Sensor type: %hhu\n", sensors[i].sensor_type);
    printf("  Max limit: %hu\n", sensors[i].max_limit);
    printf("  Min limit: %hu\n", sensors[i].min_limit);
    printf("  Frequency: %lu\n",sensors[i].frequency);
    printf("  Readings size: %lu\n", sensors[i].readings_size);

      /*--------------------------------------------------------*/

  } 
}