/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.espol.phantom;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Liliana
 */
@WebService(serviceName = "espolPhantom")
public class espolPhantom {

    /**
     * This is a sample web service operation
     * @param matricula
     * @return 
     */
    @WebMethod(operationName = "getMaterias")
    public ArrayList<String> getMaterias(@WebParam(name = "matricula") String matricula) {
        ArrayList<String> materias= new ArrayList<>();
                
        if(matricula.equals("201009347")){
            materias.add("INGENIERIA DE SOFTWARE II (FIEC03053)");
            materias.add("MANDARIN BASICO A (CELEX00265)");
            materias.add("FRANCES BASICO B (CELEX00257)");
            materias.add("INTERACCION HOMBRE MAQUINA (FIEC01545)");
            materias.add("PROCESAMIENTO DIGITAL DE IMAGENES (FIEC05439)");
        }
        if(matricula.equals("201018322")){
            materias.add("INGENIERIA DE SOFTWARE II (FIEC03053)");
            materias.add("DEPORTE RECREATIVO: FÚTBOL (ESPOL00018)");
            materias.add("SISTEMAS DE BASES DE DATOS II (FIEC05355)");
            materias.add("INTERACCION HOMBRE MAQUINA (FIEC01545)");
        }
        if(matricula.equals("201015278")){
            materias.add("INGENIERIA DE SOFTWARE II (FIEC03053)");
            materias.add("MANDARIN BASICO A (CELEX00265)");
            materias.add("PROCESAMIENTO DE AUDIO Y VIDEO (FIEC05413)");
            materias.add("INTERACCION HOMBRE MAQUINA (FIEC01545)");
            materias.add("PROCESAMIENTO DIGITAL DE IMAGENES (FIEC05439)");
        }
        if(matricula.equals("200803369")){
            materias.add("FUNDAMENTOS DE MERCADEO (ICHE01545)");
            materias.add("SISTEMAS DE BASES DE DATOS II (FIEC05355)");
        }
        return materias;
    }

    /**
     * Web service operation
     * @param matricula
     * @return 
     */
    @WebMethod(operationName = "getDatos")
    public String getDatos(@WebParam(name = "matricula") String matricula) {
        //TODO write your implementation code here:
        if(matricula.equals("201009347")){
            return "Ingenería en Ciencias Computacionales Orientación Sistemas Multimedia";
        }
        if(matricula.equals("201018322")){
            return "Ingenería en Ciencias Computacionales Orientación Sistemas Multimedia";
        }
        if(matricula.equals("201015278")){
            return "Ingenería en Ciencias Computacionales Orientación Sistemas Multimedia";
        }
        if(matricula.equals("200803369")){
            return "Ingenería en Ciencias Computacionales Orientación Sistemas de Información";
        }
        return null;
    }
}

