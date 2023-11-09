package Dimensoes;

import Dimensoes.Dimensao;

public class DimensaoPredio extends Dimensao {
    public DimensaoPredio(int numAndares, int numApartamentos) {
        super(numAndares, numApartamentos);
    }

    @Override
    public int getCapacidadeMaxima() {
        return this.numAndares * this.numApartamentos;
    }
}
