package Dispositivos;

import Posicao.Posicao;

public abstract class Dispositivo {
    protected int id;
    protected String tipoDeEmbarcado;
    protected Posicao localizacaoInicial;
    protected int autonomia;
    protected int velocidade;

    public Dispositivo() {

    }

    public Dispositivo(int id, String tipoDeEmbarcado, Posicao localizacaoInicial, int autonomia, int velocidade) {
        this.id = id;
        this.tipoDeEmbarcado = tipoDeEmbarcado;
        this.localizacaoInicial.x = localizacaoInicial.x;
        this.localizacaoInicial.y = localizacaoInicial.y;
        this.autonomia = autonomia;
        this.velocidade = velocidade;

    }

    public abstract void movimentacaoDispositivo();
}
