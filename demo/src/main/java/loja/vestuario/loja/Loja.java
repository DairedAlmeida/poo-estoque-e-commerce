package loja.vestuario.loja;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import loja.vestuario.pessoa.Administrador;
import loja.vestuario.pessoa.Cliente;
import loja.vestuario.pessoa.Pessoa;

public class Loja implements Serializable {
	public static Loja instancia;
	private Estoque estoque;
	private String nome;
	private String endereco;
	private ArrayList<Pessoa> listaClientes;
	private ArrayList<Pessoa> listaAdministradores;
    private ArrayList<Pedido> listaPedido;
	
	private Loja(String nome, String endereco, Estoque estoque) {
		this.nome = nome;
		this.endereco = endereco;
		this.estoque = estoque;
        this.listaClientes = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        this.listaPedido = new ArrayList<>();
	}

	public static Loja getInstancia(String nome, String endereco, Estoque estoque) {
		if (instancia == null) {
            if((instancia = carregarLoja()) == null){
                instancia = new Loja(nome, endereco, estoque);
            }
		} 

        return instancia;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pessoa> getListaClientes() {
		return listaClientes;
	}

	public ArrayList<Pessoa> getListaAdministradores() {
		return listaAdministradores;
	}

    public ArrayList<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente adicionado: " + cliente.descricao());
    }

    public void removerCliente(Cliente cliente) {
        if (listaClientes.contains(cliente)) {
            listaClientes.remove(cliente);
            System.out.println("Cliente removido: " + cliente.descricao());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void adicionarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
        System.out.println("Administrador adicionado: " + administrador.descricao());
    }

    public void removerAdministrador(Administrador administrador) {
        if (listaAdministradores.contains(administrador)) {
            listaAdministradores.remove(administrador);
            System.out.println("Administrador removido: " + administrador.descricao());
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    public void exibirClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Pessoa cliente : listaClientes) {
                System.out.println(cliente.descricao());
            }
        }
    }

    public void exibirAdministradores() {
        if (listaAdministradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
        } else {
            System.out.println("Lista de Administradores:");
            for (Pessoa administrador : listaAdministradores) {
                System.out.println(administrador.descricao());
            }
        }
    }

    public void adicionarPedido(Pedido pedido) {
        listaPedido.add(pedido);
        System.out.println("Pedido adicionado: " + pedido.descreverPedido());
    }
	
    public void salvarLoja() {
        String diretorio = "dados";
        String caminhoArquivo = diretorio + File.separator + "loja.dat";

        try {
            // Cria o diretório "dados" se ele não existir
            Files.createDirectories(Paths.get(diretorio));

            // Salva o objeto Loja no arquivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
                oos.writeObject(instancia);
                System.out.println("Loja salva com sucesso no arquivo: " + caminhoArquivo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar loja: " + e.getMessage());
        }
    }

    public static Loja carregarLoja() {
        String caminhoArquivo = "dados" + File.separator + "loja.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            instancia = (Loja) ois.readObject();
            System.out.println("Loja carregada com sucesso do arquivo: " + caminhoArquivo);
            return instancia;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar loja: " + e.getMessage());
            return null;
        }
    }
}
