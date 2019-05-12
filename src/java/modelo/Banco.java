package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Banco {
    
    private final String URL = "jdbc:mysql://localhost:3306/atividade";
    private final String USER = "root";
    private final String PASSWORD = "";
    private Connection con;
    private PreparedStatement st;
    
    public void conectar() throws ClassNotFoundException{
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Falha na conexão!");
        }
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar!");
        }        
    }
    
    public void inserir(Aluno a){
        try {
            String comando = "INSERT INTO `notas` (`NOME_ALUNO`, `DISCIPLINA`, `CURSO`,`NOTA` ) "
                    + "VALUES (?, ?, ?, ?)";
            
            st = con.prepareStatement(comando);
            
            st.setString(1, a.getNome());
            st.setString(2, a.getDisciplina());
            st.setString(3, a.getCurso());
            st.setDouble(4, a.getNota());
            
            st.execute();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir!");
            e.printStackTrace();
        }
    }
    
    public void consulta(){
        try {
            String comando = "SELECT * FROM aluno;";
            Statement stmt = con.createStatement();
            ResultSet rs;            
            rs = stmt.executeQuery(comando);            
            while(rs.next()){
                String kdaNome = rs.getString("NOME_ALUNO");
                System.out.println(kdaNome);
            }
        } catch (SQLException e) {
            System.out.println("NOPE!");
        }
    }
}