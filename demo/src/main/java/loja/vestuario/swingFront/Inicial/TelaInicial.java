package loja.vestuario.swingFront.Inicial;

import loja.vestuario.loja.Loja;
import loja.vestuario.swingFront.CadastroPessoa.AreaCadastroPessoa;
import loja.vestuario.swingFront.Cliente.AreaCliente;
import loja.vestuario.swingFront.Estoque.AreaEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicial {
    public TelaInicial(Loja lojaAtual) {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuSalvar = new JMenuItem("Salvar Loja");
        JMenuItem menuCarregar = new JMenuItem("Carregar Loja");

        menuSalvar.addActionListener((ActionEvent e) -> {
            lojaAtual.salvarLoja();
            JOptionPane.showMessageDialog(frame, "Loja salva com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        });

        menuCarregar.addActionListener((ActionEvent e) -> {
            Loja lojaCarregada = Loja.carregarLoja();
            if (lojaCarregada != null) {
                JOptionPane.showMessageDialog(frame, "Loja carregada com sucesso!", "Carregar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Erro ao carregar loja!", "Carregar", JOptionPane.ERROR_MESSAGE);
            }
        });

        menuArquivo.add(menuSalvar);
        menuArquivo.add(menuCarregar);
        menuBar.add(menuArquivo);
        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton areaCadastroPessoa = new JButton("Área Cadastro Pessoa");
        JButton areaEstoque = new JButton("Área Estoque");
        JButton areaCliente = new JButton("Área Cliente");

        areaCadastroPessoa.addActionListener(e -> new AreaCadastroPessoa(lojaAtual));
        areaEstoque.addActionListener(e -> new AreaEstoque(lojaAtual));
        areaCliente.addActionListener(e -> new AreaCliente(lojaAtual));

        panel.add(areaCadastroPessoa);
        panel.add(areaEstoque);
        panel.add(areaCliente);

        frame.add(panel);
        frame.setVisible(true);
    }
}