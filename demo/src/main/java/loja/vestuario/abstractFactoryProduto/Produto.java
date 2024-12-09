package loja.vestuario.abstractFactoryProduto;

public abstract class Produto {

    static private int numeroProdutos = 0;
	private int id;
    protected String nome;
    protected String material;
    protected String escalaConforto;
    protected String categoria;

    public Produto(String nome, String material, String escalaConforto) {
        Produto.numeroProdutos++;
        this.id = Produto.numeroProdutos;
        this.nome = nome;
        this.material = material;
        this.escalaConforto = escalaConforto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEscalaConforto() {
        return escalaConforto;
    }

    public void setEscalaConforto(String escalaConforto) {
        this.escalaConforto = escalaConforto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String descricaoProduto() {
        return "Produto [id=" + id + ", nome=" + nome + ", material=" + material + ", escalaConforto=" + escalaConforto
                + ", categoria=" + categoria + "]";
    }

    public abstract String descricao();
}