package loja.vestuario.swingFront.CadastroPessoa;
import javax.swing.*;

import loja.vestuario.loja.Loja;
import loja.vestuario.pessoa.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCliente {
    Loja loja;

    public CadastrarCliente(Loja lojaAtual) {
        this.loja = lojaAtual;

        JFrame frame = new JFrame("Cadastrar Cliente");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        panel.add(emailField);

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> salvarCliente(nomeField.getText().trim(), cpfField.getText().trim(), emailField.getText().trim(), frame));

        panel.add(new JLabel());
        panel.add(salvar);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void salvarCliente(String nome, String cpf, String email, JFrame frame) {
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, cpf, email);
        this.loja.adicionarCliente(cliente);

        JOptionPane.showMessageDialog(frame, "Cliente salvo com sucesso!");
        frame.dispose();
    }
}