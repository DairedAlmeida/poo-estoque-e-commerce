package loja.vestuario.loja;

import loja.vestuario.pessoa.Administrador;
import loja.vestuario.pessoa.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

public class LojaTest {

    @Test
    public void testAdicionarAdministrador() {
        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Administrador administrador = new Administrador("João", "12345678900", "joao@email.com", 1);

        loja.adicionarAdministrador(administrador);

        assertTrue(loja.getListaAdministradores().contains(administrador));
        assertEquals(1, loja.getListaAdministradores().size());
    }

    @Test
    public void testAdicionarCliente() {
        Loja loja = Loja.getInstancia("Minha Loja", "Rua Principal, 123", Estoque.getInstancia());
        Cliente cliente = new Cliente("Maria", "98765432100", "maria@email.com");

        loja.adicionarCliente(cliente);

        assertTrue(loja.getListaClientes().contains(cliente));
        assertEquals(1, loja.getListaClientes().size());
    }
}
