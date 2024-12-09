package loja.vestuario.swingFront.Estoque;

import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;
import loja.vestuario.item.ItemEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverProduto {

    public RemoverProduto(Loja lojaAtual) {
        Estoque estoqueAtual = lojaAtual.getEstoque();

        // Criação da janela
        JFrame frame = new JFrame("Excluir Produto");
        frame.setSize(400, 300);

        // Layout do painel com GridBagLayout
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Título
        JLabel labelTitulo = new JLabel("Excluir Produto", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelTitulo, gbc);

        // ComboBox para selecionar o produto (usando o toString sobrescrito)
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

        // Botão de excluir
        JButton btnExcluir = new JButton("Excluir");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(btnExcluir, gbc);

        // Ação do botão de excluir
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemEstoque itemSelecionado = (ItemEstoque) comboBox.getSelectedItem();
                if (itemSelecionado != null) {
                    estoqueAtual.removerItemEstoque(itemSelecionado);
                    modelComboBox.removeElement(itemSelecionado);  // Remove o item do ComboBox
                    JOptionPane.showMessageDialog(frame, "Produto removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um item para excluir.");
                }
            }
        });

        // Adicionando o painel no JFrame
        frame.add(painel);
        frame.setVisible(true);
    }
}
