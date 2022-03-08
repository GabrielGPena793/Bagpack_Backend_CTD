package com.ctd.Program;

import java.sql.*;

public class MainTestH2 {

    //seeding
    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS empregado;
            
            CREATE TABLE empregado (
            id INT PRIMARY KEY,
            nome VARCHAR(64) NOT NULL,
            empresa VARCHAR(64),
            idade INT NOT NULL,
            data_inicio VARCHAR(32) NOT NULL
            );
            
            """;

    private static final String SQL_INSERT1 = """
            INSERT INTO empregado (id, nome, empresa, idade, data_inicio)
            VALUES (1, 'Murilo', 'Digital House', 28, '08/03/2022');
            """;

    private static final String SQL_INSERT2 = """
            INSERT INTO empregado (id, nome, empresa, idade, data_inicio)
            VALUES (2, 'Carolina', 'Digital House', 39, '28/01/2022');
            """;

    private static final String SQL_INSERT3 = """
            INSERT INTO empregado (id, nome, empresa, idade, data_inicio)
            VALUES (3, 'Diego', 'Digital House', 58, '11/08/2001');
            """;

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try{
            conn = getConnection();
            Statement statement = conn.createStatement();

            statement.execute(SQL_CREATE_TABLE);

            statement.execute(SQL_INSERT1);

            statement.execute(SQL_INSERT2);

            statement.execute(SQL_INSERT3);

            String consultaASql = """
                    SELECT * FROM empregado
                    """;
            ResultSet rs =  statement.executeQuery(consultaASql);

            while (rs.next()){
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("nome") + " | " +
                        rs.getString("empresa") + " | " +
                        rs.getInt("idade") + " | " +
                        rs.getString("data_inicio"));
            }

            statement.close();

        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            conn.close();
        }


    }

    //conecção com H2
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:h2:mem:aula11", "sa", "");

    }
}
