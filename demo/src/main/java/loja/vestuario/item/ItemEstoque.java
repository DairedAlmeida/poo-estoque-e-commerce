package loja.vestuario.item;
import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.loja.Estoque;

public class ItemEstoque extends Item {

    private Estoque estoque;
    private StateItemEstoque state;

    public ItemEstoque(Produto produto, int quantidade, Estoque estoque) {
        super(produto, quantidade);
        this.estoque = estoque;
        this.state = new StateDisponivel(); 
        this.state.setItemEstoque(this);
    }

    public void setState(StateItemEstoque state) {
        this.state = state;
        this.state.setItemEstoque(this);
    }

    public String getState() {
        return state.descricao();
    }

	public Estoque getEstoque() {
		return estoque;
	}
}