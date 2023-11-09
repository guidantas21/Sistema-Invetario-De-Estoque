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

    public Estoque() {
    }



    public Estoque(DimensaoEstoque dimensao) {
        super(dimensao, dimensao.getNumPredios());

        this.predios = new ArrayList<>(dimensao.getNumApartamentos());
        produtosNoEstoque = new ArrayList<>(capacidadeMaxima);

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

                this.quantidadeProdutos++;
            }
        }
        return false;
    }

    public boolean adicionarProduto(Produto produto, Posicao posicao) {
        if (this.isEstoqueDisponivel()) {
            if (posicao.getPredio() < this.dimensao.getNumPredios()) {
                
            }
        }
        return false;
    }

    public boolean moverProduto(Produto produto) {
        return false;
    }

    public Produto removerProduto(Produto produto) {
        return null;
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

    // Método para acessar a lista de produtos no estoque
    public List<Produto> getProdutosNoEstoque() {
        return produtosNoEstoque;
    }

//    @Override
//    public void adicionarProduto(Produto produto) {
//        if (isEstoqueDisponivel()) {
//            Posicao localizacaoProduto = alocarProduto();
//
//            if (localizacaoProduto != null) {
//                produto.setPosicao(localizacaoProduto);
//                produtosNoEstoque.add(produto);
//
//                predios.get(localizacaoProduto.getPredio()).adicionarProduto(produto);
//
//                quantidadeProdutos++;
//            }
//            System.out.println("Produto adicionado ao estoque com sucesso.");
//        } else {
//            System.out.println("Capacidade máxima do estoque atingida. Não é possível adicionar mais produtos.");
//        }
//    }

//    @Override
//    public void retirarProduto(Produto produto) {
//        if (produtosNoEstoque.remove(produto)) {
//            quantidadeProdutos--;
//            System.out.println("Produto retirado do estoque com sucesso.");
//        } else {
//            System.out.println("Produto não encontrado no estoque.");
//        }
//    }

//    @Override
//    public void moverProdutoPorID(String id, Posicao novaLocalizacao) {
//
//    }

//    @Override
//    public void moverProduto(Produto produto, Posicao novaLocalizacao) {
//        // Verifica se o produto existe no estoque
//        if (produtosNoEstoque.contains(produto)) {
//            Posicao localizacaoAtual = produto.getPosicao();
//            int xAntigo = localizacaoAtual.getAndar();
//            int yAntigo = localizacaoAtual.getApartamento();
//            int zAntigo = localizacaoAtual.getPredio();
//
//            int xNovo = novaLocalizacao.getAndar();
//            int yNovo = novaLocalizacao.getApartamento();
//            int zNovo = novaLocalizacao.getPredio();
//
//            // Verifica se a nova localização é válida dentro da dimensão do estoque
//            if (xNovo >= 0 && xNovo < dimensao.getNumApartamentos() &&
//                    yNovo >= 0 && yNovo < dimensao.getAltura() &&
//                    zNovo >= 0 && zNovo < dimensao.getProfundidade()) {
//                // Remove o produto da localização anterior
//                produtosNoEstoque.remove(produto);
//
//                // Atualiza a localização do produto
//                produto.setPosicao(novaLocalizacao);
//
//                // Adiciona o produto na nova localização
//                produtosNoEstoque.add(produto);
//
//                System.out.println("Produto movido para (" + xNovo + ", " + yNovo + ", " + zNovo + ")");
//            } else {
//                System.out.println("Nova localização inválida. O produto não foi movido.");
//            }
//        } else {
//            System.out.println("Produto não encontrado no estoque. Não é possível movê-lo.");
//        }
//    }

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
        System.out.println("Quantidade total de produtos no estoque: " + quantidadeProdutos);
    }

//    @Override
//    public void moverProduto(Produto produto, Posicao novaLocalizacao, Predio predio) {
//
//        for (Iterator<ArrayList<Produto>> itA = predio.getMatrizDeProdutos().iterator(); itA.hasNext();) {
//
//            // Verifica se o produto existe no estoque
//            if (itA.next().contains(produto)) {
//                Posicao localizacaoAtual = produto.getLocalizacaoDeProduto();
//
//                int xNovo = novaLocalizacao.getX();
//                int yNovo = novaLocalizacao.getY();
//                int zNovo = novaLocalizacao.getZ();
//
//                // Verifica se a nova localização é válida dentro da dimensão do estoque
//                if (xNovo >= 0 && xNovo < dimensao.getNumApartamentos() &&
//                        yNovo >= 0 && yNovo < dimensao.getAltura() &&
//                        zNovo >= 0 && zNovo < dimensao.getProfundidade()) {
//                    // Remove o produto da localização anterior
//                    produtosNoEstoque.remove(produto);
//
//                    // Atualiza a localização do produto
//                    produto.setLocalizacaoDeProduto(novaLocalizacao);
//
//                    // Adiciona o produto na nova localização
//                    predio.adicionarProduto(produto);
//
//                    System.out.println("Produto movido para (" + xNovo + ", " + yNovo + ", " + zNovo + ")");
//                } else {
//                    System.out.println("Nova localização inválida. O produto não foi movido.");
//                }
//            } else {
//                System.out.println("Produto não encontrado no estoque. Não é possível movê-lo.");
//            }
//        }
//    }

}