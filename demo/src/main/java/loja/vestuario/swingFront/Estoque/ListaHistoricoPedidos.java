package loja.vestuario.swingFront.Estoque;

import loja.vestuario.loja.Loja;
import loja.vestuario.loja.Pedido;
import loja.vestuario.item.ItemPedido;
import loja.vestuario.pessoa.Cliente;
import loja.vestuario.abstractFactoryProduto.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaHistoricoPedidos {

    public ListaHistoricoPedidos(Loja lojaAtual) {
        
        JFrame frame = new JFrame("Histórico de Pedidos");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JTable tabelaPedidos = criarTabelaPedidos(lojaAtual.getListaPedido());

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.add(criarPainelComTabela("Pedidos", tabelaPedidos), BorderLayout.CENTER);

        frame.add(painel, BorderLayout.CENTER);
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

    private JTable criarTabelaPedidos(ArrayList<Pedido> listaPedidos) {
        String[] colunas = {"ID Cliente", "Nome Cliente", "ID Produto", "Nome Produto", "Quantidade"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Pedido pedido : listaPedidos) {
            for (ItemPedido itemPedido : pedido.getListalistaItemPedido()) {
                Cliente cliente = itemPedido.getCliente();
                Produto produto = itemPedido.getProduto();
                int quantidade = itemPedido.getQuantidade();
                model.addRow(new Object[]{
                    cliente.getIdCadastro(), cliente.getNome(), produto.getId(), produto.getNome(), quantidade
                });
            }
        }

        return new JTable(model);
    }
}
