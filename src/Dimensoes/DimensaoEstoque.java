package Dimensoes;

public class DimensaoEstoque extends Dimensao {
    private int numPredios;

    public DimensaoEstoque(int numApartamentos, int numAndares, int numPredios) {
        super(numApartamentos, numAndares);
        this.numPredios = numPredios;
    }

    public int getNumPredios() {
        return numPredios;
    }

    public void setNumPredios(int numPredios) {
        this.numPredios = numPredios;
    }

    @Override
    public int getCapacidadeMaxima() {
        return this.numPredios * this.numAndares * this.numApartamentos;
    }
}
