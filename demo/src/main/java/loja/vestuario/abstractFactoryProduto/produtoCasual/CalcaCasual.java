package loja.vestuario.abstractFactoryProduto.produtoCasual;

public class CalcaCasual extends ProdutoCasual {

	private String alturaCintura;
	private String tipoFechamento;
	
	public CalcaCasual(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String alturaCintura, String tipoFechamento) {
		super(nome, material, escalaConforto, estilo, temEstampa);
		this.alturaCintura = alturaCintura;
		this.tipoFechamento = tipoFechamento;
		this.categoria = "Casual";
	}

	public String getAlturaCintura() {
		return alturaCintura;
	}

	public void setAlturaCintura(String alturaCintura) {
		this.alturaCintura = alturaCintura;
	}

	public String getTipoFechamento() {
		return tipoFechamento;
	}

	public void setTipoFechamento(String tipoFechamento) {
		this.tipoFechamento = tipoFechamento;
	}

	public String descricao() {
		return "CalcaCasual [alturaCintura=" + alturaCintura + ", tipoFechamento=" + tipoFechamento
				+ ", descricaoProdutoCasual()=" + descricaoProdutoCasual() + "]";
	}
}
