package Dispositivos;

import Posicao.Posicao;

public abstract class Dispositivo extends Posicao {
    protected int id;
    protected String tipoDeEmbarcado;
    protected Posicao localizacaoInicial;
    protected int autonomia;
    protected int velocidade;

    public Dispositivo() {

    }

    public Dispositivo(int id, String tipoDeEmbarcado, Posicao localizacaoInicial, int autonomia, int velocidade) {
        super(localizacaoInicial.getX(), localizacaoInicial.getY(), localizacaoInicial.getZ());
        this.id = id;
        this.tipoDeEmbarcado = tipoDeEmbarcado;
        this.autonomia = autonomia;
        this.velocidade = velocidade;

    }

    public abstract void movimentacaoDispositivo();
}
