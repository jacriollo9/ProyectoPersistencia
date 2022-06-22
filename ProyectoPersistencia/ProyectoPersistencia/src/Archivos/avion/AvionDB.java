package Archivos.avion;

import Archivos.DATConexion;
import Clases.Avion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvionDB {
    DATConexion con = new DATConexion();
    ResultSet rs;
    PreparedStatement ps = null;


    public boolean InsertarAvionDB(Avion objAvion) {
        String sql = "INSERT INTO Avion (matricula, modelo, nombre) "
                + "VALUES (?,?,?)";
        try {
            ps = con.AbrirConexion().prepareStatement(sql);
            ps.setString(1, objAvion.getMatricula());
            ps.setString(2, objAvion.getModelo());
            ps.setString(3, objAvion.getNombre());
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


    public ResultSet RecuperarAvion() throws ClassNotFoundException, SQLException {
        java.sql.Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM Avion";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}
