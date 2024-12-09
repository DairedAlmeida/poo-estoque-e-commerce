package loja.vestuario.item;
import loja.vestuario.abstractFactoryProduto.Produto;

public abstract class Item {
	protected Produto produto;
	protected int quantidade;
	
	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String descreverItem() {
		return "Item [produto=" + produto + ", quantidade=" + quantidade + "]";
	}
}
