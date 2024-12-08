package loja.vestuario.abstractFactoryProduto.produtoCasual;
import loja.vestuario.abstractFactoryProduto.Produto;

public abstract class ProdutoCasual extends Produto{

	private String estilo;
	private boolean temEstampa;
	
	public ProdutoCasual(int id, String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa) {
		super(id, nome, material, escalaConforto);
		this.estilo = estilo;
		this.temEstampa = temEstampa;
		this.categoria = "Casual";
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public boolean isTemEstampa() {
		return temEstampa;
	}

	public void setTemEstampa(boolean temEstampa) {
		this.temEstampa = temEstampa;
	}

	public String descricaoProdutoCasual() {
		return "ProdutoCasual [estilo=" + estilo + ", temEstampa=" + temEstampa + ", descricaoProduto()="
				+ descricaoProduto() + "]";
	}
}
