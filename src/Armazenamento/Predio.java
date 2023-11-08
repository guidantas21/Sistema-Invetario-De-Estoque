package Armazenamento;

import Produto.*;

import java.util.ArrayList;

import Posicao.Posicao;

//import java.io.BufferedReader;
import java.io.File;
import java.util.Objects;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;

public class Predio extends Produto implements Armazenamento {
    private int largura;
    private int altura;
    private String predioID;
    private ArrayList<ArrayList<Produto>> matrizDeProdutos = new ArrayList<ArrayList<Produto>>();
    private int capacidadeMaxima;
    private int quantidadeDeProdutos = 0;

    public Predio() {
    }

    public Predio(int largura, int altura, String predioID) {
        this.largura = largura;
        this.altura = altura;
        this.predioID = predioID;
        this.capacidadeMaxima = altura * largura;

        inicializarMatrizProdutos();

        new File(predioID + ".txt");
    }

    private void inicializarMatrizProdutos() {
        matrizDeProdutos = new ArrayList<>();

        for (int i = 0; i < largura; i++) {
            ArrayList<Produto> row = new ArrayList<>();
            for (int j = 0; j < altura; j++) {
                row.add(null);
            }
            matrizDeProdutos.add(row);
        }
    }

    public boolean predioDisponivel() {
        return this.quantidadeDeProdutos < this.capacidadeMaxima;
    }

    public Posicao getLocalizacaoDisponivel() {
        if (predioDisponivel()) {
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (matrizDeProdutos.get(i).get(j) == null) {
                        return new Posicao(i, j, 0);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        if (predioDisponivel()) {
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (matrizDeProdutos.get(i).get(j) == null) {
                        matrizDeProdutos.get(i).set(j, produto);
                        return;
                    }
                }
            }
            System.out.println("Produto Adicionado no predio.");
        } else {
            System.out.println("Predio cheio.");
        }
    }

    public void adicionarProdutoEmPosicao(Produto produto, Posicao posicao) {
        if (predioDisponivel()) {
            if (matrizDeProdutos.get(posicao.getAndar()).get(posicao.getApartamento()) == null ) {
                matrizDeProdutos.get(posicao.getAndar()).set(posicao.getApartamento(), produto);
            }
            System.out.println("Produto Adicionado no predio.");
        } else {
            System.out.println("Predio cheio.");
        }
    }

    @Override
    public void retirarProduto(Produto produto) {
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if (matrizDeProdutos.get(i).get(j) == produto) {
                    matrizDeProdutos.get(i).set(j, null);
                    quantidadeDeProdutos--;
                    System.out.println("Produto retirado com sucesso.");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado na matriz de produtos.");
    }

    public Produto retirarProdutoPorID(String id) {
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if (Objects.equals(matrizDeProdutos.get(i).get(j).getId(), id)) {
                    Produto produtoRetirado = matrizDeProdutos.get(i).get(j);
                    matrizDeProdutos.get(i).set(j, null);
                    quantidadeDeProdutos--;
                    System.out.println("Produto retirado com sucesso.");

                    return produtoRetirado;
                }
            }
        }
        System.out.println("Produto não encontrado na matriz de produtos.");
        return null;
    }

//    @Override
//    public void moverProduto(Produto produto, Posicao novaLocalizacao) {
//        // if (produtosRecebidos.contains(produto)) {
//        // Position localizacaoAtual = produto.getPosicao();
//        // int xAntigo = localizacaoAtual.getAndar();
//        // int yAntigo = localizacaoAtual.getApartamento();
//        // int xNovo = novaLocalizacao.getAndar();
//        // int yNovo = novaLocalizacao.getApartamento();
//        //
//        // if (xAntigo >= 0 && xAntigo < largura && yAntigo >= 0 && yAntigo < altura &&
//        // xNovo >= 0 && xNovo < largura && yNovo >= 0 && yNovo < altura) {
//        // if (matrizDeProdutos[xAntigo][yAntigo] == produto) {
//        // matrizDeProdutos[xAntigo][yAntigo] = new Produto(0, "", "", ""); // Limpar a
//        // posição antiga
//        // matrizDeProdutos[xNovo][yNovo] = produto;
//        // produto.setPosicao(novaLocalizacao);
//        // System.out.println("Produto movido para (" + novaLocalizacao.getAndar() + ",
//        // " +
//        // novaLocalizacao.getApartamento() + ", " + novaLocalizacao.getPredio() + ")");
//        // }
//        // }
//        // } else {
//        // System.out.println("Produto não encontrado na lista de produtos recebidos.");
//        // }
//    }

    public boolean apartamentoDisponivel(int linha, int coluna) {
        if (linha >= 0 && linha < largura && coluna >= 0 && coluna < altura) {
            return matrizDeProdutos.get(linha).get(coluna) == null;
        } else {
            System.out.println("Posição inválida.");
            return false;
        }
    }

    @Override
    public void moverProduto(Produto produto, Posicao novaPosicao) {
        if (quantidadeDeProdutos < capacidadeMaxima) {
            for (int i = 0; i < matrizDeProdutos.size(); i++) {
                for (int j = 0; j < matrizDeProdutos.get(i).size(); j++) {
                    if (matrizDeProdutos.get(i).get(j).getId().equals("0")) {
                        matrizDeProdutos.get(i).set(j, produto);
                        produto.setPosicao(novaPosicao);
//                        quantidadeDeProdutos++;
                    }
                }
            }
        }

    }
    //
//    public void escreverBackupPredio(String id, Produto[][] matrizDeProdutos) {
//        String arquivo = id + ".txt";
//
//        try (FileOutputStream arquivoBackupEscrita = new FileOutputStream(arquivo)) {
//
//            for (int i = 0; i < altura; i++) {
//                for (int j = 0; j < largura; j++) {
//                    String infoToBackup = matrizDeProdutos[i][j].getId() +
//                            "\n" + matrizDeProdutos[i][j].getNome() +
//                            "\n" + matrizDeProdutos[i][j].getTipoDeArmazenagem() +
//                            "\n" + matrizDeProdutos[i][j].getDescricao() +
//                            "\n" + String.valueOf(matrizDeProdutos[i][j].getAndar()) +
//                            "\n" + String.valueOf(matrizDeProdutos[i][j].getApartamento()) +
//                            "\n" + String.valueOf(matrizDeProdutos[i][j].getPredio()) +
//                            "\n";
//
//                    byte[] bytes = infoToBackup.getBytes();
//
//                    arquivoBackupEscrita.write(bytes);
//
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    //
//     public void lerBackupPredio(String id) {
//     String arquivo = id + ".txt";
//
//     try {
//     FileReader fileReader = new FileReader(arquivo);
//     BufferedReader buffereadReader = new BufferedReader(fileReader);
//
//     String[] linha = new String[7];
//     Produto produto;
//
//     for (int i = 0; i < 5; i++) {
//     while ((linha[i] = buffereadReader.readLine()) != null)
//     ;
//     }
//     produto = new Produto(linha[0],
//     linha[1],
//     linha[2],
//     linha[3],
//     Integer.parseInt(linha[4]),
//     Integer.parseInt(linha[5]),
//     Integer.parseInt(linha[6]));
//
//     adicionarProduto(produto);
//
//     buffereadReader.close();
//     fileReader.close();
//     } catch (IOException e) {
//     e.printStackTrace();
//     }
//     }
//
//     public boolean preencherEspacoVazioComProduto(Produto produto) {
//     if (quantidadeDeProdutos < capacidadeMaxima) {
//     for (int i = 0; i < matrizDeProdutos.size(); i++) {
//     ArrayList<Produto> andar = matrizDeProdutos.get(i);
//     for (int j = 0; j < andar.size(); j++) {
//     Produto espaco = andar.get(j);
//     if (espaco.getId().equals("0")) {
//     andar.set(j, produto);
//     produto.setPosicao(new Posicao(i, j, 0));
//     quantidadeDeProdutos++;
//     return true;
//     }
//     }
//     }
//     }
//     return false;
//     }
}
