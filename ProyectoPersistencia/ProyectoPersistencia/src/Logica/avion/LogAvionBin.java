package Logica.avion;

import Archivos.avion.AvionBin;
import Clases.Avion;

import java.io.IOException;
import java.util.ArrayList;

public class LogAvionBin {
    AvionBin objAvionBin = new AvionBin();
    public boolean ValidarId(Avion objAvion) throws IOException, ClassNotFoundException {
        ArrayList<Avion> ArrayAvion = ListarAvion();
        // Valida si el codigo es correcto
        if (objAvion.getMatricula().length() > 6){
            // Agregar al archivo texto
            ArrayAvion.add(objAvion);
            return objAvionBin.GrabarAvionBin(objAvion);
        }
        return false;
    }
    public ArrayList<Avion> ListarAvion() throws IOException, ClassNotFoundException {
        return objAvionBin.ImportarAvionBin();
    }
}
