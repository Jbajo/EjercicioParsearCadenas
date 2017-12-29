package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioParsearCadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioParsearCadenasApplication.class, args);

		String a1 = "cadena de 10 100 120 124 ";
		String a2 = "cadena algo más larga";
		String a3 = "cadena mucho pero que mucho más larga";
		String a4 = "pepe juan manolo ricardo";
		String a5 = "2+3432-4234rt,,,,3";
		
		int suma = 0;
		for (String aux : CadenaParseable.buscarSecuenciasConSigno(a5)) {
			System.out.println(aux);
			suma+= Integer.parseInt(aux);
					
		}
		System.out.println(suma);
		suma = 0;
		for  (String aux : CadenaParseable.buscarSecuencias(a1)) {
			System.out.println(aux);
			suma+= Integer.parseInt(aux);
					
		}
		System.out.println(suma);
	}
}
