package loja.vestuario.item;
import java.util.ArrayList;
import loja.vestuario.pessoa.Administrador;

public class StateDisponivel extends StateItemEstoque implements Subscriber{

	private ArrayList<Administrador> observers;

	public void remover() {

	}

	public void adicionar() {

	}

	public void changeState() {

	}

	public void NewsChannel() {
        this.observers = new ArrayList<>();
    }

    public void subscribe(Administrador observer) {
        observers.add(observer); // Adiciona um assinante
    }

    public void unsubscribe(Administrador observer) {
        observers.remove(observer); // Remove um assinante
    }

    public void notifyObservers() {
        for (Administrador observer : observers) {
            observer.update("latestNews"); // Envia a notícia para todos os assinantes
        }
    }
}
