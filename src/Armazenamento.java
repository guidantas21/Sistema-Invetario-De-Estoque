public interface Armazenamento {
    void adicionarProduto(Produto produto);

    void retirarProduto(Produto produto);

    void moverProduto(Produto produto, Position novaLocalizacao);
}