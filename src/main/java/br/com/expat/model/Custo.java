package br.com.expat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tb_custo")
@Entity
public class Custo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_analise", length = 20)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cidade codCidade;

	@Column(name = "vl_almoco")
	private double almoco;
	
	@Column(name = "vl_aluguel")
	private double aluguel;

	@Column(name = "vl_cestabasica")
	private double cestabasica;

	@Column(name = "vl_onibus")
	private double onibus;

	public Custo() {	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cidade getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Cidade codCidade) {
		this.codCidade = codCidade;
	}

	public double getAlmoco() {
		return almoco;
	}

	public void setAlmoco(double almoco) {
		this.almoco = almoco;
	}

	public double getAluguel() {
		return aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}

	public double getCestabasica() {
		return cestabasica;
	}

	public void setCestabasica(double cestabasica) {
		this.cestabasica = cestabasica;
	}

	public double getOnibus() {
		return onibus;
	}

	public void setOnibus(double onibus) {
		this.onibus = onibus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Custo other = (Custo) obj;
		if (codCidade != other.codCidade)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Custo [id=" + id + ", codCidade=" + codCidade + ", almoco=" + almoco
				+ ", aluguel=" + aluguel + ", cestabasica=" + cestabasica + ", onibus=" + onibus + "]";
	}

	

}
