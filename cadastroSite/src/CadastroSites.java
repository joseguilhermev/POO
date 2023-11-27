import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Site implements Serializable {
    private static int nextId = 1;
    private int id;
    private String descricao;
    private String url;
    private String dataCadastro;

    public Site(String descricao, String url, String dataCadastro) {
        this.id = nextId++;
        this.descricao = descricao;
        this.url = url;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nDescrição: " + descricao + "\nURL: " + url + "\nData de Cadastro: " + dataCadastro + "\n";
    }
}

public class CadastroSites {
    public static void main(String[] args) {
        List<Site> sites = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("1. Adicionar um site");
            System.out.println("2. Listar todos os sites");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição: ");
                    String descricao = scanner.next();
                    System.out.print("URL: ");
                    String url = scanner.next();
                    System.out.print("Data de Cadastro: ");
                    String dataCadastro = scanner.next();
                    Site site = new Site(descricao, url, dataCadastro);
                    sites.add(site);
                    salvarSite(site);
                    break;
                case 2:
                    listarSites();
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    private static void salvarSite(Site site) {
        String nomeArquivo = site.getId() + ".data";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(site);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listarSites() {
        for (File file : new File(".").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".data")) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Site site = (Site) inputStream.readObject();
                    System.out.println(site);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}