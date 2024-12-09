package loja.vestuario.abstractFactoryProduto.produtoCasual;

import loja.vestuario.abstractFactoryProduto.Produto;
//import loja.vestuario.abstractFactoryProduto.ProdutoFactory;
//public class CasualFactory implements ProdutoFactory {
public class CasualFactory {
	public Produto criarRoupa(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String alturaCintura, String tipoFechamento) {
		return new RoupaCasual(nome, material, escalaConforto, estilo, temEstampa, alturaCintura, tipoFechamento);
	}

	public Produto criarCalca(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String alturaCintura, String tipoFechamento) {
		return new CalcaCasual(nome, material, escalaConforto, estilo, temEstampa, alturaCintura, tipoFechamento);
	}

	public Produto criarCalcado(String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String tipoFechamento, String alturaCano) {
		return new CalcadoCasual(nome, material, escalaConforto, estilo, temEstampa, tipoFechamento, alturaCano);
	}
}
