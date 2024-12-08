package loja.vestuario.abstractFactoryProduto;
public interface ProdutoFactory {

	public abstract Produto criarRoupa();
	public abstract Produto criarCalca();
	public abstract Produto criarCalcado();

}
