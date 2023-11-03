import java.util.Arrays;

public class LocalizacaoProduto extends Localizacao {

    private String rua;
    private Integer andar;
    private String apartamento;

    public LocalizacaoProduto () {

    }

    public LocalizacaoProduto(int [] x, int y, String rua, int andar, String apartamento) {
        super(x, y);
        this.rua = rua;
        this.andar = andar;
        this.apartamento = apartamento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    /*@Override
    public String toString() {
        return "LocalizacaoProduto{" +
                "x=" + Arrays.toString(x) +
                ", y=" + y +
                ", rua='" + rua + '\'' +
                ", andar=" + andar +
                ", apartamento='" + apartamento + '\'' +
                '}';
    }*/


}
