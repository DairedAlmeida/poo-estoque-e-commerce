package loja.vestuario.loja;

import loja.vestuario.item.ItemEstoque;
import loja.vestuario.pessoa.Administrador;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual;
import loja.vestuario.abstractFactoryProduto.Produto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EstoqueTest {

    private Estoque estoque;
    private Administrador admin1, admin2;

    @Before
    public void setUp() {
        estoque = Estoque.getInstancia();
        admin1 = new Administrador("Pedro", "000000001", "pedro@gmail.com", 3);
        admin2 = new Administrador("Paula", "000000002", "paula@gmail.com", 4);
    }

    @After
    public void tearDown() {
        estoque.getListaItemEstoque().clear();
    }

    @Test
    public void testAdicionarItemEstoque() {
        Produto produto = new CalcaCasual("Calça Jeans", "Denim", "Alta", "Casual", false, "Média", "Zíper");
        ItemEstoque itemEstoque = new ItemEstoque(produto, 5, estoque);

        estoque.adicionarItemEstoque(itemEstoque);

        ArrayList<ItemEstoque> itens = estoque.getListaItemEstoque();
        assertEquals(1, itens.size());
        assertTrue(itens.contains(itemEstoque));
    }

    @Test
    public void testRemoverItemEstoque() {
        Produto produto = new CalcaCasual("Calça Sarja", "Algodão", "Média", "Casual", false, "Alta", "Botão");
        ItemEstoque itemEstoque = new ItemEstoque(produto, 3, estoque);

        estoque.adicionarItemEstoque(itemEstoque);
        assertEquals(1, estoque.getListaItemEstoque().size());

        estoque.removerItemEstoque(itemEstoque);
        assertEquals(0, estoque.getListaItemEstoque().size());
        assertFalse(estoque.getListaItemEstoque().contains(itemEstoque));
    }

    @Test
    public void testExibirItensEstoque() {
        Produto produto1 = new CalcaCasual("Calça Chino", "Sarja", "Média", "Casual", false, "Alta", "Botão");
        Produto produto2 = new CalcaCasual("Calça Social", "Lã", "Alta", "Formal", false, "Alta", "Gancho");

        ItemEstoque item1 = new ItemEstoque(produto1, 10, estoque);
        ItemEstoque item2 = new ItemEstoque(produto2, 5, estoque);

        estoque.adicionarItemEstoque(item1);
        estoque.adicionarItemEstoque(item2);

        assertEquals(2, estoque.getListaItemEstoque().size());
    }

    @Test
    public void testNotificarAdministradorItemEsgotado() {
        Produto produto = new CalcaCasual("Calça Slim", "Denim", "Baixa", "Casual", false, "Média", "Zíper");
        ItemEstoque itemEstoque = new ItemEstoque(produto, 0, estoque);

        estoque.subscribe(admin1);
        estoque.subscribe(admin2);

        itemEstoque.notifyEsgotadoItemEstoque();

        // Muitas mensagens de Esgotado

    }


}
