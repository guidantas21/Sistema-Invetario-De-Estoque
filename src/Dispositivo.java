public abstract class Dispositivo {
    protected int id;
    protected String tipoDeEmbarcado;
    protected Position localizacaoInicial;
    protected int autonomia;
    protected int velocidade;

    Dispositivo() {

    }

    Dispositivo(int id, String tipoDeEmbarcado, Position localizacaoInicial, int autonomia, int velocidade) {
        this.id = id;
        this.tipoDeEmbarcado = tipoDeEmbarcado;
        this.localizacaoInicial.x = localizacaoInicial.x;
        this.localizacaoInicial.y = localizacaoInicial.y;
        this.autonomia = autonomia;
        this.velocidade = velocidade;

    }

    public abstract void movimentacaoDispositivo();
}
