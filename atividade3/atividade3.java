package atividade3;


import java.util.Scanner;
import java.util.ArrayList;

public class atividade3 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Estoque estoque = new Estoque();

        // Loop de interação com o usuário
        while (true) {
            System.out.println("\nEscolha uma das alternativas:");
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Atualizar");
            System.out.println("4. Listar");
            System.out.println("5. Sair");
            int escolha = scnr.nextInt();
            scnr.nextLine(); // Consumir quebra de linha

            //Opções do menu
            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scnr.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int qtd = scnr.nextInt();
                    estoque.adicionarItem(nome, qtd);
                    break;
                case 2:
                    System.out.print("Digite o item a ser removido: ");
                    String itemRemover = scnr.nextLine();
                    estoque.removerItem(itemRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do item a ser atualizado: ");
                    String atualizador = scnr.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQtd = scnr.nextInt();
                    estoque.atualizarQtd(atualizador, novaQtd);
                    break;
                case 4:
                    estoque.listar();
                    break;
                case 5:
                    System.out.println("fechando o programa.");
                    scnr.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }
    }

    public static class ItemEstoque {
        private String nome;
        private int qtd;

        // Construtor para criar um novo item
        public ItemEstoque(String nome, int qtd) {
            this.nome = nome;
            this.qtd = qtd;
        }

        // Métodos para acessar informações
        public String getNome() {
            return nome;
        }

        public int getQtd() {
            return qtd;
        }

        public void setQtd(int qtd) {
            this.qtd = qtd;
        }
    }

    public static class Estoque {
        private ArrayList<ItemEstoque> itens;

        // Construtor para iniciar o estoque
        public Estoque() {
            itens = new ArrayList<>();
        }

        // Adiciona um novo item
        public void adicionarItem(String nome, int qtd) {
            itens.add(new ItemEstoque(nome, qtd));
        }

        // Remove um item
        public void removerItem(String nome) {
            ItemEstoque itemParaRemover = null;
            for (ItemEstoque item : itens) {
                if (item.getNome().equals(nome)) {
                    itemParaRemover = item;
                    break;
                }
            }
            if (itemParaRemover != null) {
                itens.remove(itemParaRemover);
            }
        }

        // Atualiza a quantidade de um item buscando seu nome
        public void atualizarQtd(String nome, int novaQtd) {
            for (ItemEstoque item : itens) {
                if (item.getNome().equals(nome)) {
                    item.setQtd(novaQtd);
                    break;
                }
            }
        }

        // Lista todos os itens
        public void listar() {
            System.out.println("Itens no estoque:");
            for (ItemEstoque item : itens) {
                System.out.println("Nome: " + item.getNome() + ", Quantidade: " + item.getQtd());
            }
        }
    }
}