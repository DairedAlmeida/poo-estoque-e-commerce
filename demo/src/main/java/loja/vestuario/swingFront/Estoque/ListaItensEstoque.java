package loja.vestuario.swingFront.Estoque;

import loja.vestuario.abstractFactoryProduto.Produto;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcaCasual;
import loja.vestuario.abstractFactoryProduto.produtoCasual.CalcadoCasual;
import loja.vestuario.abstractFactoryProduto.produtoCasual.RoupaCasual;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.CalcaEsportiva;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.CalcadoEsportiva;
import loja.vestuario.abstractFactoryProduto.produtoEsportivo.RoupaEsportiva;
import loja.vestuario.item.ItemEstoque;
import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaItensEstoque {

    public ListaItensEstoque(Loja lojaAtual) {
        Estoque estoqueAtual = lojaAtual.getEstoque();

        // Criação do JFrame
        JFrame frame = new JFrame("Lista de Itens no Estoque");
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        // Painel principal com layout de grade para exibir 6 tabelas
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(3, 2, 10, 10)); // 3 linhas, 2 colunas

        // Criando tabelas separadas
        JTable tabelaRoupasCasual = criarTabelaRoupasCasual(estoqueAtual.getListaItemEstoque());
        JTable tabelaCalcasCasual = criarTabelaCalcasCasual(estoqueAtual.getListaItemEstoque());
        JTable tabelaCalcadosCasual = criarTabelaCalcadosCasual(estoqueAtual.getListaItemEstoque());

        JTable tabelaRoupasEsportiva = criarTabelaRoupasEsportiva(estoqueAtual.getListaItemEstoque());
        JTable tabelaCalcasEsportiva = criarTabelaCalcasEsportiva(estoqueAtual.getListaItemEstoque());
        JTable tabelaCalcadosEsportiva = criarTabelaCalcadosEsportiva(estoqueAtual.getListaItemEstoque());

        // Adicionando tabelas ao painel principal
        painelPrincipal.add(criarPainelComTabela("Roupas Casuais", tabelaRoupasCasual));
        painelPrincipal.add(criarPainelComTabela("Roupas Esportivas", tabelaRoupasEsportiva));
        painelPrincipal.add(criarPainelComTabela("Calças Casuais", tabelaCalcasCasual));
        painelPrincipal.add(criarPainelComTabela("Calças Esportivas", tabelaCalcasEsportiva));
        painelPrincipal.add(criarPainelComTabela("Calçados Casuais", tabelaCalcadosCasual));
        painelPrincipal.add(criarPainelComTabela("Calçados Esportivos", tabelaCalcadosEsportiva));

        // Adicionando painel principal ao frame
        frame.add(painelPrincipal, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel criarPainelComTabela(String titulo, JTable tabela) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel(titulo, SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(labelTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        return painel;
    }

    private JTable criarTabelaRoupasCasual(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Tipo Manga", "Gola"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof RoupaCasual) {
                RoupaCasual roupa = (RoupaCasual) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    roupa.getTipoManga(), roupa.getGola()
                });
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaCalcasCasual(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Altura Cintura", "Tipo Fechamento"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof CalcaCasual) {
                CalcaCasual calca = (CalcaCasual) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    calca.getAlturaCintura(), calca.getTipoFechamento()
                });
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaCalcadosCasual(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Altura Cano", "Tipo Fechamento"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof CalcadoCasual) {
                CalcadoCasual calcado = (CalcadoCasual) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    calcado.getAlturaCano(), calcado.getTipoFechamento()
                });
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaRoupasEsportiva(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Antibacteriana", "Leveza/Flexibilidade"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof RoupaEsportiva) {
                RoupaEsportiva roupa = (RoupaEsportiva) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    roupa.getAntibacteriana(), roupa.getLevezaFlexibilidade()
                });
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaCalcasEsportiva(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Tecido Respirável", "Ajuste Flexível"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof CalcaEsportiva) {
                CalcaEsportiva calca = (CalcaEsportiva) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    calca.getTecidoRespiravel(), calca.getAjusteFlexivel()
                });
            }
        }

        return new JTable(model);
    }

    private JTable criarTabelaCalcadosEsportiva(ArrayList<ItemEstoque> listaItensEstoque) {
        String[] colunas = {"ID Produto", "Nome", "Material", "Categoria", "Quantidade", "Estado", "Sola Antiderrapante", "Amortecimento", "Suporte Extra"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (ItemEstoque item : listaItensEstoque) {
            Produto produto = item.getProduto();
            if (produto instanceof CalcadoEsportiva) {
                CalcadoEsportiva calcado = (CalcadoEsportiva) produto;
                model.addRow(new Object[]{
                    produto.getId(), produto.getNome(), produto.getMaterial(),
                    produto.getCategoria(), item.getQuantidade(), item.getStateDescricao(),
                    calcado.isSolaAntiderrapante(), calcado.isAmortecimento(), calcado.isSuporteExtra()
                });
            }
        }

        return new JTable(model);
    }
}
