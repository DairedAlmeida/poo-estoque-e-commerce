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

        JFrame frame = new JFrame("Excluir Produto");
        frame.setSize(400, 300);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel labelTitulo = new JLabel("Excluir Produto", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelTitulo, gbc);

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

        JButton btnExcluir = new JButton("Excluir");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(btnExcluir, gbc);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemEstoque itemSelecionado = (ItemEstoque) comboBox.getSelectedItem();
                if (itemSelecionado != null) {
                    estoqueAtual.removerItemEstoque(itemSelecionado);
                    modelComboBox.removeElement(itemSelecionado);
                    JOptionPane.showMessageDialog(frame, "Produto removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um item para excluir.");
                }
            }
        });

        frame.add(painel);
        frame.setVisible(true);
    }
}
