package Presentacion;
import Clases.Avion;
import Clases.Cliente;
import Clases.Empresa;
import Logica.LogClienteTxt;
import Logica.avion.LogAvionBin;
import Logica.empresa.LogEmpresaTxt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author
 * Fecha: 15-06-2022
 */
public class ArchivoTexto {
    static LogClienteTxt objLogClienteTxt = new LogClienteTxt();
    static LogEmpresaTxt objLogEmpresaTxt = new LogEmpresaTxt();
    static LogAvionBin objLogAvionTxt = new LogAvionBin();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AgregarEmpresaTxt();
        ListarEmpresaTxt();
        AgregarAvionTxt();
        ListarAvionTxt();
    }
    void menuArchivoTexto() throws IOException {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op < 4){
            System.out.println("Agregar       1");
            System.out.println("Eliminar      2");
            System.out.println("Listar        3");
            System.out.println("Salir         4");
            op = sc.nextInt();
            switch (op){
                case 1: AgregarEmpresaTxt(); break;
                case 2: EliminarEmpresaTxt(); break;
                case 3: ListarEmpresaTxt(); break;
            }
        }
    }
    private static void AgregarClienteTxt() throws IOException{
        Cliente objCliente = new Cliente();
        objCliente.setId(4);
        objCliente.setNombre("Tania Torres");
        objCliente.setFecNac("21062022");
        if (objLogClienteTxt.ValidarId(objCliente)){
            System.out.println("Cliente Agregado");
        } else {
            System.out.printf("Codigo Cliente No Valido");
        }
    }

    private static void EliminarEmpresaTxt() {
    }
    private static void AgregarEmpresaTxt() throws IOException{
        ArrayList<Empresa> empresas = new ArrayList<>();
        empresas.add(new Empresa("lAPA", "1478523695789", "Riobamba"));
        empresas.add(new Empresa("AZART", "1236547896587", "Cuenca"));
        empresas.add(new Empresa("LAPO", "1245783695148", "Esmeraldas"));

        for (Empresa objEmpresa: empresas) {
            if (objLogEmpresaTxt.Validar(objEmpresa)) {
                System.out.println("Cliente Agregado");
            } else {
                System.out.printf("RUC No Valido");
            }
        }
    }

    private static void ListarEmpresaTxt() throws FileNotFoundException {
        ArrayList<Empresa> ArrayClientes = objLogEmpresaTxt.ListarEmpresas();
        for (Empresa tmpCliente : ArrayClientes){
            System.out.println(tmpCliente.toString());
        }
    }

    private static void AgregarAvionTxt() throws IOException, ClassNotFoundException {
        ArrayList<Avion> aviones = new ArrayList<>();

        aviones.add(new Avion("AZC-7586B", "ZAPATA", "CONVIASA"));
        aviones.add(new Avion("JAC-2001J", "AIR EUROPA.", "ESPAÑA"));
        aviones.add(new Avion("RMR-1998R", "BOEING", "COPA"));

        for (Avion objAvion: aviones) {
            if (objLogAvionTxt.ValidarId(objAvion)) {
                System.out.println("Cliente Agregado");
            } else {
                System.out.printf("RUC No Valido");
            }
        }
    }

    private static void ListarAvionTxt() throws IOException, ClassNotFoundException {
        ArrayList<Avion> ArrayAvion = objLogAvionTxt.ListarAvion();
        for (Avion tmpAvion : ArrayAvion){
            System.out.println(tmpAvion.toString());
        }
    }
}
