package loja.vestuario.abstractFactoryProduto.produtoCasual;
import loja.vestuario.abstractFactoryProduto.Produto;

public class CalcadoCasual extends Produto implements ProdutoCasual {

	private String estilo;

	private String material;

	private int escalaConforto;

	public String getEstilo() {
		return null;
	}

	public String getMaterial() {
		return null;
	}

	public int getEscalaConforto() {
		return 0;
	}

	public String descricao() {
		return null;
	}


	/**
	 * @see ProdutoCasual#getCategoria()
	 */
	public String getCategoria() {
		return null;
	}

}
