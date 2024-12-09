package loja.vestuario.item;
import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.pessoa.Cliente;

public class ItemPedido extends Item {
	private Cliente cliente;

	public ItemPedido(Produto produto, int quantidade, Cliente cliente) {
		super(produto, quantidade);
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String descrever() {
		return "ItemPedido [cliente=" + cliente + ", descreverItem()=" + descreverItem() + "]";
	}
}
