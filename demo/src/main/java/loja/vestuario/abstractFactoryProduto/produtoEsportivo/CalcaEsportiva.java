package loja.vestuario.abstractFactoryProduto.produtoEsportivo;
public class CalcaEsportiva extends ProdutoEsportivo {

	private String tecidoRespiravel;
	private String ajusteFlexivel;

	public CalcaEsportiva(String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, String tecidoRespiravel,
			String ajusteFlexivel) {
		super(nome, material, escalaConforto, escalaResistencia, escalaElasticidade, tecnologia);
		this.tecidoRespiravel = tecidoRespiravel;
		this.ajusteFlexivel = ajusteFlexivel;
	}

	public String getTecidoRespiravel() {
		return tecidoRespiravel;
	}

	public void setTecidoRespiravel(String tecidoRespiravel) {
		this.tecidoRespiravel = tecidoRespiravel;
	}

	public String getAjusteFlexivel() {
		return ajusteFlexivel;
	}

	public void setAjusteFlexivel(String ajusteFlexivel) {
		this.ajusteFlexivel = ajusteFlexivel;
	}

	public String descricao() {
		return "CalcaEsportiva [tecidoRespiravel=" + tecidoRespiravel + ", ajusteFlexivel=" + ajusteFlexivel
				+ ", descricaoProdutoEsportivo()=" + descricaoProdutoEsportivo() + "]";
	}
}
