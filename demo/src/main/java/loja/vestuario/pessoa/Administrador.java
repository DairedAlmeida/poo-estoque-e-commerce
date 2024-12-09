package loja.vestuario.pessoa;
import loja.vestuario.item.StateDisponivel;

public class Administrador extends Pessoa implements Observer {
    private int matricula;

    public Administrador(String nome, String cpf, String email, int matricula) {
        super(nome, cpf, email);
        this.matricula = matricula;
        StateDisponivel stateDisponivel = new StateDisponivel();
        stateDisponivel.subscribe(this);
    }

    public void update(String news) {
        System.out.println("[" + this.nome + "] recebeu a notícia: " + news);
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