package br.com.energynow.Service;

import br.com.energynow.DAO.GerenciamentoDao;
import br.com.energynow.DAO.PrecoKWHDao;
import br.com.energynow.DAO.UserDao;
import br.com.energynow.DTO.GerenciamentoDTO;
import br.com.energynow.model.Gerenciamento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoService {
    GerenciamentoDao d = new GerenciamentoDao ();

    public void create (GerenciamentoDTO gerenDTO) throws SQLException {
        UserDao dUser = new UserDao();
        Gerenciamento geren = new Gerenciamento (gerenDTO);

        geren.setUf (indentificadorUF (dUser.readCep (gerenDTO.getEmail ())));
        d.create (geren);
    }

    /*public List<GerenciamentoDTO> getList (String email) throws SQLException {

        List<Gerenciamento> l = d.readList (email);

    }*/





    //metodo para indentificar o UF do CEP
    private static String indentificadorUF(String cep){
        // Remover qualquer caractere não numérico, caso o CEP tenha pontos ou traços.
        cep = cep.replaceAll("[^0-9]", "");

        // Verificar se o CEP tem 8 dígitos
        if (cep.length() != 8) {
            return "CEP inválido";
        }

        // Converter o CEP para um número inteiro
        int cepInt = Integer.parseInt(cep);

        // Identificar o estado com base no CEP
        if (cepInt >= 1000000 && cepInt <= 19999999) {
            return "SP";
        } else if (cepInt >= 20000000 && cepInt <= 28999999) {
            return "RJ";
        } else if (cepInt >= 29000000 && cepInt <= 29999999) {
            return "ES";
        } else if (cepInt >= 30000000 && cepInt <= 39999999) {
            return "MG";
        } else if (cepInt >= 40000000 && cepInt <= 48999999) {
            return "BA";
        } else if (cepInt >= 49000000 && cepInt <= 49999999) {
            return "SE";
        } else if (cepInt >= 50000000 && cepInt <= 56999999) {
            return "PE";
        } else if (cepInt >= 57000000 && cepInt <= 57999999) {
            return "AL";
        } else if (cepInt >= 58000000 && cepInt <= 58999999) {
            return "PB";
        } else if (cepInt >= 59000000 && cepInt <= 59999999) {
            return "RN";
        } else if (cepInt >= 60000000 && cepInt <= 63999999) {
            return "CE";
        } else if (cepInt >= 64000000 && cepInt <= 64999999) {
            return "PI";
        } else if (cepInt >= 65000000 && cepInt <= 65999999) {
            return "MA";
        } else if (cepInt >= 66000000 && cepInt <= 68899999) {
            return "PA";
        } else if (cepInt >= 68900000 && cepInt <= 68999999) {
            return "AP";
        } else if (cepInt >= 69000000 && cepInt <= 69299999) {
            return "AM";
        } else if (cepInt >= 69300000 && cepInt <= 69389999) {
            return "RR";
        } else if (cepInt >= 69900000 && cepInt <= 69999999) {
            return "AC";
        } else if (cepInt >= 70000000 && cepInt <= 73699999) {
            return "DF";
        } else if (cepInt >= 72800000 && cepInt <= 76799999) {
            return "GO";
        } else if (cepInt >= 77000000 && cepInt <= 77995999) {
            return "TO";
        } else if (cepInt >= 78000000 && cepInt <= 78899999) {
            return "MT";
        } else if (cepInt >= 78900000 && cepInt <= 78930999) {
            return "RO";
        } else if (cepInt >= 78931000 && cepInt <= 79999999) {
            return "MS";
        } else if (cepInt >= 80000000 && cepInt <= 82999999) {
            return "PR";
        }else {
            System.out.println ("Estado não encontrado");
            return "";
        }
    }

    //metodos para descobrir os preço da conta de luz com os 3 variaçoes(Normal, Com economia e Com placas solares)
    private double precoUF(String uf) throws SQLException {
        PrecoKWHDao precoKWHDao = new PrecoKWHDao ();
        return precoKWHDao.getPreco (uf);
    }

    //Normal
    private double precoN(double ufpreco, int kWh ){
        return ufpreco * kWh;
    }

    //Com habitos de economia
    private double precoCE(double preco){//Utiliza o resultado do precoN
        return preco*0.20;
    }

    //Com placa solar gerando 65 kWh por mes
    private double precoCP(double ufpreco, int kWh, int nPlacasSolares){
        int resultkWh = kWh - (65 * nPlacasSolares);
        return ufpreco * resultkWh;
    }

    //metodos para transformar mes(Numero) em mes(Nome)
    private static String transformaMes (String data){
        String[] months = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        String mes = getMes (data);
        int mesInt = Integer.parseInt(mes);

        return months[mesInt - 1];
    }

    private static String getMes(String data){
        return data.substring (3, data.length () -5);
    }


}
