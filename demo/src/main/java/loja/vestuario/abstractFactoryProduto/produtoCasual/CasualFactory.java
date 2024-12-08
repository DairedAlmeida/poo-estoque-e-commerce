package loja.vestuario.abstractFactoryProduto.produtoCasual;

import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.abstractFactoryProduto.ProdutoFactory;

public class CasualFactory implements ProdutoFactory {

	public Produto criarRoupa(int id, String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String alturaCintura, String tipoFechamento) {
		return new RoupaCasual(id, nome, material, escalaConforto, estilo, temEstampa, alturaCintura, tipoFechamento);
	}

	public Produto criarCalca(int id, String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String alturaCintura, String tipoFechamento) {
		return new CalcaCasual(id, nome, material, escalaConforto, estilo, temEstampa, alturaCintura, tipoFechamento);
	}

	public Produto criarCalcado(int id, String nome, String material, String escalaConforto, String estilo,
			boolean temEstampa, String tipoFechamento, String alturaCano) {
		return new CalcadoCasual(id, nome, material, escalaConforto, estilo, temEstampa, tipoFechamento, alturaCano);
	}
}
