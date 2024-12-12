package loja.vestuario.swingFront.Estoque;

import javax.swing.*;

import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CasualFactory;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.EsportivoFactory;
import loja.vestuario.item.ItemEstoque;
import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class AdicionarProduto {
    private JPanel painelCamposAdicionais = new JPanel();
    private Map<String, Component> camposAdicionaisMap = new HashMap<>();

    public AdicionarProduto(Loja lojaAtual) {
        JFrame frame = new JFrame("Adicionar Produto");
        frame.setSize(600, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel tipoLabel = new JLabel("Tipo:");
        String[] tipos = { "Casual", "Esportivo" };
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);

        JLabel categoriaLabel = new JLabel("Categoria:");
        String[] categorias = { "Roupa", "Calça", "Calçado" };
        JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel materialLabel = new JLabel("Material:");
        JTextField materialField = new JTextField();

        JLabel escalaConfortoLabel = new JLabel("Escala Conforto:");
        //JTextField escalaConfortoField = new JTextField();
        String[] opcoesEscalaConforto = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        JComboBox<String> escalaConfortoField = new JComboBox<>(opcoesEscalaConforto);

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JTextField quantidadeField = new JTextField();

        formPanel.add(tipoLabel);
        formPanel.add(tipoComboBox);
        formPanel.add(categoriaLabel);
        formPanel.add(categoriaComboBox);
        formPanel.add(nomeLabel);
        formPanel.add(nomeField);
        formPanel.add(materialLabel);
        formPanel.add(materialField);
        formPanel.add(escalaConfortoLabel);
        formPanel.add(escalaConfortoField);
        formPanel.add(quantidadeLabel);
        formPanel.add(quantidadeField);

        painelCamposAdicionais.setLayout(new BoxLayout(painelCamposAdicionais, BoxLayout.Y_AXIS));
        painelCamposAdicionais.setBorder(BorderFactory.createTitledBorder("Campos Adicionais"));

        JScrollPane scrollPane = new JScrollPane(painelCamposAdicionais);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(e -> {
            try {
                String tipo = (String) tipoComboBox.getSelectedItem();
                String categoria = (String) categoriaComboBox.getSelectedItem();
                String nome = nomeField.getText();
                String material = materialField.getText();
                //String escalaConforto = escalaConfortoField.getText();
                String escalaConforto = (String) escalaConfortoField.getSelectedItem();
                int quantidade = Integer.parseInt(quantidadeField.getText());

                if (nome.isEmpty() || material.isEmpty() || escalaConforto.isEmpty() || quantidade <= 0) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos básicos corretamente.");
                    return;
                }

                // Obter valores dos campos adicionais
                Map<String, String> valoresAdicionais = new HashMap<>();
                camposAdicionaisMap.forEach((label, component) -> {
                    if (component instanceof JTextField) {
                        valoresAdicionais.put(label, ((JTextField) component).getText());
                    } else if (component instanceof JPanel) {
                        JPanel panel = (JPanel) component;
                        for (Component btn : panel.getComponents()) {
                            if (btn instanceof JRadioButton && ((JRadioButton) btn).isSelected()) {
                                valoresAdicionais.put(label, ((JRadioButton) btn).getText());
                            }
                        }
                    }
                });

                Produto produto = null;
                if ("Casual".equals(tipo)) {
                    CasualFactory casualFactory = new CasualFactory();
                    String estilo = valoresAdicionais.get("Estilo");
                    boolean temEstampa = "Sim".equals(valoresAdicionais.get("Tem Estampa"));

                    switch (categoria) {
                        case "Roupa":
                            produto = casualFactory.criarRoupa(nome, material, escalaConforto, estilo, temEstampa,
                                    valoresAdicionais.get("Tipo de Manga"), valoresAdicionais.get("Gola"));
                            break;
                        case "Calça":
                            produto = casualFactory.criarCalca(nome, material, escalaConforto, estilo, temEstampa,
                                    valoresAdicionais.get("Altura da Cintura"), valoresAdicionais.get("Tipo de Fechamento"));
                            break;
                        case "Calçado":
                            produto = casualFactory.criarCalcado(nome, material, escalaConforto, estilo, temEstampa,
                                    valoresAdicionais.get("Tipo de Fechamento"), valoresAdicionais.get("Altura do Cano"));
                            break;
                    }
                } else if ("Esportivo".equals(tipo)) {
                    EsportivoFactory esportivoFactory = new EsportivoFactory();
                    /*int escalaResistencia = Integer.parseInt(valoresAdicionais.get("Escala Resistência"));
                    int escalaElasticidade = Integer.parseInt(valoresAdicionais.get("Escala Elasticidade"));*/
                    int escalaResistencia = (int) ((JComboBox<?>) camposAdicionaisMap.get("Escala Resistência")).getSelectedItem();
                    int escalaElasticidade = (int) ((JComboBox<?>) camposAdicionaisMap.get("Escala Elasticidade")).getSelectedItem();
                    String tecnologia = valoresAdicionais.get("Tecnologia");

                    switch (categoria) {
                        case "Roupa":
                            produto = esportivoFactory.criarRoupa(nome, material, escalaConforto, escalaResistencia,
                                    escalaElasticidade, tecnologia, valoresAdicionais.get("Antibacteriana"),
                                    valoresAdicionais.get("Leveza/Flexibilidade"));
                            break;
                        case "Calça":
                            produto = esportivoFactory.criarCalca(nome, material, escalaConforto, escalaResistencia,
                                    escalaElasticidade, tecnologia, valoresAdicionais.get("Tecido Respirável"),
                                    valoresAdicionais.get("Ajuste Flexível"));
                            break;
                        case "Calçado":
                            produto = esportivoFactory.criarCalcado(nome, material, escalaConforto, escalaResistencia,
                                    escalaElasticidade, tecnologia, "Sim".equals(valoresAdicionais.get("Sola Antiderrapante")),
                                    "Sim".equals(valoresAdicionais.get("Amortecimento")),
                                    "Sim".equals(valoresAdicionais.get("Suporte Extra")));
                            break;
                    }
                }

                if (produto != null) {
                    Estoque estoqueAtual = lojaAtual.getEstoque();
                    ItemEstoque itemEstoque = new ItemEstoque(produto, quantidade, estoqueAtual);
                    estoqueAtual.adicionarItemEstoque(itemEstoque);
                    JOptionPane.showMessageDialog(frame, "Produto adicionado ao estoque!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Erro ao criar o produto. Verifique os campos adicionais.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha os campos numéricos corretamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(adicionarButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        atualizarCamposAdicionais(tipoComboBox, categoriaComboBox, painelCamposAdicionais);
        tipoComboBox.addActionListener(e -> atualizarCamposAdicionais(tipoComboBox, categoriaComboBox, painelCamposAdicionais));
        categoriaComboBox.addActionListener(e -> atualizarCamposAdicionais(tipoComboBox, categoriaComboBox, painelCamposAdicionais));
        frame.setVisible(true);
    }

    private void atualizarCamposAdicionais(JComboBox<String> tipoComboBox, JComboBox<String> categoriaComboBox,
                                           JPanel painelCamposAdicionais) {
        painelCamposAdicionais.removeAll();
        camposAdicionaisMap.clear();

        String tipo = (String) tipoComboBox.getSelectedItem();
        String categoria = (String) categoriaComboBox.getSelectedItem();

        if ("Casual".equals(tipo)) {
            adicionarCampo("Estilo", new JTextField());
            adicionarCampo("Tem Estampa", criarRadioButtonPanel());
            if ("Roupa".equals(categoria)) {
                adicionarCampo("Tipo de Manga", new JTextField());
                adicionarCampo("Gola", new JTextField());
            } else if ("Calça".equals(categoria)) {
                adicionarCampo("Altura da Cintura", new JTextField());
                adicionarCampo("Tipo de Fechamento", new JTextField());
            } else if ("Calçado".equals(categoria)) {
                adicionarCampo("Tipo de Fechamento", new JTextField());
                adicionarCampo("Altura do Cano", new JTextField());
            }
        } else if ("Esportivo".equals(tipo)) {
            /*adicionarCampo("Escala Resistência", new JTextField());
            adicionarCampo("Escala Elasticidade", new JTextField());*/
            adicionarCampo("Escala Resistência", criarComboBoxDe1a10());
            adicionarCampo("Escala Elasticidade", criarComboBoxDe1a10());
            adicionarCampo("Tecnologia", new JTextField());
            if ("Roupa".equals(categoria)) {
                adicionarCampo("Antibacteriana", criarRadioButtonPanel());
                adicionarCampo("Leveza/Flexibilidade", criarRadioButtonPanel());
            } else if ("Calça".equals(categoria)) {
                adicionarCampo("Tecido Respirável", criarRadioButtonPanel());
                adicionarCampo("Ajuste Flexível", criarRadioButtonPanel());
            } else if ("Calçado".equals(categoria)) {
                adicionarCampo("Sola Antiderrapante", criarRadioButtonPanel());
                adicionarCampo("Amortecimento", criarRadioButtonPanel());
                adicionarCampo("Suporte Extra", criarRadioButtonPanel());
            }
        }

        painelCamposAdicionais.revalidate();
        painelCamposAdicionais.repaint();
    }

    private void adicionarCampo(String label, Component component) {
        painelCamposAdicionais.add(new JLabel(label));
        painelCamposAdicionais.add(component);
        camposAdicionaisMap.put(label, component);
    }

    private JPanel criarRadioButtonPanel() {
        JPanel panel = new JPanel();
        JRadioButton simButton = new JRadioButton("Sim");
        JRadioButton naoButton = new JRadioButton("Não");

        ButtonGroup group = new ButtonGroup();
        group.add(simButton);
        group.add(naoButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(simButton);
        panel.add(naoButton);

        return panel;
    }

    private JComboBox<Integer> criarComboBoxDe1a10() {
        JComboBox<Integer> comboBox = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            comboBox.addItem(i);
        }
        return comboBox;
    }
    
}