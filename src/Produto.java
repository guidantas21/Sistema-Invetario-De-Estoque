public class Produto {
    protected int id = 0;
    protected String nome;
    protected String tipoDeArmazenagem;
    protected String descricao;
    protected Position localizacaoDeProduto;

    public Produto() {

    }

    public Produto(int id, String nome, String tipoDeArmazenagem, String descricao) {
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

    public int getId() {
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
