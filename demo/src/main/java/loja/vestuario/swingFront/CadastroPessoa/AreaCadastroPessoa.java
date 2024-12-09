package loja.vestuario.swingFront.CadastroPessoa;
import javax.swing.*;

import loja.vestuario.loja.Loja;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCadastroPessoa {
    public AreaCadastroPessoa(Loja lojaAtual) {
        JFrame frame = new JFrame("Área Cadastro Pessoa");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton cadastrarCliente = new JButton("Cadastrar Cliente");
        JButton cadastrarAdministrador = new JButton("Cadastrar Administrador");
        JButton listaPessoas = new JButton("Lista de Pessoas");

        cadastrarCliente.addActionListener(e -> new CadastrarCliente(lojaAtual));
        cadastrarAdministrador.addActionListener(e -> new CadastrarAdministrador(lojaAtual));
        listaPessoas.addActionListener(e -> new ListaPessoas(lojaAtual));

        panel.add(cadastrarCliente);
        panel.add(cadastrarAdministrador);
        panel.add(listaPessoas);

        frame.add(panel);
        frame.setVisible(true);
    }
}
