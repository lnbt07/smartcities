package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id //sempre importar os JAVAX
	@SequenceGenerator(name="produto", sequenceName="sq_tb_produto", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto")
	@Column(name="cd_produto")
	private int id;
	
	@Column(name="nm_produto", nullable=false, length=100)
	private String nome;
	
	@Column(name="vl_preco")
	private double preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_data_validade")
	private Calendar dataValidade;
	
	//enum vira números no padrão, então o primiero termo é 0, o segundo é 1, etc
	@Enumerated(EnumType.STRING) //aqui troca para o proprio nome, o proprio termo
	private Estado estado;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
	@Formula("vl_preco*0.9")
	private double precoDesconto;
	
	
}
