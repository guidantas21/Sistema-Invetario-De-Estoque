import java.util.ArrayList;
import java.util.List;

public class Predio {

    private int largura;
    private int altura;
    private Produto[][] matrizDeProdutos;
    private int capacidadeMaxima;
    private int quantidadeDeProdutos = 0;
    /// private ArrayList<Produto> matrizDeProduto = new ArrayList<>(altura *
    // largura);
    private List<Produto> produtos = new ArrayList<>();

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

    public boolean retirarProduto(Produto produto) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (matrizDeProdutos[i][j].equals(produto)) {
                    matrizDeProdutos[i][j] = new Produto(0, "", "", "");
                    quantidadeDeProdutos--;
                    System.out.println("Produto retirado");
                    return true;
                }
            }
        }
        System.out.println("Produto não encontrado");
        return false;
    }

    public void moverProduto (Produto produto, Position novaLocalizacao) {
        if (produtos.contains(produto)) {
            produto.setLocalizacaoDeProduto(novaLocalizacao);
            System.out.println("Produto "
                    + produto.getNome()
                    + " movido para ("
                    + novaLocalizacao.x
                    + ", "
                    + novaLocalizacao.y
                    + ", "
                    + novaLocalizacao.z + ")");

        } else {
            System.out.println("Produto não encontrado");
        }
    }

    

    public void exibirMatriz() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                Produto produto = matrizDeProdutos[i][j];
                System.out.println("Apartamento: " + i + ", Andar: " + j);
                if (produto != null) {
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Tipo de Armazenagem: " + produto.getTipoDeArmazenagem());
                    System.out.println("Descrição: " + produto.getDescricao());
                } else {
                    System.out.println("Nenhum produto nesta posição.");
                }
                System.out.println("----------------------");
            }
        }
    }


}
