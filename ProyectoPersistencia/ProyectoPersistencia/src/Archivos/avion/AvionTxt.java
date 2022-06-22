package Archivos.avion;

import Clases.Avion;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AvionTxt {
    File f = new File("Empresa.txt");

    public boolean AgregarAvion(Avion objAvion) throws IOException {

        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.flush();

        bw.append(objAvion.getMatricula()+",");
        bw.append(objAvion.getModelo()  +",");
        bw.append(objAvion.getNombre() + "\n");

        bw.close();
        fw.close();

        return true;
    }

    public ArrayList<Avion> LeerAvion() throws FileNotFoundException {
        ArrayList<Avion> ArrayClientes = new ArrayList<>();
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
                    Avion Objtmp = new Avion(st.nextToken(), st.nextToken(), st.nextToken());
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
