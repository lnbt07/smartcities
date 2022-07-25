package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class TesteBusca {

	public static void main(String[] args) {
		// criar fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartcities");
		// criar gerenciador de entidades, ele quem cria as tabelas no banco, etc etc
		EntityManager em = fabrica.createEntityManager();

		
		//teste de atualização
		Cliente cliente = new Cliente(1, "Thiago");
		System.out.println(cliente.getId()+" = "+cliente.getNome());
		cliente.setNome("Henrique");
		
		em.merge(cliente);//linha para atualizar a classe dentro do Entity Manager, pra ele 'trocar' a informação da classe no banco
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		//teste de remoção
		cliente = em.find(Cliente.class, 1);
		try {
			em.remove(cliente); //linha para adicionar a classe dentro do Entity Manager, pra ele 'conhecer' a classe no banco
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		

		
		em.close();
		fabrica.close();
	}

}
