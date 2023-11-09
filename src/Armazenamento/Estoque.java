package Armazenamento;

import Dimensoes.DimensaoEstoque;
import Dimensoes.DimensaoPredio;
import Produto.*;
import Posicao.*;

import Dimensoes.Dimensao;

import java.util.ArrayList;
import java.util.List;

public class Estoque extends Armazenamento {
    DimensaoEstoque dimensao;
    private ArrayList<Predio> predios;
    private ArrayList<Produto> produtosNoEstoque;

    public Estoque() {}

    public Estoque(DimensaoEstoque dimensao) {
        this.capacidadeMaxima = dimensao.getCapacidadeMaxima();

        this.predios = new ArrayList<>(dimensao.getNumApartamentos());
        this.produtosNoEstoque = new ArrayList<>(capacidadeMaxima);
        this.dimensao = dimensao;

        for (int i = 0; i < this.dimensao.getNumPredios(); i++) {
            Predio novoPredio = new Predio(
                    new DimensaoPredio(this.dimensao.getNumAndares(), this.dimensao.getNumApartamentos()),
                    "predio#" + i
            );
            this.predios.add(novoPredio);
        }
    }

    @Override
    public boolean adicionarProduto(Produto produto) {
        if (this.isEstoqueDisponivel()) {
            Posicao localizacaoProduto = this.alocarProduto();

            if (localizacaoProduto != null) {
                produto.setPosicao(localizacaoProduto);
                this.produtosNoEstoque.add(produto);

                this.predios.get(localizacaoProduto.getPredio()).adicionarProduto(produto);

                return true;
            }
        }
        return false;
    }

    public boolean adicionarProduto(Produto produto, Posicao posicao) {
        if (this.isEstoqueDisponivel()) {
            if (posicao.getPredio() < this.dimensao.getNumPredios()) {
                boolean sucesso = this.predios.get(posicao.getPredio()).adicionarProduto(produto, posicao);

                if (sucesso) {
                    this.produtosNoEstoque.add(produto);

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Produto removerProduto(Produto produto) {
        Produto produtoRemovido = this.predios.get(produto.getPosicao().getPredio()).removerProduto(produto);

        if (produtoRemovido != null) {
            this.produtosNoEstoque.remove(produto);

        }

        return produtoRemovido;
    }

    public boolean moverProduto(Produto produto, Posicao posicao) {
        if (this.removerProduto(produto) != null) {
            boolean sucesso = adicionarProduto(produto, posicao);

            if (sucesso) {
                produto.setPosicao(posicao);
                return true;
            }
        }
        return false;
    }

    public Posicao alocarProduto() {
        for (int i = 0; i < this.dimensao.getNumPredios(); i++) {
            Posicao localizacaoPredio = predios.get(i).getLocalizacaoDisponivel();

            if (localizacaoPredio != null) {
                return new Posicao(localizacaoPredio.getAndar(), localizacaoPredio.getApartamento(), i);
            }
        }
        return null;
    }

    public boolean isEstoqueDisponivel() {
        return this.quantidadeProdutos < this.capacidadeMaxima;
    }

    public void fazerInventarioDeProdutos() {
        System.out.println("Inventário de Produtos no Armazenamento.Estoque:");
        for (Produto produto : produtosNoEstoque) {
            if (produto.getId() != null) {
                System.out.println("ID: " + produto.getId());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Tipo de Armazenagem: " + produto.getTipoDeArmazenagem());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Andar: " + produto.getPosicao().getAndar());
                System.out.println("Apartamento: " + produto.getPosicao().getApartamento());
                System.out.println("Predio: " + produto.getPosicao().getPredio());

                System.out.println("----------------------");
            }
        }
        System.out.println("Quantidade total de produtos no estoque: " + this.getQuantidadeDeProdutosRegistrados());
    }

    @Override
    public DimensaoEstoque getDimensao() {
        return dimensao;
    }

    public ArrayList<Produto> getProdutosNoEstoque() {
        return produtosNoEstoque;
    }

    public int getQuantidadeDeProdutosRegistrados() { return produtosNoEstoque.size(); }
}