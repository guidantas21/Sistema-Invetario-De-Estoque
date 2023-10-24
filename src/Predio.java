// import java.util.ArrayList;

public class Predio {

    private int largura;
    private int altura;
    private Produto[][] matrizDeProdutos;
    private int capacidadeMaxima;
    private int quantidadeDeProdutos = 0;
    // private ArrayList<Produto> matrizDeProduto = new ArrayList<>(altura *
    // largura);

    public Predio() {

    }

    public Predio(int a, int l) {
        altura = a;
        largura = l;
        matrizDeProdutos = new Produto[altura][largura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                matrizDeProdutos[i][j] = new Produto(0, "", "", "");
            }
        }

        capacidadeMaxima = largura * altura;
    }

    public boolean adicionarProduto(Produto produto) {
        if (quantidadeDeProdutos < capacidadeMaxima) {
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (matrizDeProdutos[i][j].getId() == 0) {
                        System.out.print("teste");
                        matrizDeProdutos[i][j] = produto;
                        quantidadeDeProdutos++;
                        System.out.println("Adicionado");
                        return true;
                    }

                }
            }
        }
        System.out.println("nao adicionado");
        return false;
    }

}
