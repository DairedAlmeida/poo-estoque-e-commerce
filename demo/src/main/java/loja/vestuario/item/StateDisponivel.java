package loja.vestuario.item;
import java.util.ArrayList;
import java.util.concurrent.Flow.Subscriber;

import loja.vestuario.pessoa.Administrador;

public class StateDisponivel extends StateItemEstoque{


    public StateDisponivel() {
        
    }

    // Método para remover a quantidade do estoque
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
            // Caso ocorra erro, imprime o erro e re-lança para o frontend tratar a exceção
            System.out.println("Erro: " + e.getMessage());
            throw e; // Re-lançando a exceção para ser tratada no frontend
        }
    }

    // Método para adicionar a quantidade ao estoque
    public void adicionar(int quantidadeAdicionar) {
        itemEstoque.setQuantidade(itemEstoque.getQuantidade() + quantidadeAdicionar);
        System.out.println("Quantidade adicionada ao estoque.");
    }

    // Método para mudar o estado para Esgotado
    public void changeState() {
        System.out.println("Mudando o estado para Esgotado.");
        itemEstoque.setState(new StateEsgotado()); // Transição para o estado de esgotado
        itemEstoque.notifyEsgotadoItemEstoque();
    }

    // Descrição do estado
    public String descricao() {
        return "Disponível";
    }
}