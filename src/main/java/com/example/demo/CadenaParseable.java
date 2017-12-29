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
		String aux = new String();
		List <String> listaNumeros = new ArrayList<>();
			
		
		for (int i = 0; i<cadena.length(); i++) {			
			
			//comienza secuencia con signo
			if(cadena.charAt(i)== '-'||cadena.charAt(i)== '+'){
				if(i<cadena.length()-1)
					if(esParseable(String.valueOf(cadena.charAt(i+1)))) {
						enteroEncontrado = true;
						aux+=String.valueOf(cadena.charAt(i));		
						
						
					}
					else{						
						enteroEncontrado=false;
						aux= "";
					}				
			}
			//comienza secuencia sin signo
			else if (esParseable(String.valueOf(cadena.charAt(i)))) { 					
					aux+=String.valueOf(cadena.charAt(i));	
					enteroEncontrado=true;
			}
			
			//finaliza secuencia
			if(i<cadena.length()-1)
			if (enteroEncontrado&&!esParseable(String.valueOf(cadena.charAt(i+1)))) {
				listaNumeros.add(aux);
				aux="";
				enteroEncontrado = false;
			}			
			
			//caso numero al final de una cadena
			if (enteroEncontrado && i == cadena.length()-1) {
				enteroEncontrado=false;
				listaNumeros.add(aux);
				aux= "";
			}	
					
		}
		
		return listaNumeros;	
	
	}

public static List<String> buscarSecuencias(String cadena) {
	
	boolean enteroEncontrado = false;
	String aux = new String();
	List <String> listaNumeros = new ArrayList<>();
	

	for (int i = 0; i<cadena.length(); i++) {			
		
		//comienza secuencia
		if(esParseable(String.valueOf(cadena.charAt(i)))) {
			enteroEncontrado = true;
			aux += String.valueOf(cadena.charAt(i));					
			
		}
		
		//fin de secuencia
		else if (enteroEncontrado) {
			
			enteroEncontrado=false;
			listaNumeros.add(aux);
			aux= "";
			
			
		}
		
		//secuencia al final de la cadena
		if (enteroEncontrado && i == cadena.length()-1) {
			System.out.println(aux);
			enteroEncontrado=false;
			listaNumeros.add(aux);
			aux= "";
			
		}		
		
	}

return listaNumeros;

}
	
	
}
