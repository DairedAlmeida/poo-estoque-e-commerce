package loja.vestuario.abstractFactoryProduto.produtoEsportivo;
import loja.vestuario.abstractFactoryProduto.Produto;

public abstract class ProdutoEsportivo extends Produto{

	protected int escalaResistencia;
	protected int escalaElasticidade;
	protected String tecnologia;
	
	public ProdutoEsportivo(int id, String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia) {
		super(id, nome, material, escalaConforto);
		this.escalaResistencia = escalaResistencia;
		this.escalaElasticidade = escalaElasticidade;
		this.tecnologia = tecnologia;
		this.categoria = "Esportivo";
	}

	public int getEscalaResistencia() {
		return escalaResistencia;
	}

	public void setEscalaResistencia(int escalaResistencia) {
		this.escalaResistencia = escalaResistencia;
	}

	public int getEscalaElasticidade() {
		return escalaElasticidade;
	}

	public void setEscalaElasticidade(int escalaElasticidade) {
		this.escalaElasticidade = escalaElasticidade;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String descricaoProdutoEsportivo() {
		return "ProdutoEsportivo [escalaResistencia=" + escalaResistencia + ", escalaElasticidade=" + escalaElasticidade
				+ ", tecnologia=" + tecnologia + ", descricaoProduto()=" + descricaoProduto() + "]";
	}	
}