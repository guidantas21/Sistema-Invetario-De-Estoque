public class LocalizacaoPredio extends Localizacao {

    private String rua;

    public LocalizacaoPredio(int[] x, int y, String rua) {
        super(x, y);
        this.rua = rua;
    }

    public String getRua () {
        return rua;
    }

    public void setRua (String rua) {
        this.rua = rua;
    }
    /* @Override
    public String toString() {
        return "LocalizacaoPredio{" +
                "x=" + Arrays.toString(x) +
                ", y=" + y +
                ", rua='" + rua + '\'' +
                '}';
    }*/
}
