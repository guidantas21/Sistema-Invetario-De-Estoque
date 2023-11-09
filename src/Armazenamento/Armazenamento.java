package Armazenamento;

import Dimensoes.Dimensao;
import Produto.Produto;

public abstract class Armazenamento {
    protected Dimensao dimensao;
    protected int capacidadeMaxima;
    protected int quantidadeProdutos;

    public Armazenamento() {}

    public Armazenamento(Dimensao dimensao, int capacidadeMaxima) {
        this.dimensao = dimensao;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    abstract public boolean adicionarProduto(Produto produto);

    abstract public Produto removerProduto(Produto produto);
}
