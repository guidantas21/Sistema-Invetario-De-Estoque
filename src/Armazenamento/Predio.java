package Armazenamento;

import Dimensoes.DimensaoPredio;
import Produto.*;

import java.util.ArrayList;

import Posicao.Posicao;

public class Predio extends Armazenamento {
    private String predioID;
    private ArrayList<ArrayList<Produto>> matrizDeProdutos = new ArrayList<ArrayList<Produto>>();

    public Predio() {}

    public Predio(DimensaoPredio dimensao, String predioID) {
        super(dimensao, dimensao.getNumAndares() * dimensao.getNumApartamentos());
        this.predioID = predioID;

        inicializarMatrizProdutos();
    }

    public String getPredioID() {
        return predioID;
    }

    @Override
    public boolean adicionarProduto(Produto produto) {
        if (this.predioDisponivel()) {
            for (int i = 0; i < this.dimensao.getNumAndares(); i++) {
                for (int j = 0; j < this.dimensao.getNumApartamentos(); j++) {
                    if (this.matrizDeProdutos.get(i).get(j) == null) {
                        this.matrizDeProdutos.get(i).set(j, produto);
                        this.quantidadeProdutos++;

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean adicionarProduto(Produto produto, Posicao posicao) {
        if (this.predioDisponivel()) {
            if (this.matrizDeProdutos.get(posicao.getAndar()).get(posicao.getApartamento()) == null) {
                this.matrizDeProdutos.get(posicao.getAndar()).set(posicao.getApartamento(), produto);
                this.quantidadeProdutos++;
            }
            return true;
        }

        return false;
    }

    @Override
    public Produto removerProduto(Produto produto) {
        for (int i = 0; i < this.dimensao.getNumAndares(); i++) {
            for (int j = 0; j < this.dimensao.getNumApartamentos(); j++) {
                if (this.matrizDeProdutos.get(i).get(j) == produto) {
                    this.matrizDeProdutos.get(i).set(j, null);
                    this.quantidadeProdutos--;

                    return produto;
                }
            }
        }
        return null;
    }

    private void inicializarMatrizProdutos() {
        matrizDeProdutos = new ArrayList<>();

        for (int i = 0; i < this.dimensao.getNumAndares(); i++) {
            ArrayList<Produto> row = new ArrayList<>();
            for (int j = 0; j < this.dimensao.getNumApartamentos(); j++) {
                row.add(null);
            }
            matrizDeProdutos.add(row);
        }
    }

    public boolean predioDisponivel() {
        return this.quantidadeProdutos < this.capacidadeMaxima;
    }

    public Posicao getLocalizacaoDisponivel() {
        if (predioDisponivel()) {
            for (int i = 0; i < this.dimensao.getNumAndares(); i++) {
                for (int j = 0; j < this.dimensao.getNumApartamentos(); j++) {
                    if (matrizDeProdutos.get(i).get(j) == null) {
                        return new Posicao(i, j);
                    }
                }
            }
        }
        return null;
    }
}
