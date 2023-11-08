package Dimensoes;

public abstract class Dimensao {
    private int largura;
    private int altura;
    private int profundidade;

    public Dimensao(int largura, int altura, int profundidade) {
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getVolume() {
        return altura * largura * profundidade;
    }
}
