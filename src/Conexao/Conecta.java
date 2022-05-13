package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta {

    //atributos de conexão com o banco de dados
    private Connection conn = null;//Variavel de conexão
    private Statement statement;//variavel de manipulação do SQL
    private ResultSet resultSet;//variavel que captura retorno do banco

    //informando dados do banco
    private String servidor = "localhost:3306";
    private String nomeDoBanco = "pessoas";
    private String usuario = "root";
    private String senha = "lucas";

    //Construtor vazio
    public Conecta(){
        
    }
    
    //Construtor
    public Conecta(String servidor, String nomeDoBanco, String usuario, String senha) {
        this.servidor = servidor;
        this.nomeDoBanco = nomeDoBanco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    //Metódos
    public void conectaBanco() {
        try {
            //Iniciando conexão com o MySQL
            conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + nomeDoBanco, usuario, senha);
            if (conn != null) {
                System.out.println("Conexão efetuada com sucesso" + "ID: " + conn);
            }
        } catch (Exception e) {
            System.out.println("Conexão não realizada ERRO: " + e.getMessage());
        }
    }

    public boolean fechaBanco() {
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao fechar banco: " + e.getMessage());
            return false;
        }

    }

    public int insertSQL(String SQL) {
        int status = 0;
        try {

            this.setStatement(getConn().createStatement());

            this.getStatement().executeUpdate(SQL);

            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    public void executarSQL(String sql) {
        try {
            this.statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.resultSet = this.statement.executeQuery(sql);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public boolean updateSQL(String uSQL) {
        try {

            this.setStatement(getConn().createStatement());

            getStatement().executeUpdate(uSQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
