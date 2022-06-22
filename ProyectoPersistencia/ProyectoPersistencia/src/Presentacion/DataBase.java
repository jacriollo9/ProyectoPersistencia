package Presentacion;
import Clases.Avion;
import Clases.Cliente;
import Clases.Empresa;
import Logica.LogClienteDB;
import Logica.avion.LogAvionBin;
import Logica.avion.LogAvionDB;
import Logica.empresa.LogEmpresaDB;

import java.sql.SQLException;
import java.util.ArrayList;
public class DataBase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Empresa> empresas = new ArrayList<>();
        LogEmpresaDB objLogEmpresaDB = new LogEmpresaDB();

        //Entrada de datos
        empresas.add(new Empresa("Corporación Favorita", "1711044810001", "Quito"));
        empresas.add(new Empresa("Pintuco", "1431048819001", "Guayaquil"));
        empresas.add(new Empresa("Ile", "1108085612001", "Loja"));


        ArrayList<Avion> aviones = new ArrayList<>();
        LogAvionDB objLogAvionDB = new LogAvionDB();

        aviones.add(new Avion("ABG-7632E", "Airbus", "American"));
        aviones.add(new Avion("HBS-1382P", "BOEING", "LATIN"));
        aviones.add(new Avion("EGK-6482E", "BOEING", "CASTILLA"));

        objLogEmpresaDB.InsertarEmpresas(empresas);
        objLogAvionDB.InsertarAviones(aviones);

        empresas = objLogEmpresaDB.RecuperarClientes();
        for (Empresa OBJEmpresa: empresas)
            System.out.println(OBJEmpresa.toString());

        aviones = objLogAvionDB.RecuperarAviones();
        for (Avion OBJEmpresa: aviones)
            System.out.println(OBJEmpresa.toString());

    }
}
