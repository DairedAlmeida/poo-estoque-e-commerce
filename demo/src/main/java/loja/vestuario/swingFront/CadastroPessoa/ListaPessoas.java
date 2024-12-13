package loja.vestuario.swingFront.CadastroPessoa;

import loja.vestuario.loja.Loja;
import loja.vestuario.pessoa.Administrador;
import loja.vestuario.pessoa.Cliente;
import loja.vestuario.pessoa.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaPessoas {
    public ListaPessoas(Loja lojaAtual) {
        
        JFrame frame = new JFrame("Lista de Pessoas");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        JTable tabelaClientes = criarTabelaClientes(lojaAtual.getListaClientes());
        JTable tabelaAdministradores = criarTabelaAdministradores(lojaAtual.getListaAdministradores());

        painelPrincipal.add(criarPainelComTabela("Clientes", tabelaClientes));
        painelPrincipal.add(criarPainelComTabela("Administradores", tabelaAdministradores));

        frame.add(painelPrincipal, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel criarPainelComTabela(String titulo, JTable tabela) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel(titulo, SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(labelTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        return painel;
    }

    private JTable criarTabelaClientes(ArrayList<Pessoa> listaClientes) {
        String[] colunas = {"ID", "Nome", "CPF", "Email"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Pessoa pessoa : listaClientes) {
            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                model.addRow(new Object[]{cliente.getIdCadastro(), cliente.getNome(), cliente.getCpf(), cliente.getEmail()});
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaAdministradores(ArrayList<Pessoa> listaAdministradores) {
        String[] colunas = {"Nome", "CPF", "Email", "Matrícula"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Pessoa pessoa : listaAdministradores) {
            if (pessoa instanceof Administrador) {
                Administrador administrador = (Administrador) pessoa;
                model.addRow(new Object[]{administrador.getNome(), administrador.getCpf(), administrador.getEmail(), administrador.getMatricula()});
            }
        }

        return new JTable(model);
    }
}
