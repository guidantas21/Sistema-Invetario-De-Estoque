public abstract class Produto {
    protected int id;
    protected String nome;
    protected String tipoDeArmazenagem;
    protected String descricao;
    protected Position localizacaoDeProduto;

    Produto() {

    }

    Produto(int id, String nome, String tipoDeArmazenagem, String descricao) {
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

}
