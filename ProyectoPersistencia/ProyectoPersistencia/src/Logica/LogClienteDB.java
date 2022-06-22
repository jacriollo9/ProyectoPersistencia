package Logica;


import Archivos.ClienteDB;
import Clases.Cliente;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import Archivos.ClienteDB;

public class LogClienteDB {
    ClienteDB objClienteDB = new ClienteDB();

    public void InsertarClientes(ArrayList<Cliente> arrayClientes) throws SQLException, ClassNotFoundException {

        for (Cliente objCliente : arrayClientes)
            objClienteDB.InsertarClienteDB(objCliente);



    }
    public ArrayList<Cliente> RecuperarClientes(ArrayList<Cliente> ArrayClientes) throws SQLException, ClassNotFoundException {
        ArrayList<ClienteDB> servicios = new ArrayList<>();
        ResultSet rs = objClienteDB.RecuperarCliente();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        //Envia los datos a la Clase
        while (rs.next()) {
            Cliente objAux = new Cliente();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("id")) {
                    objAux.setId(Integer.parseInt(value));
                }
                if (columnName.equals("Nombre")) {
                    objAux.setNombre((value));
                }
                if (columnName.equals("fecNam")) {
                    objAux.setFecNac (value);
                }
            }
            ArrayClientes.add(objAux);
        }
        return ArrayClientes;
    }


}
//getMetaData