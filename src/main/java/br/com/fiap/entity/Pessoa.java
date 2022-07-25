package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // estratégia padrão, não é necessário fazer isso, no banco, é
														// gerado uma tabela com todos os IDS dos filhos junto com o
														// pai, e vai botar um DTYPE pra diferenciar quem é a pessoa
														// fisica ou pessoa juridica na pesquisa. Os filhos não podem
														// ter IDs como obrigatorios por causa do problema na hora de
														// preenchimento.
@DiscriminatorColumn(name = "name_tipo") // faz o trabalho da DTYPE, diferenciando se é pessoa fisica ou juridica na
											// hora da consulta, já que fica tudo na mesma tabela
@Table(name = "tb_pessoa")
public class Pessoa {

	@Id
	@SequenceGenerator(name = "pessoa", sequenceName = "sq_pessoa", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
	private int id;

	@Column(length = 50, nullable = false)
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
