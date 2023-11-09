package Dimensoes;

public abstract class Dimensao {
    protected int numApartamentos;
    protected int numAndares;

    public Dimensao() {}
    public Dimensao(int numApartamentos, int numAndares) {
        this.numApartamentos = numApartamentos;
        this.numAndares = numAndares;
    }

    abstract public int getCapacidadeMaxima();

    public int getNumApartamentos() {
        return numApartamentos;
    }

    public void setNumApartamentos(int numApartamentos) {
        this.numApartamentos = numApartamentos;
    }

    public int getNumAndares() {
        return numAndares;
    }

    public void setNumAndares(int numAndares) {
        this.numAndares = numAndares;
    }
}
