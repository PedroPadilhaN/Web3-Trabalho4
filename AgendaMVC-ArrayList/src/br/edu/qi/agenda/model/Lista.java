package br.edu.qi.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	private static List<Contato> lista;
	
	// Cria uma INT�NCIA �NICA da Lista (Padr�o de Projetos: Singleton)
	public static List<Contato> getInstance() {
		//Se ainda N�O existir a inst�ncia, cria uma
		if (lista == null) {
			lista = new ArrayList();
		}
		
		// Se j� existir, s� retorna a instancia
		return lista;
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
