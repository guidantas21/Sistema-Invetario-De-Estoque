public class Produto {
    protected String id;
    protected String nome;
    protected String tipoDeArmazenagem;
    protected String descricao;
    protected Position localizacaoDeProduto;

    public Produto() {
    }

    public Produto(String id, String nome, String tipoDeArmazenagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipoDeArmazenagem = tipoDeArmazenagem;
        this.descricao = descricao;
    }

    public void setProduto(String id, String nome, String tipoDeArmazenagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipoDeArmazenagem = tipoDeArmazenagem;
        this.descricao = descricao;
    }

    public void setLocalizacaoDeProduto(Position localizacaoDeProduto) {
        this.localizacaoDeProduto = localizacaoDeProduto;
    }

    public Position getLocalizacaoDeProduto() {
        return localizacaoDeProduto;
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
