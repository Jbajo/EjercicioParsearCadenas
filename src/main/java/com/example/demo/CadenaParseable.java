package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CadenaParseable {


	public static boolean esParseable(String numeroEnString){
		try {
		int numero = Integer.parseInt(numeroEnString);
		return true;
		} catch (Exception e) {
		return false;
		}
		}
	
	public static List<String> buscarSecuenciasConSigno(String cadena) {
		
		boolean enteroEncontrado = false;
		StringBuilder aux = new StringBuilder("");
		List <String> listaNumeros = new ArrayList<>();
			
		
		for (int i = 0; i<cadena.length(); i++) {			
			
			//comienza secuencia con signo
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
			//comienza secuencia sin signo
			else if (esParseable(String.valueOf(cadena.charAt(i)))) {
				aux.append(String.valueOf(cadena.charAt(i)));	
				enteroEncontrado=true;
			}
			
			//finaliza secuencia
			if(i<cadena.length()-1)
			if (enteroEncontrado&&!esParseable(String.valueOf(cadena.charAt(i+1)))) {
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
				enteroEncontrado = false;
			}			
			
			//caso numero al final de una cadena
			if (enteroEncontrado && i == cadena.length()-1) {
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
			}	
					
		}
		
		return listaNumeros;	
	
	}

	public static List<String> buscarSecuencias(String cadena) {
	
		boolean enteroEncontrado = false;
		StringBuilder aux = new StringBuilder();
		List <String> listaNumeros = new ArrayList<>();
		
	
		for (int i = 0; i<cadena.length(); i++) {			
			
			//comienza secuencia
			if(esParseable(String.valueOf(cadena.charAt(i)))) {
				enteroEncontrado = true;
				aux.append(String.valueOf(cadena.charAt(i)));					
				
			}
			
			//fin de secuencia
			else if (enteroEncontrado) {
				
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
				
				
			}
			
			//secuencia al final de la cadena
			if (enteroEncontrado && i == cadena.length()-1) {
				enteroEncontrado=false;
				listaNumeros.add(aux.toString());
				aux.delete(0, aux.length());
				
			}		
			
		}
	
		return listaNumeros;
	
	}
	
	
}
