package br.com.energynow.DAO;

import br.com.energynow.model.Gerenciamento;

import java.sql.SQLException;

public interface IGerenciamentoDao {
    void create (Gerenciamento geren) throws SQLException;
    Gerenciamento read (Gerenciamento geren) throws SQLException;
    void updat (Gerenciamento geren) throws SQLException;
    void delete (Gerenciamento geren) throws SQLException;
}
