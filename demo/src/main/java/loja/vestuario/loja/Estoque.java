package loja.vestuario.loja;

import java.util.ArrayList;
import loja.vestuario.item.ItemEstoque;

public class Estoque {

    private static Estoque instancia;  // Instância única do estoque
    private Loja loja;                 // Referência para a loja associada
    private ArrayList<ItemEstoque> listaItemEstoque; // Lista de itens em estoque

    // Construtor privado para garantir o padrão Singleton
    private Estoque() {
        this.listaItemEstoque = new ArrayList<>();  // Inicializa a lista de itens
    }

    // Método para obter a instância única do Estoque
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

	// Método para adicionar um itemEstoque ao estoque
    public void adicionarItemEstoque(ItemEstoque itemEstoque) {
        listaItemEstoque.add(itemEstoque);
        System.out.println("Item adicionado ao estoque: " + itemEstoque);
    }

    // Método para remover um itemEstoque do estoque
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
}
