package br.com.energynow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrecoKWHDao {
    ConexaoJDBC conexaoJDBC = new ConexaoJDBC();

    public double getPreco(String uf) throws SQLException {

        String sql = "SELECT preco_kwh FROM t_preco_kwh WHERE uf = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1, uf);

        ResultSet resultSet = statement.executeQuery ();
        if(resultSet.next ()){

            statement.close();
            conexao.close();
            resultSet.close ();

            return resultSet.getDouble (1);

        }else {

            statement.close();
            conexao.close();
            resultSet.close ();

            throw new SQLException();
        }

    }
}
