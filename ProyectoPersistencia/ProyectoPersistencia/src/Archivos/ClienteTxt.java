package Archivos;
import Clases.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author
 * Fecha: 15-06-2022
 */

public class ClienteTxt {
    File f = new File("C:\\Users\\josea\\OneDrive\\Escritorio\\ProyectoPersistencia\\ProyectoPersistencia\\Programacion\\Cliente.txt");

    public boolean  AgregarCliente(Cliente objCliente) throws IOException {

        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        bw.append(objCliente.getId()  +",");
        bw.append(objCliente.getNombre()+",");
        bw.append(objCliente.getFecNac() + "\n");

        bw.close();
        fw.close();

        return true;
    }

    public ArrayList<Cliente>  LeerCliente() throws FileNotFoundException {
        ArrayList<Cliente> ArrayClientes = new ArrayList<>();
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
                        Cliente Objtmp = new Cliente(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken());
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
    public void LeerClienteTxt(){

    }
}
