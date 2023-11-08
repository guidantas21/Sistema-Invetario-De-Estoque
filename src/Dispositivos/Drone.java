package Dispositivos;

import Dispositivos.Dispositivo;
import Posicao.Posicao;
import Simulador.*;

public class Drone extends Dispositivo {

    private boolean verify;

    public Drone() {

    }

    public Drone(int id, String tipoDeEmbarcado, Posicao localizcaoInicial, int autonomia, int velocidade) {
        super(id, tipoDeEmbarcado, localizcaoInicial, autonomia, velocidade);

    }

    private void setStateSearch(boolean verify) {
        this.verify = verify;
    }

    private boolean getStateSearch() {
        return verify;
    }

    protected void leituraRFID(int rfidDoProduto) {
        Simulador leitura = new Simulador();
        if (leitura.generetorId() == rfidDoProduto) {
            setStateSearch(true);
        } else {
            leituraRFID(rfidDoProduto);
        }
    }

    public void movimentacaoDispositivo() {

    }
}
