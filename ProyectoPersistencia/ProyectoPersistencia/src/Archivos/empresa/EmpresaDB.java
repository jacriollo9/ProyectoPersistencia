package Archivos.empresa;

import Archivos.DATConexion;
import Clases.Cliente;
import Clases.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDB {
    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;


    public boolean InsertarEmpresaDB(Empresa objEmpresa) {
        String sql = "INSERT INTO Empresa (nombre, ruc, ciudad) "
                + "VALUES (?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, objEmpresa.getNombre());
            ps.setString(2, objEmpresa.getRuc());
            ps.setString(3, objEmpresa.getCiudad());
            ps.execute();
            //System.out.println("Empresa insertado");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.CerrarConexion();
            } catch (SQLException e) {
                System.err.println(3);
            }
        }
    }


    public ResultSet RecuperarEmpresa() throws ClassNotFoundException, SQLException {
        java.sql.Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Empresa";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}
