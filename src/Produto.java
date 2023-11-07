public class Produto extends Position {
    protected String id;
    protected String nome;
    protected String tipoDeArmazenagem;
    protected String descricao;
    protected Position localizacaoDeProduto;

    public Produto() {
        super();
    }

    public Produto(String id, String nome, String tipoDeArmazenagem, String descricao, int x, int y, int z) {
        super(x, y, z);
        this.id = id;
        this.nome = nome;
        this.tipoDeArmazenagem = tipoDeArmazenagem;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoDeArmazenagem() {
        return tipoDeArmazenagem;
    }

    public String getDescricao() {
        return descricao;
    }

}
