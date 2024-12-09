package loja.vestuario.item;
import java.util.ArrayList;
import loja.vestuario.pessoa.Administrador;

public class StateDisponivel extends StateItemEstoque implements Subscriber {

    private ArrayList<Administrador> observers;

    public StateDisponivel() {
        this.observers = new ArrayList<>();
    }

    public void remover(int quantidadeRemover) {
        if (quantidadeRemover <= itemEstoque.getQuantidade()) {
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - quantidadeRemover);
            System.out.println("Quantidade removida do estoque.");
            if (itemEstoque.getQuantidade() == 0) {
                this.changeState();
            }
        } else {
            System.out.println("Quantidade insuficiente no estoque.");
        }
    }

    public void adicionar(int quantidadeAdicionar) {
        itemEstoque.setQuantidade(itemEstoque.getQuantidade() + quantidadeAdicionar);
        System.out.println("Quantidade adicionada ao estoque.");
    }

    public void changeState() {
        notifyObservers(); // Notifica os administradores antes de mudar o estado
        System.out.println("Mudando o estado para Esgotado.");
        itemEstoque.setState(new StateEsgotado()); // Transição para o estado de esgotado
    }

    public String descricao() {
        return "Disponível";
    }

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