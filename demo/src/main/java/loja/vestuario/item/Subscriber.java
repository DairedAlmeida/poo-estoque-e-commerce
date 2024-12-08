package loja.vestuario.item;
import loja.vestuario.pessoa.Administrador;

public interface Subscriber {
    public abstract void subscribe(Administrador observer);
    public abstract void unsubscribe(Administrador observer);
    public abstract void notifyObservers();
}
