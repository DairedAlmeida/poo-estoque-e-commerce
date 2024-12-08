package loja.vestuario.pessoa;

public class Administrador extends Pessoa implements Observer{
	private int matricula;
    
	public void update(String news) {
        System.out.println("[" + this.nome + "] recebeu a notícia: " + news);
    }
}
