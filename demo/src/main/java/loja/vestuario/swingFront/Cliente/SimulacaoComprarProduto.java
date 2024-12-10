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
import java.util.List;

public class SimulacaoComprarProduto {

    public SimulacaoComprarProduto(Loja lojaAtual) {
        // Obtenção do estoque da loja e lista de clientes
        Estoque estoqueAtual = lojaAtual.getEstoque();
        ArrayList<Pessoa> clientes = lojaAtual.getListaClientes();  // Obtendo lista de clientes da loja
        Pedido pedido = new Pedido();  // Histórico de pedidos

        // Criação da janela
        JFrame frame = new JFrame("Simulação Comprar Produto");
        frame.setSize(400, 350);

        // Layout do painel com GridBagLayout
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Título
        JLabel labelTitulo = new JLabel("Simulação Comprar Produto", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelTitulo, gbc);

        // ComboBox para selecionar o cliente
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

        // ComboBox para selecionar o produto
        DefaultComboBoxModel<ItemEstoque> modelComboBoxProduto = new DefaultComboBoxModel<>();
        for (ItemEstoque item : estoqueAtual.getListaItemEstoque()) {
            modelComboBoxProduto.addElement(item);
        }

        JComboBox<ItemEstoque> comboBoxProduto = new JComboBox<>(modelComboBoxProduto);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(comboBoxProduto, gbc);

        // Campo de texto para quantidade
        JTextField quantidadeField = new JTextField();
        quantidadeField.setColumns(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel("Quantidade a remover:"), gbc);
        gbc.gridx = 1;
        painel.add(quantidadeField, gbc);

        // Botão de simulação de compra (remover do estoque)
        JButton btnSimularCompra = new JButton("Simular Compra");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(btnSimularCompra, gbc);

        // Ação do botão de simulação de compra (remover)
        btnSimularCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemEstoque itemSelecionado = (ItemEstoque) comboBoxProduto.getSelectedItem();
                Cliente clienteSelecionado = (Cliente) comboBoxCliente.getSelectedItem();
                String quantidadeText = quantidadeField.getText();
                try {
                    int quantidadeRemover = Integer.parseInt(quantidadeText);
                    if (itemSelecionado != null && clienteSelecionado != null && quantidadeRemover > 0) {
                        // Verificando se há quantidade suficiente para remover
                        itemSelecionado.getState().remover(quantidadeRemover); // Método que remove a quantidade no item

                        // Adicionando o item removido ao pedido (historico de compra)
                        ItemPedido itemPedido = new ItemPedido(itemSelecionado.getProduto(), quantidadeRemover, clienteSelecionado);
                        pedido.adicionarItemPedido(itemPedido);
                        lojaAtual.adicionarPedido(pedido);

                        // Exibindo o histórico de pedidos e remoções
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

        // Adicionando o painel no JFrame
        frame.add(painel);
        frame.setVisible(true);
    }
}