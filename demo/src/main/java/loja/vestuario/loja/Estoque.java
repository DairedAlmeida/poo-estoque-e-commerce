package loja.vestuario.loja;

import java.io.Serializable;
import java.util.ArrayList;
import loja.vestuario.item.ItemEstoque;
import loja.vestuario.pessoa.Administrador;

public class Estoque implements SubscriberAdministador, Serializable {

    private static Estoque instancia;
    private Loja loja;
    private ArrayList<ItemEstoque> listaItemEstoque;
    private ArrayList<Administrador> observers;

    private Estoque() {
        this.listaItemEstoque = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public Loja getLoja() {
		return loja;
	}

	public ArrayList<ItemEstoque> getListaItemEstoque() {
		return listaItemEstoque;
	}

    public void adicionarItemEstoque(ItemEstoque itemEstoque) {
        listaItemEstoque.add(itemEstoque);
        System.out.println("Item adicionado ao estoque: " + itemEstoque);
    }

    public void removerItemEstoque(ItemEstoque itemEstoque) {
        if (listaItemEstoque.contains(itemEstoque)) {
            listaItemEstoque.remove(itemEstoque);
            System.out.println("Item removido do estoque: " + itemEstoque);
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    public void exibirItensEstoque() {
        if (listaItemEstoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Itens no estoque:");
            for (ItemEstoque itemEstoque : listaItemEstoque) {
                System.out.println(itemEstoque);  // Exibe o itemEstoque no formato implementado na classe ItemEstoque
            }
        }
    }

    public boolean contemItemEstoque(ItemEstoque itemEstoque) {
        return listaItemEstoque.contains(itemEstoque);
    }

    public void notifyEsgotadoEstoque(int idProdutoEsgotado, String nomeProdutoEsgotado) {
        this.notifyObservers(idProdutoEsgotado, nomeProdutoEsgotado);
    }

    // Métodos de observer (assinar, cancelar assinatura e notificar)
    public void subscribe(Administrador observer) {
        observers.add(observer); // Adiciona um assinante
        System.out.println("Adm adicionado " + observer.getNome());
    }

    public void unsubscribe(Administrador observer) {
        observers.remove(observer); // Remove um assinante
    }

    public void notifyObservers(int idProdutoEsgotado, String nomeProdutoEsgotado) {
        for (Administrador observer : observers) {
            observer.update("O item " + idProdutoEsgotado + "-" + nomeProdutoEsgotado + " está esgotado."); 
        }
    }
}
