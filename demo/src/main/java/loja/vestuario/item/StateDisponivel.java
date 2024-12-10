package loja.vestuario.item;
import java.util.ArrayList;
import loja.vestuario.pessoa.Administrador;

public class StateDisponivel extends StateItemEstoque implements Subscriber {

    private ArrayList<Administrador> observers;

    public StateDisponivel() {
        this.observers = new ArrayList<>();
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
        notifyObservers(); // Notifica os administradores antes de mudar o estado
        System.out.println("Mudando o estado para Esgotado.");
        itemEstoque.setState(new StateEsgotado()); // Transição para o estado de esgotado
    }

    // Descrição do estado
    public String descricao() {
        return "Disponível";
    }

    // Métodos de observer (assinar, cancelar assinatura e notificar)
    public void subscribe(Administrador observer) {
        observers.add(observer); // Adiciona um assinante
    }

    public void unsubscribe(Administrador observer) {
        observers.remove(observer); // Remove um assinante
    }

    public void notifyObservers() {
        for (Administrador observer : observers) {
            observer.update("O item " + itemEstoque.getProduto().getNome() + " está esgotado."); 
        }
    }
}