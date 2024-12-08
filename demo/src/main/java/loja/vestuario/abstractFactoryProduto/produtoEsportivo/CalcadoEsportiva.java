package loja.vestuario.abstractFactoryProduto.produtoEsportivo;

public class CalcadoEsportiva extends ProdutoEsportivo {

	private boolean solaAntiderrapante;
	private boolean amortecimento;
	private boolean suporteExtra;
	
	public CalcadoEsportiva(int id, String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, boolean solaAntiderrapante,
			boolean amortecimento, boolean suporteExtra) {
		super(id, nome, material, escalaConforto, escalaResistencia, escalaElasticidade, tecnologia);
		this.solaAntiderrapante = solaAntiderrapante;
		this.amortecimento = amortecimento;
		this.suporteExtra = suporteExtra;
	}

	public boolean isSolaAntiderrapante() {
		return solaAntiderrapante;
	}

	public void setSolaAntiderrapante(boolean solaAntiderrapante) {
		this.solaAntiderrapante = solaAntiderrapante;
	}

	public boolean isAmortecimento() {
		return amortecimento;
	}

	public void setAmortecimento(boolean amortecimento) {
		this.amortecimento = amortecimento;
	}

	public boolean isSuporteExtra() {
		return suporteExtra;
	}

	public void setSuporteExtra(boolean suporteExtra) {
		this.suporteExtra = suporteExtra;
	}

	public String descricao() {
		return "CalcadoEsportiva [solaAntiderrapante=" + solaAntiderrapante + ", amortecimento=" + amortecimento
				+ ", suporteExtra=" + suporteExtra + ", descricaoProdutoEsportivo()=" + descricaoProdutoEsportivo()
				+ "]";
	}
}
