package loja.vestuario.abstractFactoryProduto.produtoEsportivo;

public class RoupaEsportiva extends ProdutoEsportivo {

	private String antibacteriana;
	private String levezaFlexibilidade;

	public RoupaEsportiva(int id, String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, String antibacteriana,
			String levezaFlexibilidade) {
		super(id, nome, material, escalaConforto, escalaResistencia, escalaElasticidade, tecnologia);
		this.antibacteriana = antibacteriana;
		this.levezaFlexibilidade = levezaFlexibilidade;
	}

	public String getAntibacteriana() {
		return antibacteriana;
	}

	public void setAntibacteriana(String antibacteriana) {
		this.antibacteriana = antibacteriana;
	}

	public String getLevezaFlexibilidade() {
		return levezaFlexibilidade;
	}

	public void setLevezaFlexibilidade(String levezaFlexibilidade) {
		this.levezaFlexibilidade = levezaFlexibilidade;
	}

	public String descricao() {
		return "RoupaEsportiva [antibacteriana=" + antibacteriana + ", levezaFlexibilidade=" + levezaFlexibilidade
				+ ", descricaoProdutoEsportivo()=" + descricaoProdutoEsportivo() + "]";
	}
}