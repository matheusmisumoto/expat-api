package br.com.expat.model;

public enum TipoUsuario {
	ADMIN(1, "ROLE_ADMIN"), NORMAL(2, "ROLE_NORMAL");

	private Integer cod;
	private String descricao;

	private TipoUsuario(Integer cod, String descricao) {
	 this.cod = cod;
	 this.descricao = descricao;
	 }

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoUsuario toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (TipoUsuario x : TipoUsuario.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
