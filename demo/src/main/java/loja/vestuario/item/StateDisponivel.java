package loja.vestuario.item;

public class StateDisponivel extends StateItemEstoque {


    public StateDisponivel() {
        
    }

    public void remover(int quantidadeRemover) {
        try {
            if (quantidadeRemover <= 0) {
                throw new IllegalArgumentException("A quantidade a ser removida deve ser maior que zero.");
            }
            
            if (quantidadeRemover <= itemEstoque.getQuantidade()) {
                itemEstoque.setQuantidade(itemEstoque.getQuantidade() - quantidadeRemover);
                System.out.println("Quantidade removida do estoque.");
                
                if (itemEstoque.getQuantidade() == 0) {
                    this.changeState();
                }
            } else {
                throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void adicionar(int quantidadeAdicionar) {
        itemEstoque.setQuantidade(itemEstoque.getQuantidade() + quantidadeAdicionar);
        System.out.println("Quantidade adicionada ao estoque.");
    }

    public void changeState() {
        System.out.println("Mudando o estado para Esgotado.");
        itemEstoque.setState(new StateEsgotado());
        itemEstoque.notifyEsgotadoItemEstoque();
    }

    public String descricao() {
        return "Disponível";
    }
}