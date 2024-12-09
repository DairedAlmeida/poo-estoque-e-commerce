package loja.vestuario.item;
import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcadoCasual;
import loja.vestuario.abstractFactoryProduto.produtoCasual.ProdutoCasual;
import loja.vestuario.abstractFactoryProduto.produtoCasual.RoupaCasual;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.CalcaEsportiva;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.CalcadoEsportiva;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.ProdutoEsportivo;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.RoupaEsportiva;
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

    public StateItemEstoque getState() {
        return state;
    }

    
    public String getStateDescricao() {
        return state.descricao();
    }

	public Estoque getEstoque() {
		return estoque;
	}

    public String toString() {
        Produto produto = this.getProduto();
        String tipoProduto = "";

        if (produto instanceof ProdutoCasual) {
            tipoProduto = "Casual";
        } else if (produto instanceof ProdutoEsportivo) {
            tipoProduto = "Esportivo";
        }

        String tipoItem = "";
        if (produto instanceof RoupaCasual || produto instanceof RoupaEsportiva) {
            tipoItem = "Roupa";
        } else if (produto instanceof CalcaCasual || produto instanceof CalcaEsportiva) {
            tipoItem = "Calça";
        } else if (produto instanceof CalcadoCasual || produto instanceof CalcadoEsportiva) {
            tipoItem = "Calçado";
        }

        return produto.getId() + " - " + produto.getNome() + " (" + tipoProduto + " - " + tipoItem + ")";
    }
}