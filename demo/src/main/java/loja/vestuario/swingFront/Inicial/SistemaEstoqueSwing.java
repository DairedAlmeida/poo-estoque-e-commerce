package loja.vestuario.swingFront.Inicial;

import loja.vestuario.loja.Estoque;
import loja.vestuario.loja.Loja;

public class SistemaEstoqueSwing {

    public static void main(String[] args) {
        Estoque estoqueAtual = Estoque.getInstancia();
        Loja lojaAtual = Loja.getInstancia("Loja", "Endereço", estoqueAtual);
        new TelaInicial(lojaAtual);
    }
}