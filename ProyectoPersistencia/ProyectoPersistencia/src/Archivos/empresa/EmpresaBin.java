package Archivos.empresa;

import Clases.Empresa;

import java.io.*;
import java.util.ArrayList;

public class EmpresaBin {
    File fichero =new File("Empresa.dat");
    public boolean GrabarEmpresaBin(Empresa empresa) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Empresa> ArrayEmpresa = ImportarEmpresaBin();

        FileOutputStream outputStream = new FileOutputStream(fichero, false);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.flush();

        ArrayEmpresa.add(empresa);

        oos.writeObject(ArrayEmpresa);

        outputStream.close();
        oos.close();  // Se cierra al terminar.
        return true;
    }

    public ArrayList<Empresa> ImportarEmpresaBin() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(input);

        ArrayList<Empresa> ArrayEmpresa  = (ArrayList<Empresa>) ois.readObject();


        ois.close();
        input.close();

        return ArrayEmpresa;
    }
}
