import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Predio {
    private int largura;
    private int altura;
    private String predioId;
    private Produto[][] matrizDeProdutos;
    private int capacidadeMaxima;
    private int quantidadeDeProdutos = 0;
    private ArrayList<Produto> produtosRecebidos = new ArrayList<Produto>();

    public Predio() {
    }

    public Predio(int altura, int largura, String predioId) {
        this.altura = altura;
        this.largura = largura;
        this.predioId = predioId;
        this.capacidadeMaxima = altura * largura;
        this.matrizDeProdutos = new Produto[altura][largura];
        new File(predioId + ".txt");
        inicializarMatrizProdutos();
    }

    private void inicializarMatrizProdutos() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                matrizDeProdutos[i][j] = new Produto("0", "", "", "");
            }
        }
    }

    public boolean adicionarProduto(Produto produto) {
        if (quantidadeDeProdutos < capacidadeMaxima) {
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (matrizDeProdutos[i][j].getId() == "0") {
                        System.out.print("teste");
                        matrizDeProdutos[i][j] = produto;
                        quantidadeDeProdutos++;
                        System.out.println("Adicionado");
                        return true;
                    }
                }
            }
        }
        System.out.println("Produto não adicionado");
        return false;
    }

    public boolean retirarProduto(Produto produto) {
        if (produtosRecebidos.remove(produto)) {
            quantidadeDeProdutos--;
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (matrizDeProdutos[i][j] == produto) {
                        matrizDeProdutos[i][j] = new Produto("0", "", "", "");
                        System.out.println("Produto retirado");
                        return true;
                    }
                }
            }
        }
        System.out.println("Produto não encontrado");
        return false;
    }

    public void moverProduto(Produto produto, Position novaLocalizacao) {
        if (produtosRecebidos.contains(produto)) {
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

    public boolean apartamentoDisponivel(int linha, int coluna) {
        if (linha >= 0 && linha < altura && coluna >= 0 && coluna < largura) {
            return matrizDeProdutos[linha][coluna].getId() == "0";
        } else {
            System.out.println("Posição inválida.");
            return false;
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

    public void escreverBackupPredio(String id, Produto[][] matrizDeProdutos) {
        String arquivo = id + ".txt";

        try (FileOutputStream arquivoBackupEscrita = new FileOutputStream(arquivo)) {

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    String infoToBackup = matrizDeProdutos[i][j].getId() +
                            "\n" + matrizDeProdutos[i][j].getNome() +
                            "\n" + matrizDeProdutos[i][j].getTipoDeArmazenagem() +
                            "\n" + matrizDeProdutos[i][j].getDescricao();
                    byte[] bytes = infoToBackup.getBytes();

                    arquivoBackupEscrita.write(bytes);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void lerBackupPredio(String id) {
        String arquivo = id + ".txt";

        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader buffereadReader = new BufferedReader(fileReader);

            String[] linha = new String[4];
            Produto produto;

            for (int i = 0; i < 4; i++) {

                while ((linha[i] = buffereadReader.readLine()) != null)
                    ;
            }
            produto = new Produto(linha[0], linha[1], linha[2], linha[3]);
            adicionarProduto(produto);

            buffereadReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
