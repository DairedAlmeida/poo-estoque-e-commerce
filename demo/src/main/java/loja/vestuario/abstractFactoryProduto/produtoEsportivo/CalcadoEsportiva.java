package loja.vestuario.abstractFactoryProduto.produtoEsportivo;
import loja.vestuario.abstractFactoryProduto.Produto;

public class CalcadoEsportiva extends Produto implements ProdutoEsportivo {

	private String estilo;

	private String material;

	private int escalaResistencia;

	private int escalaElasticidade;

	private String tecnologia;

	public String getEstilo() {
		return null;
	}

	public String getMaterial() {
		return null;
	}

	public int getEscalaResistencia() {
		return 0;
	}

	public boolean getEscalaElasticidade() {
		return false;
	}

	public String getTecnologia() {
		return null;
	}

	public String descricao() {
		return null;
	}


	/**
	 * @see ProdutoEsportivo#getCategoria()
	 */
	public String getCategoria() {
		return null;
	}


	/**
	 * @see ProdutoEsportivo#getEscalaConforto()
	 */
	public int getEscalaConforto() {
		return 0;
	}

}
