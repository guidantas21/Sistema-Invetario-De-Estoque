public class Drone extends Dispositivo {

    private boolean verify;

    Drone() {

    }

    Drone(int id, String tipoDeEmbarcado, Position localizcaoInicial, int autonomia, int velocidade) {
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
