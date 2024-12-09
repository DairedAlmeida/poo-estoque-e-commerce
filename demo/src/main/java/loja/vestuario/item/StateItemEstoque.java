package loja.vestuario.item;

public abstract class StateItemEstoque {

    protected ItemEstoque itemEstoque;

    public void setItemEstoque(ItemEstoque itemEstoque) {
        this.itemEstoque = itemEstoque;
    }

    public abstract void remover(int quantidade);
    public abstract void adicionar(int quantidade);
    public abstract void changeState();
	public abstract String descricao();
}
