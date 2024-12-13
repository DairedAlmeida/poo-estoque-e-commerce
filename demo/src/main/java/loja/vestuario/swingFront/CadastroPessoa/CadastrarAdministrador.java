package loja.vestuario.swingFront.CadastroPessoa;
import javax.swing.*;

import loja.vestuario.loja.Loja;
import loja.vestuario.pessoa.Administrador;

import java.awt.*;

public class CadastrarAdministrador {

    Loja loja;
    public CadastrarAdministrador(Loja lojaAtual) {
        this.loja = lojaAtual;
        JFrame frame = new JFrame("Cadastrar Administrador");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Matrícula:"));
        JTextField matriculaField = new JTextField();
        panel.add(matriculaField);

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> salvarAdministrador(nomeField.getText().trim(), cpfField.getText().trim(), emailField.getText().trim(), matriculaField.getText().trim(), frame));

        panel.add(new JLabel());
        panel.add(salvar);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void salvarAdministrador(String nome, String cpf, String email, String matricula, JFrame frame) {
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || matricula.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int matriculaInt = Integer.parseInt(matricula);

            Administrador administrador = new Administrador(nome, cpf, email, matriculaInt);
            this.loja.adicionarAdministrador(administrador);

            JOptionPane.showMessageDialog(frame, "Administrador salvo com sucesso!");
            frame.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Matrícula deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}