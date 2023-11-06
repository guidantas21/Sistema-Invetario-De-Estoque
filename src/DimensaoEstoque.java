public class DimensaoEstoque extends Dimensao {
    private int numPredios;
    private int numAndaresPredios;
    private int numApartamentosPorAndarPredios;

    public DimensaoEstoque(double largura, double altura, double profundidade, int numPredios, int numAndaresPredios, int numApartamentosPorAndarPredios) {
        super(largura, altura, profundidade);
        this.numPredios = numPredios;
        this.numAndaresPredios = numAndaresPredios;
        this.numApartamentosPorAndarPredios = numApartamentosPorAndarPredios;
    }

    public int getNumPredios() {
        return numPredios;
    }

    public void setNumPredios(int numPredios) {
        this.numPredios = numPredios;
    }

    public int getNumAndaresPredios() {
        return numAndaresPredios;
    }

    public void setNumAndaresPredios(int numAndaresPredios) {
        this.numAndaresPredios = numAndaresPredios;
    }

    public int getNumApartamentosPorAndarPredios() {
        return numApartamentosPorAndarPredios;
    }

    public void setNumApartamentosPorAndarPredios(int numApartamentosPorAndarPredios) {
        this.numApartamentosPorAndarPredios = numApartamentosPorAndarPredios;
    }
}
