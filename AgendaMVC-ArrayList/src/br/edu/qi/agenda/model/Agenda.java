package br.edu.qi.agenda.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.qi.agenda.view.Tela;

public class Agenda {
	// Atributos
	List<Contato> lista = new ArrayList();
	
	//Metodos
	public void iniciarAgenda() {
		// Cria o objeto da classe Tela
		Tela tela = new Tela();
		
		// Monta o Menu
		String menu = ":: Agenda de Contatos ::\n\n" +
				"1. Cadastrar\n" +
				"2. Buscar\n" +
				"3. Editar\n" +
				"4. Excluir\n\n";
		
		// Mantem o Menu ativo
		boolean isAtivo = true;
		
		
		// Loop Principal do Sistema
		while (isAtivo) {
			String opcao =  tela.informar(menu,"Informe uma das opções", -1);
			
			switch (opcao) {
			case "1":
				//cadastrar
				cadastrarContato(tela);
				break;
			
			case "2":
				//buscar
				buscarContato(tela);
				break;
				
			case "3":
				//editar
				editarContato(tela);
				break;
				
			case "4":
				//excluir
				excluirContato(tela);
				break;
				
			default:
				int sair = tela.confirmar("Deseja sair?", "Encerrar Sistema", 2);
				
				// Sim == 0 | Não == 1
				if (sair == 0) {
					isAtivo = false;
					tela.mostrar("Encerrando o Sistema...", "Encerrar Sistema", 1);
				}
			}  //fecha o switch
		}	//fecha o while		
	} //fecha o metodo iniciarAgenda()
	
	private void cadastrarContato(Tela tela) {
		
		// usuario informa os dados de cadastro
		String nome = tela.informar("Informe o nome", "Nome", 1);
		String email = tela.informar("Informe o E-mail", "E-mail", 1);
		String fone = tela.informar("Informe o Telefone", "Fone", 1);
		
		//Cria o objeto da classe Contato
		Contato contato = new Contato(nome, email, fone);
		
		// Adiciona o Contato na Lista de Contatos da Agenda
		Lista.getInstance().add(contato);
		
		

		
		// Exemplos de uso de ArrayList
		/*Contato contato = new Contato(
				tela.informar("Informe o nome", "Nome", 1),
				tela.informar("Informe o E-mail", "E-mail", 1),
				tela.informar("Informe o Telefone", "Fone", 1)
				);*/
		
		// Adiciona o Contato (preenchido) na Lista de Contatos da Agenda
		/*List<Contato> lista = new ArrayList();
		
		System.out.println(lista.size());
		
		lista.add(contato);
		System.out.println(lista.size());
		System.out.println(lista);*/
		
		/*List<Integer> lista = new ArrayList();
		
		System.out.println(lista.size());
		
		lista.add(5);
		lista.add(3);
		System.out.println(lista.size());
		System.out.println(lista);
		
		lista.add(9);
		lista.add(7);
		System.out.println(lista.size());
		System.out.println(lista);
		
		//lista[0] = 8; // Não pode manipular como um array comun
		lista.set(0, 8);
		System.out.println(lista.size());
		System.out.println(lista);
		
		System.out.println(lista.get(2));*/
	} // Fecha o metodo cadastrarContato()
	
	private void buscarContato(Tela tela) {
		// Tamanho da lista (quantidade de registros)
		int numeroRegistros = Lista.getInstance().size();
		
		if (numeroRegistros > 0) {
			String listaContatos = "";
			
			// Percorre a Lista de Contatos
			for(int i = 0; i < numeroRegistros; i++){
				listaContatos += 
						"ID: " + (i +1) +
						 "\nNome: " + Lista.getInstance().get(i).getNome() +
						 "\nE-mail: " + Lista.getInstance().get(i).getEmail() +
						 "\nFone: " + Lista.getInstance().get(i).getFone() +
						 "\n\n";
			}
			
			//Mostra o resultado da busca
			tela.mostrar(listaContatos, "Contatos", -1);
			
		} else {
			tela.mostrar("Nenhum contato registrado", "Contatos", 1);
		}
	}
	
	private void editarContato (Tela tela) {
		// Mostra os registros de contato
		buscarContato(tela);
		
		// Verifica se tem algum registro de contato
		if(Lista.getInstance().size() < 1) {
			return; // Volta ao menu
		}
		
		// Usuario informa o ID para Editar
		int id = 0; //escopo global
		
		try {
			// Tenta converter para inteiro
			id = Integer.parseInt(tela.informar("Informe o ID para Editar", "Editar Contato", 1));
			
		} catch(Exception e) {
			tela.mostrar("Informe um ID numérico", "ID Invalido", 2);
			return;
		}
		
		// Usuario informa os novos dados
		String novoNome = tela.informar("Informe o novo nome", "Nome", 1);
		String novoEmail = tela.informar("Informe o novo E-mail", "E-mail", 1);
		String novoFone = tela.informar("Informe o novo Telefone", "Fone", 1);
		
		//Verifica se os campos foram  preenchidos
		//if(nome.equals("")) { // é o mesmo que: if (nome == "") {
		if(!novoNome.equals("")) {
			Lista.getInstance().get(id -1).setNome(novoNome);
		}
		
		if(!novoEmail.equals("")) {
			Lista.getInstance().get(id -1).setEmail(novoEmail);
		}
		
		if(!novoFone.equals("")) {
			Lista.getInstance().get(id -1).setFone(novoFone);
			
		}
			
		tela.mostrar("Contato editado com sucesso!", "Editar Contato", 1);
	}
	
	public void excluirContato (Tela tela) {
		// Mostra os registros de contato
			buscarContato(tela);
			
		// Verifica se tem algum registro de contato
			if(Lista.getInstance().size() < 1) {
					return; // Volta ao menu
				}
			
			// Usuario informa o ID para Editar
			int id = 0; 
			
			try {
				// Tenta converter para inteiro
				id = Integer.parseInt(tela.informar("Informe o ID para Excluir", "Excluir Contato", 1));
				
			} catch(Exception e) {
				tela.mostrar("Informe um ID numérico", "ID Invalido", 2);
				return;
			}
			
			// Verifica se o ID informado é maior que os registros
			if(id > Lista.getInstance().size()) {
				tela.mostrar("ID informado é invalido", "Excluir contato", 0);
				return;
			}
			
			// Confirma a exclusao
			int confirma = tela.confirmar(
					"Deseja excluir o contato?" + Lista.getInstance().get(id -1).getNome() +"?",
					"Excluir Contato",
					0
					);
			
			if (confirma == 0) {
				Lista.getInstance().remove(id -1);
				tela.mostrar("Contato excluido", "Excluir Contato", 1);
				
			}
	}
}
