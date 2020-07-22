package br.com.photobreak.SisPhotobreak.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String enderecocliente;
	private String enderecoevento;
	private String cidade;
	private String cep;
	private String dataevento;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<Venda> vendas = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Cliente() {
	}
	
	public Cliente(Long id, String nome, String telefone, String email, String enderecocliente, String dataevento) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.enderecocliente = enderecocliente;
		this.dataevento = dataevento;
	}

	public Cliente(Long id, String nome, String telefone, String email, String enderecocliente, String enderecoevento, String cidade, String cep, String dataevento) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.enderecocliente = enderecocliente;
		this.enderecoevento = enderecoevento;
		this.cidade = cidade;
		this.cep = cep;
		this.dataevento = dataevento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecocliente() {
		return enderecocliente;
	}
	
	public String getEnderecoevento() {
		return enderecoevento;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getCep() {
		return cep;
	}

	public void setEnderecocliente(String enderecocliente) {
		this.enderecocliente = enderecocliente;
	}
	
	public void setEnderecoevento(String enderecoevento) {
		this.enderecoevento = enderecoevento;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDataevento() {
		return dataevento;
	}

	public void setDataevento(String dataevento) {
		this.dataevento = dataevento;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
