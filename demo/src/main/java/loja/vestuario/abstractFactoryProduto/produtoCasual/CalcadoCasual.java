package loja.vestuario.abstractFactoryProduto.produtoCasual;

public class CalcadoCasual extends ProdutoCasual {

	private String tipoFechamento;
	private String alturaCano;

	public CalcadoCasual(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String tipoFechamento, String alturaCano) {
		super(nome, material, escalaConforto, estilo, temEstampa);
		this.tipoFechamento = tipoFechamento;
		this.alturaCano = alturaCano;
	}

	public String getTipoFechamento() {
		return tipoFechamento;
	}

	public void setTipoFechamento(String tipoFechamento) {
		this.tipoFechamento = tipoFechamento;
	}

	public String getAlturaCano() {
		return alturaCano;
	}

	public void setAlturaCano(String alturaCano) {
		this.alturaCano = alturaCano;
	}

	public String descricao() {
		return "CalcadoCasual [tipoFechamento=" + tipoFechamento + ", alturaCano=" + alturaCano
				+ ", descricaoProdutoCasual()=" + descricaoProdutoCasual() + "]";
	}	
}