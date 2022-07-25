package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoId implements Serializable{
	
	//nomes tem que estar exatamente iguais nas duas classes
	
	private int usuario;
	
	private int estabelecimento;
	
	public AvaliacaoId() {
		super();
	}

	public AvaliacaoId(int usuario, int estabelecimento) {
		super();
		this.usuario = usuario;
		this.estabelecimento = estabelecimento;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(int estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estabelecimento, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		return estabelecimento == other.estabelecimento && usuario == other.usuario;
	}
	
	
}
