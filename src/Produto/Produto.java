package Produto;

import Posicao.Posicao;

public class Produto extends Posicao {
    protected String id;
    protected String nome;
    protected String tipoDeArmazenagem;
    protected String descricao;
    protected Posicao posicao;

    public Produto() {
        super();
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

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
}
