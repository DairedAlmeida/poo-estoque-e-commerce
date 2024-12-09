package loja.vestuario.swingFront.Estoque;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PainelCamposAdicionais {
    private JPanel panel;

    public PainelCamposAdicionais() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Campos Adicionais"));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void atualizarCamposAdicionais(String tipo, String categoria) {
        panel.removeAll();

        if ("Casual".equals(tipo)) {
            panel.add(createField("Estilo"));
            panel.add(createRadioButtons("Tem Estampa"));
            if ("Roupa".equals(categoria)) {
                panel.add(createField("Tipo de Manga"));
                panel.add(createField("Gola"));
            } else if ("Calça".equals(categoria)) {
                panel.add(createField("Altura da Cintura"));
                panel.add(createField("Tipo de Fechamento"));
            } else if ("Calçado".equals(categoria)) {
                panel.add(createField("Tipo de Fechamento"));
                panel.add(createField("Altura do Cano"));
            }
        } else if ("Esportivo".equals(tipo)) {
            panel.add(createField("Escala Resistência"));
            panel.add(createField("Escala Elasticidade"));
            panel.add(createField("Tecnologia"));
            if ("Roupa".equals(categoria)) {
                panel.add(createRadioButtons("Antibacteriana"));
                panel.add(createRadioButtons("Leveza/Flexibilidade"));
            } else if ("Calça".equals(categoria)) {
                panel.add(createRadioButtons("Tecido Respirável"));
                panel.add(createRadioButtons("Ajuste Flexível"));
            } else if ("Calçado".equals(categoria)) {
                panel.add(createRadioButtons("Sola Antiderrapante"));
                panel.add(createRadioButtons("Amortecimento"));
                panel.add(createRadioButtons("Suporte Extra"));
            }
        }

        panel.revalidate();
        panel.repaint();
    }

    public Map<String, String> getCamposAdicionais() {
        Map<String, String> valores = new HashMap<>();
        Component[] components = panel.getComponents();

        for (int i = 0; i < components.length; i += 2) {
            JLabel label = (JLabel) components[i];
            Component field = components[i + 1];

            if (field instanceof JTextField) {
                valores.put(label.getText(), ((JTextField) field).getText());
            } else if (field instanceof JPanel) {
                for (Component comp : ((JPanel) field).getComponents()) {
                    if (comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
                        valores.put(label.getText(), ((JRadioButton) comp).getText());
                    }
                }
            }
        }
        return valores;
    }

    private JPanel createRadioButtons(String label) {
        JPanel panel = new JPanel();
        JRadioButton simButton = new JRadioButton("Sim");
        JRadioButton naoButton = new JRadioButton("Não");

        ButtonGroup group = new ButtonGroup();
        group.add(simButton);
        group.add(naoButton);

        panel.add(simButton);
        panel.add(naoButton);

        return panel;
    }

    private JPanel createField(String label) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        fieldPanel.add(new JLabel(label), BorderLayout.WEST);
        fieldPanel.add(new JTextField(), BorderLayout.CENTER);
        return fieldPanel;
    }
}