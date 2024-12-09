package loja.vestuario.abstractFactoryProduto.produtoCasual;

public class RoupaCasual extends ProdutoCasual {
	private String tipoManga;
	private String gola;

	public RoupaCasual(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String tipoManga, String gola) {
		super(nome, material, escalaConforto, estilo, temEstampa);
		this.tipoManga = tipoManga;
		this.gola = gola;
	}

	public String getTipoManga() {
		return tipoManga;
	}

	public void setTipoManga(String tipoManga) {
		this.tipoManga = tipoManga;
	}

	public String getGola() {
		return gola;
	}

	public void setGola(String gola) {
		this.gola = gola;
	}

	public String descricao() {
		return "RoupaCasual [tipoManga=" + tipoManga + ", gola=" + gola + ", descricaoProdutoCasual()="
				+ descricaoProdutoCasual() + "]";
	}

	
}
