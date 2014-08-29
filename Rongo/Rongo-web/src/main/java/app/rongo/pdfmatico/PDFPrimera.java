/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.pdfmatico;

import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;

/**
 *
 * @author SEHORE
 */
public class PDFPrimera extends PDFMatico{
    public PDFPrimera(){
        title1="AYUDANTÍAS ACADÉMICAS/ACTIVIDADES";
        title2="VARIAS/INVESTIGACIÓN";
        title3="EVALUACIÓN DE DESEMPEÑO";
        title4="PRIMERA EVALUACIÓN";
    }
  @Override
  protected void setCell4(PdfPCell c){
    c.addElement(new Paragraph("Lo mejor en su desempeño: "+desempeño,Default));
    c.addElement(new Paragraph(" "));
    c.addElement(new Paragraph("Lo que debe mejorar: "+mejorar,Default));
    c.addElement(new Paragraph(" "));
}
  @Override
  protected void setCell5(PdfPCell c){
    Paragraph p;
    c.addElement(new Paragraph(" "));
    p=new Paragraph("Firma del Ayudante                                                       Firma del evaluador",DefaultK);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
}
}
