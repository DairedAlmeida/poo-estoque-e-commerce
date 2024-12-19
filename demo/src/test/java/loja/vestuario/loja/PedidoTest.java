package loja.vestuario.loja;

import loja.vestuario.item.ItemPedido;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual;
import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.pessoa.Cliente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PedidoTest {

    private Pedido pedido;
    private Cliente cliente;

    @Before
    public void setUp() {
        pedido = new Pedido();
        cliente = new Cliente("João Silva", "123.456.789-00", "joao@email.com");
    }

    @After
    public void tearDown() {
        pedido = null;
        cliente = null;
    }

    @Test
    public void testAdicionarItemPedido() {
        Produto calca = new CalcaCasual("Calça Jeans", "Denim", "Alta", "Casual", false, "Média", "Zíper");
        ItemPedido itemPedido = new ItemPedido(calca, 2, cliente);

        pedido.adicionarItemPedido(itemPedido);

        ArrayList<ItemPedido> itens = pedido.getListalistaItemPedido();
        assertEquals(1, itens.size());
        assertTrue(itens.contains(itemPedido));
    }

    

    @Test
    public void testRemoverItemPedido() {
        Produto calca = new CalcaCasual("Calça Sarja", "Algodão", "Média", "Casual", true, "Alta", "Botão");
        ItemPedido itemPedido = new ItemPedido(calca, 1, cliente);

        pedido.adicionarItemPedido(itemPedido);
        assertEquals(1, pedido.getListalistaItemPedido().size());

        pedido.removerItemPedido(itemPedido);

        ArrayList<ItemPedido> itens = pedido.getListalistaItemPedido();
        assertEquals(0, itens.size());
        assertFalse(itens.contains(itemPedido));
    }

    @Test
    public void testDescreverPedido() {
        Produto calca1 = new CalcaCasual("Calça Chino", "Sarja", "Média", "Casual", false, "Alta", "Botão");
        Produto calca2 = new CalcaCasual("Calça Social", "Lã", "Alta", "Formal", false, "Alta", "Gancho");

        ItemPedido item1 = new ItemPedido(calca1, 2, cliente);
        ItemPedido item2 = new ItemPedido(calca2, 1, cliente);

        pedido.adicionarItemPedido(item1);
        pedido.adicionarItemPedido(item2);

        String descricaoEsperada = "Pedido [itens=ItemPedido [cliente=ID: 3 - Nome: João Silva, "+
        "descreverItem()=Item [produto=loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual@7a3d45bd,"+
        " quantidade=2]], ItemPedido [cliente=ID: 3 - Nome: João Silva, descreverItem()=Item"+
        " [produto=loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual@6a1aab78, quantidade=1]]]";

        String descricaoReal = pedido.descreverPedido();   

        assertEquals(descricaoEsperada, descricaoReal);
    }
}
