package loja.vestuario.swingFront.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCliente {
    public AreaCliente() {
        JFrame frame = new JFrame("Área Cliente");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton comprarProduto = new JButton("Comprar Produto");
        JButton listaPedidosCliente = new JButton("Lista Pedidos Cliente");

        comprarProduto.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Comprar Produto: implementar lógica!"));
        listaPedidosCliente.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Lista Pedidos Cliente: implementar lógica!"));

        panel.add(comprarProduto);
        panel.add(listaPedidosCliente);

        frame.add(panel);
        frame.setVisible(true);
    }
}