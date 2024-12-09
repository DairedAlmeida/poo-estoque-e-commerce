package loja.vestuario.pessoa;

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String email;

	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return null;
	}

	public String getCpf() {
		return null;
	}

	public String getEmail() {
		return null;
	}

	public String descricaoPessoa() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
	}

	public abstract String descricao();
}
