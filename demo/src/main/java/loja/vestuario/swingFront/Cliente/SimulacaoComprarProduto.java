package loja.vestuario.swingFront.Cliente;

import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;
import loja.vestuario.item.ItemEstoque;
import loja.vestuario.loja.Pedido;
import loja.vestuario.item.ItemPedido;
import loja.vestuario.pessoa.Cliente;
import loja.vestuario.pessoa.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimulacaoComprarProduto {

    public SimulacaoComprarProduto(Loja lojaAtual) {
        Estoque estoqueAtual = lojaAtual.getEstoque();
        ArrayList<Pessoa> clientes = lojaAtual.getListaClientes();
        Pedido pedido = new Pedido();

        JFrame frame = new JFrame("Simulação Comprar Produto");
        frame.setSize(400, 350);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelTitulo = new JLabel("Simulação Comprar Produto", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelTitulo, gbc);

        DefaultComboBoxModel<Pessoa> modelComboBoxCliente = new DefaultComboBoxModel<>();
        for (Pessoa cliente : clientes) {
            modelComboBoxCliente.addElement(cliente);
        }

        JComboBox<Pessoa> comboBoxCliente = new JComboBox<>(modelComboBoxCliente);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(comboBoxCliente, gbc);

        DefaultComboBoxModel<ItemEstoque> modelComboBoxProduto = new DefaultComboBoxModel<>();
        for (ItemEstoque item : estoqueAtual.getListaItemEstoque()) {
            modelComboBoxProduto.addElement(item);
        }

        JComboBox<ItemEstoque> comboBoxProduto = new JComboBox<>(modelComboBoxProduto);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(comboBoxProduto, gbc);

        JTextField quantidadeField = new JTextField();
        quantidadeField.setColumns(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel("Quantidade a remover:"), gbc);
        gbc.gridx = 1;
        painel.add(quantidadeField, gbc);

        JButton btnSimularCompra = new JButton("Simular Compra");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(btnSimularCompra, gbc);

        btnSimularCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemEstoque itemSelecionado = (ItemEstoque) comboBoxProduto.getSelectedItem();
                Cliente clienteSelecionado = (Cliente) comboBoxCliente.getSelectedItem();
                String quantidadeText = quantidadeField.getText();
                try {
                    int quantidadeRemover = Integer.parseInt(quantidadeText);
                    if (itemSelecionado != null && clienteSelecionado != null && quantidadeRemover > 0) {
                        itemSelecionado.getState().remover(quantidadeRemover);

                        ItemPedido itemPedido = new ItemPedido(itemSelecionado.getProduto(), quantidadeRemover, clienteSelecionado);
                        pedido.adicionarItemPedido(itemPedido);
                        lojaAtual.adicionarPedido(pedido);

                        JOptionPane.showMessageDialog(frame, "Compra simulada com sucesso!\n" + pedido.descreverPedido());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Selecione um item válido e insira uma quantidade válida.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para a quantidade.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage());
                }
            }
        });

        frame.add(painel);
        frame.setVisible(true);
    }
}