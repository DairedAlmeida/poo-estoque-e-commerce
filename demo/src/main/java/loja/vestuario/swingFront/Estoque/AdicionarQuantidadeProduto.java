package loja.vestuario.swingFront.Estoque;

import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;
import loja.vestuario.item.ItemEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarQuantidadeProduto {
    public AdicionarQuantidadeProduto(Loja lojaAtual) {
        Estoque estoqueAtual = lojaAtual.getEstoque();

        // Criação da janela
        JFrame frame = new JFrame("Adicionar Quantidade ao Produto");
        frame.setSize(400, 300);

        // Layout do painel com GridBagLayout
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Título
        JLabel labelTitulo = new JLabel("Adicionar Quantidade ao Produto", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelTitulo, gbc);

        // ComboBox para selecionar o produto
        DefaultComboBoxModel<ItemEstoque> modelComboBox = new DefaultComboBoxModel<>();
        for (ItemEstoque item : estoqueAtual.getListaItemEstoque()) {
            modelComboBox.addElement(item);
        }

        JComboBox<ItemEstoque> comboBox = new JComboBox<>(modelComboBox);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(comboBox, gbc);

        // Campo de texto para quantidade
        JTextField quantidadeField = new JTextField();
        quantidadeField.setColumns(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("Quantidade a adicionar:"), gbc);
        gbc.gridx = 1;
        painel.add(quantidadeField, gbc);

        // Botão de adicionar
        JButton btnAdicionar = new JButton("Adicionar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(btnAdicionar, gbc);

        // Ação do botão de adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemEstoque itemSelecionado = (ItemEstoque) comboBox.getSelectedItem();
                String quantidadeText = quantidadeField.getText();
                try {
                    int quantidadeAdicionar = Integer.parseInt(quantidadeText);
                    if (itemSelecionado != null && quantidadeAdicionar > 0) {
                        itemSelecionado.getState().adicionar(quantidadeAdicionar); // Método que adiciona quantidade no item
                        JOptionPane.showMessageDialog(frame, "Quantidade adicionada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Selecione um item válido e insira uma quantidade válida.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para a quantidade.");
                }
            }
        });

        // Adicionando o painel no JFrame
        frame.add(painel);
        frame.setVisible(true);
    }
}
