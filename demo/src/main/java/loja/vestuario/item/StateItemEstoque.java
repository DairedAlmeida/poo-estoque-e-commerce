package loja.vestuario.item;
import java.io.Serializable;

public abstract class StateItemEstoque  implements Serializable {

    protected ItemEstoque itemEstoque;

    public void setItemEstoque(ItemEstoque itemEstoque) {
        this.itemEstoque = itemEstoque;
    }

    public abstract void remover(int quantidade);
    public abstract void adicionar(int quantidade);
    public abstract void changeState();
	public abstract String descricao();
}
