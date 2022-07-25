package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.PessoaJuridica;

public class TestePessoa {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj("123.123.123/0001-99");
		pj.setNome("FIAP");
		
		em.persist(pj);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
	}

}
