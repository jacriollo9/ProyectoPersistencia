package Presentacion;
import Clases.Avion;
import Clases.Cliente;
import Clases.Empresa;
import Logica.LogClienteBin;
import Logica.avion.LogAvionBin;
import Logica.empresa.LogEmpresaBin;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author
 * Fecha: 15-06-2022
 */

public class ArchivoBin {
    private static LogClienteBin objLogClienteBin;
    private static LogEmpresaBin objLogEmpresaBin;
    private static LogAvionBin objLogAvionBin;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objLogClienteBin = new LogClienteBin();
        objLogEmpresaBin = new LogEmpresaBin();
        objLogAvionBin = new LogAvionBin();
        AgregarEmpresaBin();
        ListarEmpresaBin();
        AgregarAvionBin();
        ListarAvionBin();
    }

    private static void AgregarClienteBin() throws IOException, ClassNotFoundException {
        Cliente objCliente = new Cliente();
        objCliente.setId(5);
        objCliente.setNombre("Rosa Romero");
        objCliente.setFecNac("15062022");

        if (objLogClienteBin.ValidarId(objCliente)){
            System.out.println("Cliente Agregado");
        } else {
            System.out.printf("Codigo Cliente No Valido");
        }
    }
    private static void AgregarEmpresaBin() throws IOException, ClassNotFoundException {
        ArrayList<Empresa> empresas = new ArrayList<>();
        empresas.add(new Empresa("Corporación Favorita", "1711044810001", "Quito"));
        empresas.add(new Empresa("Pintuco", "1431048819001", "Guayaquil"));
        empresas.add(new Empresa("Ile", "1108085612001", "Loja"));

        for (Empresa objEmpresa: empresas) {
            if (objLogEmpresaBin.ValidarId(objEmpresa)) {
                System.out.println("Empresa Agregada");
            } else {
                System.out.printf("RUC No Valido");
            }
        }
    }

    private static void AgregarAvionBin() throws IOException, ClassNotFoundException {
        ArrayList<Avion> aviones = new ArrayList<>();

        aviones.add(new Avion("ABG-7632E", "Airbus", "American"));
        aviones.add(new Avion("HBS-1382P", "BOEING", "LATIN"));
        aviones.add(new Avion("EGK-6482E", "BOEING", "CASTILLA"));

        for (Avion objAvion: aviones) {
            if (objLogAvionBin.ValidarId(objAvion)) {
                System.out.println("Empresa Agregada");
            } else {
                System.out.printf("RUC No Valido");
            }
        }
    }

    private void EliminarClienteBin() {
    }
    private static void ListarClienteBin() throws IOException, ClassNotFoundException {
        ArrayList<Cliente> ArrayClientes = objLogClienteBin.ListarClientes();
        for (Cliente tmpCliente : ArrayClientes){
            System.out.println(tmpCliente.toString());
        }
    }

    private static void ListarEmpresaBin() throws IOException, ClassNotFoundException {
        ArrayList<Empresa> ArrayEmpresa = objLogEmpresaBin.ListarEmpresa();
        for (Empresa tmpCliente : ArrayEmpresa){
            System.out.println(tmpCliente.toString());
        }
    }
    private static void ListarAvionBin() throws IOException, ClassNotFoundException {
        ArrayList<Avion> ArrayAvion = objLogAvionBin.ListarAvion();
        for (Avion tmpCliente : ArrayAvion){
            System.out.println(tmpCliente.toString());
        }
    }
}
