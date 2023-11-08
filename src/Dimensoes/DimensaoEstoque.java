package Dimensoes;

public class DimensaoEstoque extends Dimensao {
    private int numPredios;
    private int numAndares;
    private int numApartamentos;

    public DimensaoEstoque(int numApartamentos, int numAndares, int numPredios) {
        super(numApartamentos, numAndares, numPredios);
    }

}
