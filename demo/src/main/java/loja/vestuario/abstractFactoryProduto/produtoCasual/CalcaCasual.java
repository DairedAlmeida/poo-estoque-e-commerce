package loja.vestuario.abstractFactoryProduto.produtoCasual;
import loja.vestuario.abstractFactoryProduto.Produto;

public class CalcaCasual extends Produto implements ProdutoCasual {

	private String estilo;

	private String material;

	private int escalaConforto;

	private boolean prega;

	public String getEstilo() {
		return null;
	}

	public String getMaterial() {
		return null;
	}

	public int getEscalaConforto() {
		return 0;
	}

	public boolean isPrega() {
		return false;
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
