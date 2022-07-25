package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_tipo_estabelecimento")
public class TipoEstabelecimento {

	@Id
	@SequenceGenerator(name = "tipoEstabelecimento", sequenceName = "sq_tb_tipo_estabelecimento", allocationSize = 1)
	@Column(name = "id_tipo_estabelecimento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoEstabelecimento")
	private Integer id;

	@Column(name = "nm_tipo_estabelecimento", length = 50)
	private String nomeTipo;

	@OneToMany(mappedBy = "tipo", cascade = CascadeType.PERSIST)
	private List<Estabelecimento> estabelecimentos;

	public TipoEstabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoEstabelecimento(Integer id, String nomeTipo, List<Estabelecimento> estabelecimentos) {
		super();
		this.id = id;
		this.nomeTipo = nomeTipo;
		this.estabelecimentos = estabelecimentos;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public Integer getId() {
		return id;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

}
