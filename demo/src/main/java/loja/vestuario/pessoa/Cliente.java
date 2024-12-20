package loja.vestuario.pessoa;

public class Cliente extends Pessoa {

	static private int numeroClientes = 0;
	private int idCadastro;

	public Cliente(String nome, String cpf, String email) {
		super(nome, cpf, email);
		Cliente.numeroClientes++;
		this.idCadastro = Cliente.numeroClientes;
	}

	public int getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}

	public static int getNumeroClientes() {
		return numeroClientes;
	}

	public static void setNumeroClientes(int numeroClientes) {
		Cliente.numeroClientes = numeroClientes;
	}

	public String descricao() {
		return "Cliente [idCadastro=" + idCadastro + ", descricaoPessoa()=" + descricaoPessoa() + "]";
	}

	public String toString() {
        return "ID: " + idCadastro + " - Nome: " + nome;
    }
}
