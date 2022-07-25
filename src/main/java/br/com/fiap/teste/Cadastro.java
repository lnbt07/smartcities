package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.ContratoAluguel;
import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.entity.TipoEstabelecimento;

public class Cadastro {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();

		// setei o ID como "null" pois estava dando erro na hora de armazenar ele,
		// estava sendo informado que já havia um id igual no banco
		TipoEstabelecimento tipo = new TipoEstabelecimento(null, "petshop", null);

		Cliente cliente1 = new Cliente(0, "Thiago", null);
		Cliente cliente2 = new Cliente(0, "Leandro", null);

		// contrato aluguel não ta gerando ID automatico, tem que informar manualmente
		ContratoAluguel contrato = new ContratoAluguel(1, 2000, new GregorianCalendar(2015, Calendar.JANUARY, 1), null);

		List<Cliente> listaCliente = new ArrayList<>();
		listaCliente.add(cliente1);
		listaCliente.add(cliente2);

		// setei ids diferentes para cada um dos estabelecimentos pois estava dando erro
		// de ID duplicado, e não era possível utilizar o null pois também estava dando
		// erro
		Estabelecimento est1 = new Estabelecimento(0, "Fiap Pet", listaCliente, contrato, tipo);
		Estabelecimento est2 = new Estabelecimento(1, "Poyatos dog", listaCliente, null, tipo);

		contrato.setEstabelecimento(est1);

		em.persist(est1);
		em.persist(est2);

		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
	}

}
