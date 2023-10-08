public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque(1);
        Estante estante = new Estante(0, 3,3,1,1);

        Produto produto = new Produto(0,"Test","Test");

        Pacote pacote = new Pacote(produto, 4);

        PosicaoEstante posicaoEstante1 = new PosicaoEstante(0,0);
        PosicaoEstante posicaoEstante2 = new PosicaoEstante(0,1);
        PosicaoEstante posicaoEstante3 = new PosicaoEstante(1,0);
        PosicaoEstante posicaoEstante4 = new PosicaoEstante(1,1);

        estante.adicionarPacote(pacote, posicaoEstante1);
        estante.adicionarPacote(pacote, posicaoEstante2);
        estante.adicionarPacote(pacote, posicaoEstante3);
        estante.adicionarPacote(pacote, posicaoEstante4);

        estoque.adicionarEstante(estante);
    }
}
