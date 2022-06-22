package Logica.empresa;

import Archivos.empresa.EmpresaDB;
import Clases.Empresa;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogEmpresaDB {
    EmpresaDB objEmpresaDB = new EmpresaDB();

    public void InsertarEmpresas(ArrayList<Empresa> arrayEmpresas) throws SQLException, ClassNotFoundException {

        for (var objEmpresa : arrayEmpresas)
            objEmpresaDB.InsertarEmpresaDB(objEmpresa);



    }
    public ArrayList<Empresa> RecuperarClientes() throws SQLException, ClassNotFoundException {
        ArrayList<Empresa> ArrayClientes = new ArrayList<>();
        ResultSet rs = objEmpresaDB.RecuperarEmpresa();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        String nombre = null;
        String ruc = null;
        String ciudad = null;
        //Envia los datos a la Clase
        while (rs.next()) {

            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("nombre")) {
                    nombre = value;
                }
                if (columnName.equals("ruc")) {
                    ruc = value;
                }
                if (columnName.equals("ciudad")) {
                    ciudad = value;
                }
            }
            Empresa objAux = new Empresa(nombre, ruc, ciudad);
            ArrayClientes.add(objAux);
        }
        return ArrayClientes;
    }
}
