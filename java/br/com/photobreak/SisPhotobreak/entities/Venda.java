package br.com.photobreak.SisPhotobreak.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomecli;
	private String nomeprod;
	private String dataVenda;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@OneToMany(mappedBy = "venda")
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Venda() {
	}
	
	public Venda(Long id, String nomecli, String nomeprod, String dataVenda, Cliente cliente, Produto produto) {
		super();
		this.id = id;
		this.nomecli = nomecli;
		this.nomeprod = nomeprod;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
		this.produto = produto;
	}
	
	public Venda(Long id, String nomecli, String nomeprod, String dataVenda) {
		super();
		this.id = id;
		this.nomecli = nomecli;
		this.nomeprod = nomeprod;
		this.dataVenda = dataVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}


	public Cliente getCliente() {
		return cliente;
	}
	

	public Produto getProduto() {
		return produto;
	}
	
	public String getNomecli() {
		return nomecli;
	}

	public void setNomecli(String nomecli) {
		this.nomecli = nomecli;
	}

	public String getNomeprod() {
		return nomeprod;
	}

	public void setNomeprod(String nomeprod) {
		this.nomeprod = nomeprod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
