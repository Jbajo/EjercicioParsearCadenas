package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadenaParseable {

/**
 * Método esParseable 
 * @param numeroEnString número a procesar
 * @return devuelve true o false si el número es parseable a entero
 */
	public static boolean esParseable(String numeroEnString){
		try {
		int numero = Integer.parseInt(numeroEnString);
		return true;
		} catch (Exception e) {
		return false;
		}
		}
	/**
	 * Método buscarSecuenciasSigno busca secuencias de números con o sin signo y las guarda en un ArrayList
	 * @param cadena a procesar
	 * @return ArrayList de números procesados
	 */
	public static List<String> buscarSecuenciasConSigno(String cadena) {
		
		boolean enteroEncontrado = false;
		StringBuilder aux = new StringBuilder("");
		List <String> listaNumeros = new ArrayList<>();
					
		for (int i = 0; i<cadena.length(); i++) {//comienza secuencia con signo			
			if(cadena.charAt(i)== '-'||cadena.charAt(i)== '+'){
				if(i<cadena.length()-1)
					if(esParseable(String.valueOf(cadena.charAt(i+1)))) {
						enteroEncontrado = true;
						aux.append(String.valueOf(cadena.charAt(i)));						
					}
					else{						
						enteroEncontrado=false;
						aux.delete(0, aux.length());
					}				
			}			
			else if (esParseable(String.valueOf(cadena.charAt(i)))) {//comienza secuencia sin signo
				aux.append(String.valueOf(cadena.charAt(i)));	
				enteroEncontrado=true;
			}//finaliza secuencia			
			if(i<cadena.length()-1)
			if (enteroEncontrado&&!esParseable(String.valueOf(cadena.charAt(i+1)))) {
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
				enteroEncontrado = false;
			}						
			if (enteroEncontrado && i == cadena.length()-1) {//caso numero al final de una cadena
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
			}					
		}		
		return listaNumeros;	
	}
/**
 * Método buscarSecuencias busca secuencias de números sin signo y las guarda en un ArrayList
 * @param cadena a procesar
 * @return ArrayList de números procesados
 */
	public static List<String> buscarSecuencias(String cadena) {
	
		boolean enteroEncontrado = false;
		StringBuilder aux = new StringBuilder();
		List <String> listaNumeros = new ArrayList<>();
		
	
		for (int i = 0; i<cadena.length(); i++) {			
			if(esParseable(String.valueOf(cadena.charAt(i)))) {//comienza secuencia
				enteroEncontrado = true;
				aux.append(String.valueOf(cadena.charAt(i)));					
			}
			else if (enteroEncontrado) {//fin de secuencia
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
			}
			if (enteroEncontrado && i == cadena.length()-1) {//secuencia al final de la cadena
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());				
			}		
		}
		return listaNumeros;
	
	}
}
