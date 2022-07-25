package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PJ") // vai colocar no name_tipo(DTYPE) que o nome, para esse filho, é PJ, se não
							// colocar, vai colocar o nome da classe como padrão
public class PessoaJuridica extends Pessoa {

	@Column(name = "nr_cnpj")
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
