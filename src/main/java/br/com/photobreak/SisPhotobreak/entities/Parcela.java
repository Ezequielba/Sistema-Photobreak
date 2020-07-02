package br.com.photobreak.SisPhotobreak.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parcela implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numParcela;
	private Double valorParcela;
	private Double reebolso;
	private Instant dataRecebimento;
	private Double desconto;
	private Double descontoMulta;
	private Instant dataCompetencia;
	private Double valorPendente;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto ;
	
	public Parcela() {
	}

	public Parcela(Long id, String numParcela, Double valorParcela, Double reebolso, Instant dataRecebimento,
			Double desconto, Double descontoMulta, Instant dataCompetencia, Double valorPendente, Cliente cliente,
			Venda venda, Produto produto) {
		super();
		this.id = id;
		this.numParcela = numParcela;
		this.valorParcela = valorParcela;
		this.reebolso = reebolso;
		this.dataRecebimento = dataRecebimento;
		this.desconto = desconto;
		this.descontoMulta = descontoMulta;
		this.dataCompetencia = dataCompetencia;
		this.valorPendente = valorPendente;
		this.cliente = cliente;
		this.venda = venda;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(String numParcela) {
		this.numParcela = numParcela;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Double getReebolso() {
		return reebolso;
	}

	public void setReebolso(Double reebolso) {
		this.reebolso = reebolso;
	}

	public Instant getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Instant dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getDescontoMulta() {
		return descontoMulta;
	}

	public void setDescontoMulta(Double descontoMulta) {
		this.descontoMulta = descontoMulta;
	}

	public Instant getDataCompetencia() {
		return dataCompetencia;
	}

	public void setDataCompetencia(Instant dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}

	public Double getValorPendente() {
		return valorPendente;
	}

	public void setValorPendente(Double valorPendente) {
		this.valorPendente = valorPendente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public Venda getVenda() {
		return venda;
	}

	public Produto getProduto() {
		return produto;
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
		Parcela other = (Parcela) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
