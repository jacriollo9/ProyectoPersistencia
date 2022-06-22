package Archivos.empresa;

import Clases.Cliente;
import Clases.Empresa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EmpresaTxt {
    File f = new File("Empresa.txt");

    public boolean  AgregarEmpresa(Empresa objEmpresa) throws IOException {

        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        bw.append(objEmpresa.getNombre()+",");
        bw.append(objEmpresa.getRuc()  +",");
        bw.append(objEmpresa.getCiudad() + "\n");

        bw.close();
        fw.close();

        return true;
    }

    public ArrayList<Empresa> LeerEmpresa() throws FileNotFoundException {
        ArrayList<Empresa> ArrayClientes = new ArrayList<>();
        StringTokenizer st;

        Scanner entrada = new Scanner("");
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                if(sCadena == null) {break;}
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    Empresa Objtmp = new Empresa(st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayClientes.add(Objtmp);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayClientes;
    }
}
