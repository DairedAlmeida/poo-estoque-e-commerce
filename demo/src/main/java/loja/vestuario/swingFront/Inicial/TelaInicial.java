package loja.vestuario.swingFront.Inicial;
import loja.vestuario.loja.Loja;
import loja.vestuario.swingFront.CadastroPessoa.AreaCadastroPessoa;
import loja.vestuario.swingFront.Cliente.AreaCliente;
import loja.vestuario.swingFront.Estoque.AreaEstoque;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TelaInicial {
    public TelaInicial(Loja lojaAtual) {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton areaCadastroPessoa = new JButton("Área Cadastro Pessoa");
        JButton areaEstoque = new JButton("Área Estoque");
        JButton areaCliente = new JButton("Área Cliente");

        areaCadastroPessoa.addActionListener(e -> new AreaCadastroPessoa(lojaAtual));
        areaEstoque.addActionListener(e -> new AreaEstoque(lojaAtual));
        areaCliente.addActionListener(e -> new AreaCliente());

        panel.add(areaCadastroPessoa);
        panel.add(areaEstoque);
        panel.add(areaCliente);

        frame.add(panel);
        frame.setVisible(true);
    }
}