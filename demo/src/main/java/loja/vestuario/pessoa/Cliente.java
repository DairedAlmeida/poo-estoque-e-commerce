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

	public String descricao() {
		return "Cliente [idCadastro=" + idCadastro + ", descricaoPessoa()=" + descricaoPessoa() + "]";
	}
}
