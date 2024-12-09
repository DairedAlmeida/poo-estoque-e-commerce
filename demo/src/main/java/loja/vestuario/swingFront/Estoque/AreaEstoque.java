package loja.vestuario.swingFront.Estoque;
import javax.swing.*;

import loja.vestuario.loja.Loja;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        adicionarProduto.addActionListener(e -> {new AdicionarProduto(lojaAtual);});
        adicionarQuantidadeProduto.addActionListener(e -> {new AdicionarQuantidadeProduto(lojaAtual);});
        removerProduto.addActionListener(e -> {new RemoverProduto(lojaAtual);});
        listaProduto.addActionListener(e -> {new ListaItensEstoque(lojaAtual);});

        panel.add(adicionarProduto);
        panel.add(adicionarQuantidadeProduto);
        panel.add(removerProduto);
        panel.add(listaProduto);

        frame.add(panel);
        frame.setVisible(true);
    }
}
