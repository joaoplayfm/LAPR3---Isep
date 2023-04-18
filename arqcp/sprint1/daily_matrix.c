#define VALORES 3
#define SENSORS 6

short valorMax(char *vet, int count){
short valorMax = *vet;

	for(int i = 0; i < count; i++){
        if(valorMax < *vet){
            valorMax = *vet;
        }
        vet++;
	}
	return valorMax;
}

short valorMin(char *vet, int count){
short valorMin = *vet;

    for(int i = 0; i < count; i++){
            if(valorMin > *vet){
                valorMin = *vet;
            }
            vet++;
    	}
    	return valorMin;
}

short valorMedia(char *vet, int count){
short soma = 0;
short med = 0;
    for(int i = 0; i < count; i++){
            soma += *vet;
            vet++;
    	}
    	med = soma/count;
    	return med;
}

short valorMaxS(short *vet, int count){
short valorMax = *vet;

	for(int i = 0; i < count; i++){
        if(valorMax < *vet){
            valorMax = *vet;
        }
        vet++;
	}
	return valorMax;
}

short valorMinS(short *vet, int count){
short valorMin = *vet;

    for(int i = 0; i < count; i++){
            if(valorMin > *vet){
                valorMin = *vet;
            }
            vet++;
    	}
    	return valorMin;
}

short valorMediaS(short *vet, int count){
short soma = 0;
short med = 0;
    for(int i = 0; i < count; i++){
            soma += *vet;
            vet++;
    	}
    	med = soma/count;
    	return med;
}


  

