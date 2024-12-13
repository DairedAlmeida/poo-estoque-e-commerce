package loja.vestuario.swingFront.Cliente;
import javax.swing.*;
import loja.vestuario.loja.Loja;

import java.awt.*;

public class AreaCliente {
    public AreaCliente(Loja lojaAtual) {
        JFrame frame = new JFrame("Área Cliente");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton simulacaoComprarProduto = new JButton("Simulação Comprar Produto");
        simulacaoComprarProduto.addActionListener(e -> new SimulacaoComprarProduto(lojaAtual));
        panel.add(simulacaoComprarProduto);

        frame.add(panel);
        frame.setVisible(true);
    }
}