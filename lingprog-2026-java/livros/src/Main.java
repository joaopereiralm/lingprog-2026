import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void criartabela(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS livros(" +
                "id SERIAL PRIMARY KEY, "+
                "titulo TEXT NOT NULL, " +
                "autor TEXT NOT NULL," +
                "ano INTEGER NOT NULL, " +
                "disponivel INTEGER DEFAULT 1)";

        //Cria objeto de intruçao SQL
        Statement stmt = conn.createStatement();
        stmt.execute(sql);//EXECUTA O COMANDO SQL
        System.out.println("tabela criada");
        stmt.close();// Fecha intruçao SQL

    }

    public static void cadastrarLivro(Connection conn, Scanner sc) throws SQLException {

        // ENTRADA DE DADOS
        System.out.println("Informe o titulo do livro: ");
        String titulo = sc.nextLine();
        System.out.println("Informe o Autor do livro: ");
        String autor = sc.nextLine();
        System.out.println("Informe o ano de publicação do livro: ");
        int ano = sc.nextInt();
        int disponivel = 1;

        // Cria SQL
        String sql = "INSERT INTO livros (titulo, autor, ano, disponivel) values (?,?,?,?)";

        //Prepara uma instrução SQL
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, titulo);
        ps.setString(2, autor);
        ps.setInt(3, ano);
        ps.setInt(4, disponivel);
        ps.executeUpdate();
        System.out.println("Produto inserido com sucesso!");
        ps.close();
    }

    public static void listarLivros(Connection conn) throws SQLException {

        //Cria o comando SQL
        String sql = "SELECT * FROM livros ORDER BY titulo";
        Statement stmt = conn.createStatement();

        //executa a consulta no banco de dados e armazena o resultado
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int ano = rs.getInt("ano");
            int disponivel = rs.getInt("disponivel");
            // mostra os registros da consulta

            if (disponivel == 1){
                System.out.printf("[%d] %s - %s (%d) - DISPONIVEL %n", id, titulo, autor, ano);
            }
            else  System.out.printf("[%d] %s - %s (%d) - EMPRESTADO %n", id, titulo, autor, ano);


        }
    }

    public static void removeLivro(Connection conn, Scanner sc) throws SQLException {

        //Solicita o ID para realizar remoção
        System.out.println("Informe o id do livro ");
        int id = sc.nextInt();

        //cria comando SQL
        String sql = "DELETE FROM livros WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        int linhasAfetadas = ps.executeUpdate();
        ps.close();
        if (linhasAfetadas > 0){
            System.out.println("Livro Removido");
        }
        else System.out.println("ID não encontrado");
    }

    public static void emprestarLivro(Connection conn, Scanner sc) throws SQLException {

        System.out.println("Informe o ID do livro ");
        int id = sc.nextInt();

        String sql = "UPDATE livros SET disponivel = 0 WHERE id = ? AND disponivel = 1";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int linhasAfetadas = ps.executeUpdate();

        if(linhasAfetadas > 0){
            System.out.println("Livro emprestado");
        }
        else System.out.println("ID não encontrado / Livro não esta disponivel ");

    }

    public static void devolverlivro(Connection conn, Scanner sc) throws SQLException {

        System.out.println("Informe o ID do livro: ");
        int id = sc.nextInt();

        String sql ="UPDATE livros SET disponivel = 1 WHERE id = ? AND disponivel = 0";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0){
            System.out.println("Livro devolvido");
        }
        else System.out.println("ID não encontrado ou Livro ja foi devolvido");

    }

    public static void exibirmenu () {
        System.out.println("\n=== Biblioteca ===");
        System.out.println("1. Listar livros");
        System.out.println("2. Cadastrar livro");
        System.out.println("3. Emprestar livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Remover livro");
        System.out.println("0. Sair");
        System.out.println("Opção: ");

    }
    public static void processarOpcao ( Connection conn, Scanner sc, int opcao) throws SQLException{

        switch (opcao){
            case 1: listarLivros(conn); break;
            case 2: cadastrarLivro(conn, sc); break;
            case 3: emprestarLivro(conn, sc); break;
            case 4: devolverlivro(conn, sc); break;
            case 5: removeLivro(conn, sc); break;
            case 0:
                System.out.println("Encerrando ...");break;
            default:
                System.out.println("Opção invalida");
        }

    }


    public static void main (String[] args){

        String url = "jdbc:postgresql://localhost:5432/Livros";
        try {
            // TENTA FAZER A CONEXAO COM O BD
            Connection conn = DriverManager.getConnection(
                    url, "postgres", "divergence7"
            );
            System.out.println("Conexão com sucesso");
            //chamando a funçao para criar a tabela
            criartabela(conn);
            Scanner sc = new Scanner(System.in);
            int opcao = 1;
            do{
                exibirmenu();
                opcao = sc.nextInt();
                sc.nextLine();
                processarOpcao(conn, sc, opcao);
            }
            while (opcao != 0);
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar com o banco" + e.getMessage());
        }

    }
}