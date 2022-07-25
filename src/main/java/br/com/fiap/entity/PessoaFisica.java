package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PF") // vai colocar no name_tipo(DTYPE) que o nome, para esse filho, é PF, se não
							// colocar, vai colocar o nome da classe como padrão
public class PessoaFisica extends Pessoa {

	@Column(name = "nr_cpf")
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
