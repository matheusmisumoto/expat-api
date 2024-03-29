package br.com.expat.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import br.com.expat.model.Cidade;

public class MediaDTO {
	@ManyToOne(fetch = FetchType.EAGER)
	private Cidade codCidade;

	private Double almoco;
	private Double aluguel;
	private Double cestabasica;
	private Double onibus;

	public MediaDTO(Cidade codCidade, Double almoco, Double aluguel, Double cestabasica, Double onibus) {
		super();
		this.codCidade = (codCidade);
		this.almoco = (almoco);
		this.aluguel = (aluguel);
		this.cestabasica = (cestabasica);
		this.onibus = (onibus);
	}

	public Cidade getCidade() {
		return codCidade;
	}

	public void setCidade(Cidade codCidade) {
		this.codCidade = codCidade;
	}

	public double getAlmoco() {
		return almoco == null ? 0 : almoco;
	}

	public void setAlmoco(double almoco) {
		this.almoco = almoco;
	}

	public double getAluguel() {
		return aluguel == null ? 0 : aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}

	public double getCestabasica() {
		return cestabasica == null ? 0 : cestabasica;
	}

	public void setCestabasica(double cestabasica) {
		this.cestabasica = cestabasica;
	}

	public double getOnibus() {
		return onibus == null ? 0 : onibus;
	}

	public void setOnibus(double onibus) {
		this.onibus = onibus;
	}

}
