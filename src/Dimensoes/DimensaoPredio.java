package Dimensoes;

import Dimensoes.Dimensao;

public class DimensaoPredio extends Dimensao {
    private int numAndares;
    private int numApartamentosPorAndar;

    public DimensaoPredio(int largura, int altura, int profundidade, int numAndares, int numApartamentosPorAndar) {
        super(largura, altura, profundidade);
        this.numAndares = numAndares;
        this.numApartamentosPorAndar = numApartamentosPorAndar;
    }

    public int getNumAndares() {
        return numAndares;
    }

    public void setNumAndares(int numAndares) {
        this.numAndares = numAndares;
    }

    public int getNumApartamentosPorAndar() {
        return numApartamentosPorAndar;
    }

    public void setNumApartamentosPorAndar(int numApartamentosPorAndar) {
        this.numApartamentosPorAndar = numApartamentosPorAndar;
    }
}
