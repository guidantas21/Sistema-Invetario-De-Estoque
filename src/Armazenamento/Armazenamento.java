package Armazenamento;

import Posicao.*;
import Produto.Produto;

public interface Armazenamento {
    void adicionarProduto(Produto produto);

    void retirarProduto(Produto produto);

    void moverProduto(Produto produto, Posicao novaLocalizacao);
}