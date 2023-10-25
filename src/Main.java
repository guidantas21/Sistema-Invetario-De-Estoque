public class Main {
    public static void main(String[] args) {
        Predio predio = new Predio(10, 10);

        Produto teste1 = new Produto(1, "mouse", "normal", "eletronico/perifeirco");
        Produto teste2 = new Produto(2, "Produto2", "Armazenagem2", "Descrição2");

        predio.adicionarProduto(teste1);
        predio.adicionarProduto(teste2);

        System.out.println("Matriz de produtos antes de mover:");
        predio.exibirMatriz();

        Position novaLocalizacao = new Position(15, 25, 35);

        predio.moverProduto(teste1, novaLocalizacao);

        System.out.println("Matriz de produtos após mover:");
        predio.exibirMatriz();


    }
}
