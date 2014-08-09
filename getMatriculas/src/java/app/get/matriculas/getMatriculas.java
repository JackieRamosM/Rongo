/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.get.matriculas;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Liliana
 */
@WebService(serviceName = "getMatriculas")
public class getMatriculas {

    /**
     * This is a sample web service operation
     * @param username
     * @return 
     */
    @WebMethod(operationName = "getMatricula")
    public String getMatricula(@WebParam(name = "username") String username) {
        switch (username) {
            case "ljramos":
                return "201009374";
            case "hcarpio":
                return "200803369";
            case "davalbar":
                return "201018322";
            case "dschuldt":
                return "201015278";
            default:
                return "";
        }
    }
}
