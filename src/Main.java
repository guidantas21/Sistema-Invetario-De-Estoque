public class Main {
    public static void main(String[] args) {
        Produto teste = new Produto(1, "mouse", "normal", "eletronico/perifeirco");
        Predio predio = new Predio(10, 10);
        predio.adicionarProduto(teste);
    }
}
