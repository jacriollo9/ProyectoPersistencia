package Logica.avion;

import Archivos.avion.AvionTxt;
import Clases.Avion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LogAvionTxt {
    AvionTxt objAvionTxt = new AvionTxt();
    public boolean  ValidarId(Avion objAvion) throws IOException {
        // Valida si el codigo es correcto
        if (objAvion.getMatricula().length() > 6){
            // Agregar al archivo texto
            return objAvionTxt.AgregarAvion(objAvion);
        }
        return false;
    }
    public ArrayList<Avion> ListarAvion() throws FileNotFoundException {
        ArrayList<Avion> arrayAvion = objAvionTxt.LeerAvion();
        return arrayAvion;
    }
}
