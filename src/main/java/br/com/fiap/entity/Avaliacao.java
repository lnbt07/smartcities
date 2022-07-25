package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliacao")
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable{
	
	@Id
	@JoinColumn(name="id_usuario")
	@ManyToOne(optional=false)
	private Usuario usuario;
	
	@Id
	@JoinColumn(name="id_estabelecimento")
	@ManyToOne(optional=false)
	private Estabelecimento1 estabelecimento;
	
	@Column(name="vl_nota")
	private int nota;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estabelecimento1 getEstabelecimento1() {
		return estabelecimento;
	}

	public void setEstabelecimento1(Estabelecimento1 estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
