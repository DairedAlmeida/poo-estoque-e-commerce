package loja.vestuario.item;

public abstract class StateItemEstoque {

	protected ItemEstoque itemEstoque;

	protected abstract void remover();
	protected abstract void adicionar();
	protected abstract void changeState();
}
