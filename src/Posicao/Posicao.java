package Posicao;

public class Posicao {
    protected int andar;
    protected int apartamento;
    protected int predio;

    public Posicao() {

    }

    public Posicao(int andar, int apartamento, int predio) {
        this.andar = andar;
        this.apartamento = apartamento;
        this.predio = predio;
    }

    public Posicao(int andar, int apartamento) {
        this.andar = andar;
        this.apartamento = apartamento;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

}
