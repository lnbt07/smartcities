package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
	@Column(name = "id_estabelecimento")
	private Integer id;

	@Column(name = "nm_estabelecimento", length = 50)
	private String nome;

	@OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST)
	private ContratoAluguel contrato;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_tipo_estabelecimento")
	private TipoEstabelecimento tipo;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "id_estabelecimento"), inverseJoinColumns = @JoinColumn(name = "id_cliente"), name = "tb_cliente_estabelecimento")
	private List<Cliente> clientes;

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(Integer id, String nome, List<Cliente> clientes, ContratoAluguel contrato,
			TipoEstabelecimento tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.contrato = contrato;
		this.tipo = tipo;
		this.clientes = clientes;
	}

	public TipoEstabelecimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstabelecimento tipo) {
		this.tipo = tipo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setContrato(ContratoAluguel contrato) {
		this.contrato = contrato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContratoAluguel getContrato() {
		return contrato;
	}

}
