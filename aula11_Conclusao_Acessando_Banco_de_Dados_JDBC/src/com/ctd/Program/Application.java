package com.ctd.Program;

import com.ctd.db.DB;
import com.ctd.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            //criando os empregados
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1,"Jorge", 27, "Digital House", sdf.parse("05/03/1994")));
            employees.add(new Employee(2,"Larissa", 30, "Google", sdf.parse("20/08/1991")));
            employees.add(new Employee(3,"Noé", 49, "Facebook", sdf.parse("05/03/1972")));

            // criando a consulta
            st = conn.prepareStatement("""
                    INSERT INTO employee (id, userName, age, company, contractDate)
                    VALUES (?, ?, ?, ?, ?)
                    """);

            //realizando uma consulta para cada employee na lista
            int rowsAffected =0;
            for(Employee employee : employees){

                st.setInt(1, employee.getId());
                st.setString(2, employee.getUserName());
                st.setInt(3, employee.getAge());
                st.setString(4, employee.getCompany());
                st.setDate(5, new java.sql.Date(employee.getContractDate().getTime()));

                rowsAffected += st.executeUpdate();
            }
            //print de quantas linhas foram afetadas nessa consulta, se adicionei 3, tem que vir 3;
            System.out.println(rowsAffected);

            //buscando todos os dados da tabela no banco de dados.
            st = conn.prepareStatement("""
                    SELECT * FROM employee;
                    """);

            //fazendo a consulta
            rs = st.executeQuery();

            //printa os dados que estou pedindo de cada employee no banco de dados;
            while (rs.next()){
                System.out.println(rs.getInt("id") +", " +  rs.getString("userName"));
            }

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
            DB.closeResultSet(rs);
        }


    }
}
