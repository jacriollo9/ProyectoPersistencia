package Logica.avion;

import Archivos.avion.AvionDB;
import Clases.Avion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogAvionDB {
    AvionDB objAvionDB = new AvionDB();

    public void InsertarAviones(ArrayList<Avion> arrayAvions) throws SQLException, ClassNotFoundException {
        for (var objAvion : arrayAvions)
            objAvionDB.InsertarAvionDB(objAvion);
    }

    public ArrayList<Avion> RecuperarAviones() throws SQLException, ClassNotFoundException {
        ArrayList<Avion> ArrayAviones  = new ArrayList<>();
        ResultSet rs = objAvionDB.RecuperarAvion();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        String matricula = null;
        String modelo = null;
        String nombre = null;
        //Envia los datos a la Clase
        while (rs.next()) {

            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("matricula")) {
                    matricula = value;
                }
                if (columnName.equals("modelo")) {
                    modelo = value;
                }
                if (columnName.equals("nombre")) {
                    nombre = value;
                }
            }
            Avion objAux = new Avion(matricula, modelo, nombre);
            ArrayAviones.add(objAux);
        }
        return ArrayAviones;
    }
}
