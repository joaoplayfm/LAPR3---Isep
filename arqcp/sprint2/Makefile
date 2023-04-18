main:  change_sensor.o sens_humd_atm.o sens_humd_solo.o sens_pluvio.o sens_velc_vento.o sens_dir_vento.o sens_temp.o asm.o File_reader.o  main.o
	gcc  change_sensor.o sens_humd_atm.o sens_humd_solo.o sens_pluvio.o sens_velc_vento.o sens_dir_vento.o sens_temp.o asm.o File_reader.o  main.o -o main

change_sensor.o: change_sensor.c
	gcc -g -Wall -c change_sensor.c -o change_sensor.o

sens_humd_atm.o: sens_humd_atm.s 
	gcc -g -Wall -c sens_humd_atm.s -o sens_humd_atm.o

sens_humd_solo.o: sens_humd_solo.s 
	gcc -g -Wall -c sens_humd_solo.s -o sens_humd_solo.o

sens_pluvio.o: sens_pluvio.s
	gcc -g -Wall -c sens_pluvio.s -o sens_pluvio.o

sens_velc_vento.o: sens_velc_vento.s
	gcc -g -Wall -c sens_velc_vento.s -o sens_velc_vento.o
	
sens_dir_vento.o: sens_dir_vento.s
	gcc -g -Wall -c sens_dir_vento.s -o sens_dir_vento.o

sens_temp.o: sens_temp.s
	gcc -g -Wall -c sens_temp.s -o sens_temp.o

daily_matrix.o: daily_matrix.c
	gcc -g -Wall -c daily_matrix.c -o daily_matrix.o

File_reader.o: File_reader.c
	gcc -g -Wall -c File_reader.c -o File_reader.o

asm.o: asm.s
	gcc -g -Wall -c asm.s -o asm.o

main.o: main.c
	gcc -g -Wall -c main.c -o main.o

clean:
	rm -f *.o main

run: main
	./main
