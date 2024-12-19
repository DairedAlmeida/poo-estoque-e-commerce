package loja.vestuario.loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import loja.vestuario.pessoa.Administrador;
import loja.vestuario.pessoa.Cliente;
import loja.vestuario.pessoa.Pessoa;

public class LojaTest {

    @Test
    public void testAdicionarAdministrador() {
        Loja.instancia = null;
        File arquivo = new File("dados/loja.dat");
        if (arquivo.exists()) {
            arquivo.delete();
        }

        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Administrador administrador = new Administrador("João", "000000001", "joao@gmail.com", 1);

        loja.adicionarAdministrador(administrador);

        assertTrue(loja.getListaAdministradores().contains(administrador));
        assertEquals(1, loja.getListaAdministradores().size());
    }

    @Test
    public void testRemoverAdministrador() {
        Loja.instancia = null;
        File arquivo = new File("dados/loja.dat");
        if (arquivo.exists()) {
            arquivo.delete();
        }

        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Administrador administrador = new Administrador("Carlos", "000000002", "carlos@gmail.com", 2);

        loja.adicionarAdministrador(administrador);
        loja.removerAdministrador(administrador);

        assertFalse(loja.getListaAdministradores().contains(administrador));
        assertEquals(0, loja.getListaAdministradores().size());
    }

    @Test
    public void testAdicionarCliente() {
        Loja.instancia = null;
        File arquivo = new File("dados/loja.dat");
        if (arquivo.exists()) {
            arquivo.delete();
        }

        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Cliente cliente = new Cliente("Maria", "000000003", "maria@gmail.com");

        loja.adicionarCliente(cliente);

        assertTrue(loja.getListaClientes().contains(cliente));
        assertEquals(1, loja.getListaClientes().size());
    }

    @Test
    public void testRemoverCliente() {
        Loja.instancia = null;
        File arquivo = new File("dados/loja.dat");
        if (arquivo.exists()) {
            arquivo.delete();
        }

        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Cliente cliente = new Cliente("Ana", "000000123", "ana@gmail.com");

        loja.adicionarCliente(cliente);
        loja.removerCliente(cliente);

        assertFalse(loja.getListaClientes().contains(cliente));
        assertEquals(0, loja.getListaClientes().size());
    }

    public void testAdicionarPedido() {
        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Pedido pedido = new Pedido();

        loja.adicionarPedido(pedido);

        assertTrue(loja.getListaPedido().contains(pedido));
        assertEquals(1, loja.getListaPedido().size());
    }


    @Test
    public void testSalvarECarregarLoja() {
        Loja loja = Loja.getInstancia("Minha Loja Teste", "Rua Teste, 456", Estoque.getInstancia());

        loja.adicionarAdministrador(new Administrador("Pedro", "11122233300", "pedro@email.com", 3));
        loja.adicionarCliente(new Cliente("Clara", "99988877700", "clara@email.com"));

        loja.salvarLoja();

        File arquivo = new File("dados/loja.dat");
        assertTrue(arquivo.exists());

        Loja lojaCarregada = Loja.carregarLoja();
        assertNotNull(lojaCarregada);
        assertEquals("Minha Loja Teste", lojaCarregada.getNome());
        assertEquals("Rua Teste, 456", lojaCarregada.getEndereco());
    }

    @Test
    public void testExibirClientesEAdministradores() {
        Loja.instancia = null;
        File arquivo = new File("dados/loja.dat");
        if (arquivo.exists()) {
            arquivo.delete();
        }

        Loja loja = Loja.getInstancia("Loja de Teste", "Rua do Teste, 789", Estoque.getInstancia());

        loja.adicionarCliente(new Cliente("Lucas", "55511122200", "lucas@email.com"));
        loja.adicionarAdministrador(new Administrador("Paula", "66633344400", "paula@email.com", 4));

        ArrayList<Pessoa> clientes = loja.getListaClientes();
        ArrayList<Pessoa> administradores = loja.getListaAdministradores();

        assertEquals("Lucas", clientes.get(0).getNome());

        assertEquals(1, administradores.size());
        assertEquals("Paula", administradores.get(0).getNome());
    }
}
