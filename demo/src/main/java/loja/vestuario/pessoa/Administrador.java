package loja.vestuario.pessoa;

import javax.swing.JOptionPane;

import loja.vestuario.loja.Estoque;

public class Administrador extends Pessoa implements Observer {
    private int matricula;

    public Administrador(String nome, String cpf, String email, int matricula) {
        super(nome, cpf, email);
        this.matricula = matricula;
        Estoque.getInstancia().subscribe(this);
    }

    public void update(String news) {
        System.out.println(news);
        JOptionPane.showMessageDialog(null, news, "Notificação de Estoque Aos Administrador", JOptionPane.INFORMATION_MESSAGE);
    }

    public String descricao() {
        return "Administrador [matricula=" + matricula + ", descricaoPessoa()=" + descricaoPessoa() + "]";
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}