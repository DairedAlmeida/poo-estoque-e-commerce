package loja.vestuario.loja;
import loja.vestuario.pessoa.Administrador;

public interface SubscriberAdministador {
    public abstract void subscribe(Administrador observer);
    public abstract void unsubscribe(Administrador observer);
    public abstract void notifyObservers(int idProdutoEsgotado, String nomeProdutoEsgotado);
}
