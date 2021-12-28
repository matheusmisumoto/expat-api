package br.com.expat.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import br.com.expat.model.Cidade;

public class MediaDTO {
	@ManyToOne(fetch = FetchType.EAGER)
	private Cidade codCidade;

	private double almoco;
	private double aluguel;
	private double cestabasica;
	private double onibus;

	public MediaDTO(Cidade codCidade, double almoco, double aluguel, double cestabasica, double onibus) {
		super();
		this.codCidade = codCidade;
		this.almoco = almoco;
		this.aluguel = aluguel;
		this.cestabasica = cestabasica;
		this.onibus = onibus;
	}

	public Cidade getCidade() {
		return codCidade;
	}

	public void setCidade(Cidade codCidade) {
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

}
