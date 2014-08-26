/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Liliana
 */
@Named(value = "fileDownloadView")
@SessionScoped
public class FileDownloadView implements Serializable{

    private StreamedContent file;
     
    public FileDownloadView() throws FileNotFoundException {        
        InputStream stream;
        
        String filePath = "C:\\Users\\Liliana\\Documents\\Git\\rongo\\Rongo\\tmp\\file2.pdf";
        stream = new FileInputStream(filePath);
        
        String downloadFilename = "momosalinda.pdf";
            file = new DefaultStreamedContent(stream, "application/pdf", downloadFilename);
    }
 
    public StreamedContent getFile() {
        return file;
    }
}
