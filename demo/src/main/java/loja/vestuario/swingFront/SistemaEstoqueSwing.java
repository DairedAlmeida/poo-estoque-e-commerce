package loja.vestuario.swingFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEstoqueSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaEstoqueSwing::telaInicial);
    }

    // Tela Inicial
    public static void telaInicial() {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton areaCadastroPessoa = new JButton("Área Cadastro Pessoa");
        JButton areaEstoque = new JButton("Área Estoque");
        JButton areaCliente = new JButton("Área Cliente");

        areaCadastroPessoa.addActionListener(e -> areaCadastroPessoa());
        areaEstoque.addActionListener(e -> areaEstoque());
        areaCliente.addActionListener(e -> areaCliente());

        panel.add(areaCadastroPessoa);
        panel.add(areaEstoque);
        panel.add(areaCliente);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Área Cadastro Pessoa
    public static void areaCadastroPessoa() {
        JFrame frame = new JFrame("Área Cadastro Pessoa");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton cadastrarCliente = new JButton("Cadastrar Cliente");
        JButton cadastrarAdministrador = new JButton("Cadastrar Administrador");
        JButton listaPessoas = new JButton("Lista de Pessoas");

        cadastrarCliente.addActionListener(e -> cadastrarCliente());
        cadastrarAdministrador.addActionListener(e -> cadastrarAdministrador());
        listaPessoas.addActionListener(e -> listaPessoas());

        panel.add(cadastrarCliente);
        panel.add(cadastrarAdministrador);
        panel.add(listaPessoas);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Cadastro Cliente
    public static void cadastrarCliente() {
        JFrame frame = new JFrame("Cadastrar Cliente");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        JTextField nome = new JTextField();
        panel.add(nome);

        panel.add(new JLabel("CPF:"));
        JTextField cpf = new JTextField();
        panel.add(cpf);

        panel.add(new JLabel("Email:"));
        JTextField email = new JTextField();
        panel.add(email);

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
            // Implementar lógica de salvar cliente
            JOptionPane.showMessageDialog(frame, "Cliente salvo com sucesso!");
            frame.dispose();
        });

        panel.add(new JLabel());
        panel.add(salvar);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Cadastro Administrador
    public static void cadastrarAdministrador() {
        JFrame frame = new JFrame("Cadastrar Administrador");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Nome:"));
        JTextField nome = new JTextField();
        panel.add(nome);

        panel.add(new JLabel("CPF:"));
        JTextField cpf = new JTextField();
        panel.add(cpf);

        panel.add(new JLabel("Email:"));
        JTextField email = new JTextField();
        panel.add(email);

        panel.add(new JLabel("Matrícula:"));
        JTextField matricula = new JTextField();
        panel.add(matricula);

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> {
            // Implementar lógica de salvar administrador
            JOptionPane.showMessageDialog(frame, "Administrador salvo com sucesso!");
            frame.dispose();
        });

        panel.add(new JLabel());
        panel.add(salvar);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Lista de Pessoas
    public static void listaPessoas() {
        JFrame frame = new JFrame("Lista de Pessoas");
        frame.setSize(400, 300);

        JList<String> lista = new JList<>(new String[]{"Cliente: João", "Administrador: Maria"});
        frame.add(new JScrollPane(lista));

        frame.setVisible(true);
    }

    // Área Estoque
    public static void areaEstoque() {
        JFrame frame = new JFrame("Área Estoque");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton adicionarProduto = new JButton("Adicionar Produto");
        JButton removerProduto = new JButton("Remover Produto");
        JButton listaProduto = new JButton("Lista Produto");

        adicionarProduto.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Adicionar Produto: implementar lógica!"));
        removerProduto.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Remover Produto: implementar lógica!"));
        listaProduto.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Lista Produto: implementar lógica!"));

        panel.add(adicionarProduto);
        panel.add(removerProduto);
        panel.add(listaProduto);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Área Cliente
    public static void areaCliente() {
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