package loja.vestuario.item;

public class StateEsgotado extends StateItemEstoque {

    public void remover(int quantidadeemover) {
        throw new IllegalArgumentException("Item não pode ser removido porque está esgotado.");
    }

    public void adicionar(int quantidadeAdicionar) {
        itemEstoque.setQuantidade(itemEstoque.getQuantidade() + quantidadeAdicionar);
		System.out.println("Quantidade adiconada ao do estoque.");
		this.changeState();
    }

    public void changeState() {
        System.out.println("Mudando o estado para Disponível.");
        itemEstoque.setState(new StateDisponivel());
    }

	public String descricao(){
        return "Esgotado";
    }
}