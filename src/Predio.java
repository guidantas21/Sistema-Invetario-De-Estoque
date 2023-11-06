import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Predio implements Armazenamento{
    private int largura;
    private int altura;
    private String predioID;
    private Produto[][] matrizDeProdutos;
    private int capacidadeMaxima;
    private int quantidadeDeProdutos = 0;
    private ArrayList<Produto> produtosRecebidos = new ArrayList<Produto>();

    public Predio() {
    }

    public Predio(int largura, int altura, String predioID) {
        this.largura = largura;
        this.altura = altura;
        this.predioID = predioID;
        this.capacidadeMaxima = altura * largura;
        this.matrizDeProdutos = new Produto[largura][altura];
        new File(predioID + ".txt");
        inicializarMatrizProdutos();
    }

    private void inicializarMatrizProdutos() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                matrizDeProdutos[i][j] = new Produto(0, "", "", "");
            }
        }
    }

    @Override
    public void adicionarProduto(Produto produto) {
        if (quantidadeDeProdutos < capacidadeMaxima) {
            for (int i = 0; i < largura; i++) {
                for (int j = 0; j < altura; j++) {
                    if (matrizDeProdutos[i][j].getId() == 0) {
                        System.out.print("teste");
                        matrizDeProdutos[i][j] = produto;
                        produto.setLocalizacaoDeProduto(new Position(i, j, 0));
                        quantidadeDeProdutos++;
                        produtosRecebidos.add(produto);
                        System.out.println("Adicionado");
                        return;
                    }
                }
            }
        }
        System.out.println("Produto não adicionado");
    }

    @Override
    public void retirarProduto(Produto produto) {
        if (produtosRecebidos.contains(produto)) {
            produtosRecebidos.remove(produto);
            quantidadeDeProdutos--;

            Position localizacao = produto.getLocalizacaoDeProduto();
            int x = localizacao.getX();
            int y = localizacao.getY();

            matrizDeProdutos[x][y] = new Produto(0, "", "", ""); // Limpar a posição
            System.out.println("Produto retirado com sucesso.");
        } else {
            System.out.println("Produto não encontrado na lista de produtos recebidos.");
        }
    }

    @Override
    public void moverProduto(Produto produto, Position novaLocalizacao) {
        if (produtosRecebidos.contains(produto)) {
            Position localizacaoAtual = produto.getLocalizacaoDeProduto();
            int xAntigo = localizacaoAtual.getX();
            int yAntigo = localizacaoAtual.getY();
            int xNovo = novaLocalizacao.getX();
            int yNovo = novaLocalizacao.getY();

            if (xAntigo >= 0 && xAntigo < largura && yAntigo >= 0 && yAntigo < altura &&
                    xNovo >= 0 && xNovo < largura && yNovo >= 0 && yNovo < altura) {
                if (matrizDeProdutos[xAntigo][yAntigo] == produto) {
                    matrizDeProdutos[xAntigo][yAntigo] = new Produto(0, "", "", ""); // Limpar a posição antiga
                    matrizDeProdutos[xNovo][yNovo] = produto;
                    produto.setLocalizacaoDeProduto(novaLocalizacao);
                    System.out.println("Produto movido para (" + novaLocalizacao.getX() + ", " + novaLocalizacao.getY() + ", " + novaLocalizacao.getZ() + ")");
                }
            }
        } else {
            System.out.println("Produto não encontrado na lista de produtos recebidos.");
        }
    }


    public boolean apartamentoDisponivel(int linha, int coluna) {
        if (linha >= 0 && linha < largura && coluna >= 0 && coluna < altura) {
            return matrizDeProdutos[linha][coluna] == null;
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
