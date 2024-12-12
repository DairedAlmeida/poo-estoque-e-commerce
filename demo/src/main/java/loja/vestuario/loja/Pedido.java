package loja.vestuario.loja;
import java.io.Serializable;
import java.util.ArrayList;
import loja.vestuario.item.ItemPedido;

public class Pedido  implements Serializable {
	private ArrayList<ItemPedido> listaItemPedido;
    
	public Pedido() {
        this.listaItemPedido = new ArrayList<>();
    }

    public void adicionarItemPedido(ItemPedido item) {
        listaItemPedido.add(item);
    }

    public void removerItemPedido(ItemPedido item) {
        listaItemPedido.remove(item);
    }

    public ArrayList<ItemPedido> getListalistaItemPedido() {
        return listaItemPedido;
    }

    public String descreverPedido() {
        StringBuilder descricao = new StringBuilder("Pedido [itens=");
        for (ItemPedido item : listaItemPedido) {
            descricao.append(item.descrever()).append(", ");
        }
        if (!listaItemPedido.isEmpty()) {
            descricao.setLength(descricao.length() - 2);
        }
        descricao.append("]");
        return descricao.toString();
    }
}
