package br.edu.qi.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	private static List<Contato> lista;
	
	// Cria uma INTÂNCIA ÚNICA da Lista (Padrão de Projetos: Singleton)
	public static List<Contato> getInstance() {
		//Se ainda NÃO existir a instância, cria uma
		if (lista == null) {
			lista = new ArrayList();
		}
		
		// Se já existir, só retorna a instancia
		return lista;
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
