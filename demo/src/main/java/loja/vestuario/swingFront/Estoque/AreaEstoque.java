package loja.vestuario.swingFront.Estoque;
import javax.swing.*;

import loja.vestuario.loja.Loja;

import java.awt.*;

public class AreaEstoque {
    public AreaEstoque(Loja lojaAtual) {
        JFrame frame = new JFrame("Área Estoque");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton adicionarProduto = new JButton("Adicionar Produto");
        JButton adicionarQuantidadeProduto = new JButton("Adicionar Quantidade Produto");
        JButton removerProduto = new JButton("Remover Produto");
        JButton listaProduto = new JButton("Lista Produto");
        JButton listaHistoricoPedidos = new JButton("Lista Historico Pedidos");

        adicionarProduto.addActionListener(e -> {new AdicionarProduto(lojaAtual);});
        adicionarQuantidadeProduto.addActionListener(e -> {new AdicionarQuantidadeProduto(lojaAtual);});
        removerProduto.addActionListener(e -> {new RemoverProduto(lojaAtual);});
        listaProduto.addActionListener(e -> {new ListaItensEstoque(lojaAtual);});
        listaHistoricoPedidos.addActionListener(e -> {new ListaHistoricoPedidos(lojaAtual);});

        panel.add(adicionarProduto);
        panel.add(adicionarQuantidadeProduto);
        panel.add(removerProduto);
        panel.add(listaProduto);
        panel.add(listaHistoricoPedidos);

        frame.add(panel);
        frame.setVisible(true);
    }
}
