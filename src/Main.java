
public class Main {
    public static void main(String[] args) {
        Predio predio = new Predio(10, 10);

        Produto teste1 = new Produto(1, "mouse", "normal", "eletronico/perifeirco");
        Produto teste2 = new Produto(2, "Produto2", "Armazenagem2", "Descrição2");

        predio.adicionarProduto(teste1);
        predio.adicionarProduto(teste2);

    }
}
