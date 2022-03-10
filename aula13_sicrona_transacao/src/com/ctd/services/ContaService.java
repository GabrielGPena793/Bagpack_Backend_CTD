package com.ctd.services;

import com.ctd.model.Conta;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class ContaService {

    private static final Logger LOGGER = Logger.getLogger(ContaService.class);

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS conta;
            
            CREATE TABLE conta (
            id INT PRIMARY KEY,
            nome VARCHAR(64) NOT NULL,
            numConta VARCHAR(64) NOT NULL,
            saldo DOUBLE
            );
            """;

    private static final String SQL_UPDATE = """
            UPDATE conta SET saldo = ?
            WHERE id = ?
            """;

    private static final String SQL_INSERT = """
            INSERT INTO conta (id, nome, numConta, saldo)
            VALUES (?, ?, ?, ?)
            """;


    public static void main(String[] args) throws SQLException {

        BasicConfigurator.configure();

        Conta c1 = new Conta(1, "Bill", "5214523-4", 0.0);

        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_CREATE_TABLE);
            LOGGER.info("Criando a tabela conta.");
            statement.executeUpdate();

            PreparedStatement insert = conn.prepareStatement(SQL_INSERT);
            insert.setInt(1, c1.getId());
            insert.setString(2, c1.getNome());
            insert.setString(3, c1.getNumConta());
            insert.setDouble(4, c1.getSaldo());
            LOGGER.info("Inserindo o Bill no BD");
            insert.execute();

            mostrarDadosDaConta(conn);

            PreparedStatement atualizarConta = conn.prepareStatement(SQL_UPDATE);
            atualizarConta.setDouble(1, 10.0 + getSaldoBanco(conn,1));
            atualizarConta.setInt(2, 1);
            LOGGER.info("Depositando R$10.00");
            atualizarConta.executeUpdate();

            mostrarDadosDaConta(conn);


            PreparedStatement atualizarConta2 = conn.prepareStatement(SQL_UPDATE);
            atualizarConta.setDouble(1, 15.00 + getSaldoBanco(conn,1));
            atualizarConta.setInt(2, 1);
            LOGGER.info("Depositando R$15.00");
            atualizarConta.executeUpdate();

            mostrarDadosDaConta(conn);



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public static Connection getConnection() throws Exception {
        return  DriverManager.getConnection("jdbc:h2:mem:aula13", "sa", "");
    }

    public static void mostrarDadosDaConta(Connection conn) throws SQLException {
        String sqlSelect = "SELECT * FROM conta";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        LOGGER.info("Dados das contas: ");

        while (rs.next()){
            System.out.println("ID: " + rs.getInt("id") +
                    "\nNome: " + rs.getString("nome") +
                    "\nConta: " + rs.getString("numConta") +
                    "\nSaldo: " + rs.getDouble("saldo"));

        }
    }

    public static Double getSaldoBanco(Connection connection, int IdConta) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT saldo FROM conta
                WHERE id = ?
                """);

        preparedStatement.setInt(1, IdConta);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()){
            return  rs.getDouble("saldo");
        }else {
            LOGGER.error("Conta não existente!");
        }

        return  null;
    }
}
