package Archivos.avion;

import Clases.Avion;

import java.io.*;
import java.util.ArrayList;

public class AvionBin {
    File fichero =new File("Avion.dat");
    public boolean GrabarAvionBin(Avion avion) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Avion> arrayAvion = ImportarAvionBin();

        FileOutputStream outputStream = new FileOutputStream(fichero, false);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.flush();

        arrayAvion.add(avion);

        oos.writeObject(arrayAvion);

        outputStream.close();
        oos.close();  // Se cierra al terminar.
        return true;
    }

    public ArrayList<Avion> ImportarAvionBin() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(input);

        ArrayList<Avion> arrayAvion = (ArrayList<Avion>) ois.readObject();


        ois.close();
        input.close();

        return arrayAvion;
    }
}
