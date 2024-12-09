package loja.vestuario.abstractFactoryProduto.produtoEsportivo;

import loja.vestuario.abstractFactoryProduto.Produto;
//import loja.vestuario.abstractFactoryProduto.ProdutoFactory;
//public class EsportivoFactory implements ProdutoFactory {
public class EsportivoFactory {
	public Produto criarRoupa(String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, String antibacteriana,
			String levezaFlexibilidade) {
		return new RoupaEsportiva(nome, material, escalaConforto, escalaResistencia,
				escalaElasticidade, tecnologia, antibacteriana, levezaFlexibilidade);
	}

	public Produto criarCalca(String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, String tecidoRespiravel,
			String ajusteFlexivel) {
		return new CalcaEsportiva(nome, material, escalaConforto, escalaResistencia,
				escalaElasticidade, tecnologia, tecidoRespiravel, ajusteFlexivel);
	}

	public Produto criarCalcado(String nome, String material, String escalaConforto,
			int escalaResistencia, int escalaElasticidade, String tecnologia, boolean solaAntiderrapante,
			boolean amortecimento, boolean suporteExtra) {
		return new CalcadoEsportiva(nome, material, escalaConforto, escalaResistencia,
				escalaElasticidade, tecnologia, solaAntiderrapante, amortecimento, suporteExtra);
	}
}
