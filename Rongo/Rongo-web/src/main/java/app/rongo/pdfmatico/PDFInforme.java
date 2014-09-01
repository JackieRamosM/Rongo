/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.pdfmatico;

import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

/**
 *
 * @author SEHORE
 */
public class PDFInforme extends PDFMatico {
   private String horas_laboradas="";
   private String observaciones="";
   private String[] actividades={"","","","","","","","","","","","","","","","","","","",""};
   private int[] Horas={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
   
   
   public void setHoras(int H,int lugar) {
        this.Horas[lugar] = H;
   }
   public void setActividad(String act,int lugar) {
        this.actividades[lugar] = act;
   }
    public void setHoras_laboradas(String horas_laboradas) {
        this.horas_laboradas = horas_laboradas;
    }

    public void setObservacionesGenerales(String observaciones) {
        this.observaciones = observaciones;
    }
   
 public PDFInforme(){
     String[] s={"","","","","","","","","","","","","","","","","","","",""};
       setObservaciones(s);
        title1="AYUDANTÍAS ACADÉMICAS/ACTIVIDADES";
        title2="VARIAS/INVESTIGACIÓN";
        title3="INFORMES DE LOS AYUDANTES";
        title4="";
    }
 @Override
  protected void setCell2(PdfPCell c){
  Paragraph p;
  p=new Paragraph("Unidad Académica o Área: "+unidadAcademica,Default);
  c.addElement(p);
  p=new Paragraph("Nombre completo del Ayudante: "+nombreAyudante,Default);
  c.addElement(p);
  p=new Paragraph("Nº matrícula: "+matricula,Default);
  c.addElement(p);
  p=new Paragraph("Nombre del Jefe inmediato/Profesor evaluador-a: "+jefe,Default);
  c.addElement(p);
  p=new Paragraph("Período de la evaluación:",Default);
  c.addElement(p);
  c.addElement(getSpacedNestedTable(new Paragraph("desde",DefaultK),getDateTable(desde)));
  c.addElement(getSpacedNestedTable(new Paragraph("hasta",DefaultK),getDateTable(hasta)));
  
  p=new Paragraph("Año académico:       "+añoAcademico,Default);
  c.addElement(p);
  p=new Paragraph("Fecha de la evaluación:   "+Fecha_evaluacion,Default);
  c.addElement(p);
  p=new Paragraph("(Se presentará el primer informe después de la primera semana de evaluación académica, y el segundo y final, durante la semana de preparación para la tercera evaluación)",h4);
  p.setAlignment(Element.ALIGN_LEFT);
  c.addElement(p);
  p=new Paragraph("Horario y número de horas diarias asignadas:",Default);
  c.addElement(p);
  c.addElement(new Paragraph(" "));
  c.addElement(getDiasAsignadasTable());
}
 @Override
 protected PdfPTable getTable3(){
        float[] f ={0.3f,2.0f,0.666f,4.0f};
        PdfPTable table = new PdfPTable(f);   
        
        table.addCell("N°");
        PdfPCell c;
        c=new PdfPCell(new Paragraph("ACTIVIDADES REALIZADAS\n(en orden cronológico)",h4));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("HORAS",h4));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("OBSERVACIONES PARA CADA ACTIVIDAD",h4));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        
        for(int i=1;i<=20;i++){
            table.addCell(new PdfPCell(new Paragraph(""+i, Default)));
            table.addCell(new PdfPCell(new Paragraph(""+actividades[i], Default)));
            table.addCell(new PdfPCell(new Paragraph(""+(Horas[i]==-1?"":""+Horas[i]))));
            table.addCell(new PdfPCell(new Paragraph(""+Observaciones[i])));
        }
        return table;
}
 @Override
 protected PdfPCell getCell3(){
    PdfPCell result=new PdfPCell(getTable3());
    result.setPadding(5.0f);
    return result;
}
 @Override
 protected void setCell4(PdfPCell c){
    c.addElement(new Paragraph("Total de horas laboradas:" +horas_laboradas,Default));
    c.addElement(new Paragraph("Observaciones generales:",Default));
    c.addElement(new Paragraph(" "+observaciones,Default));
    c.addElement(new Paragraph(" "));
}
 @Override
 protected void setCell5(PdfPCell c){
    Paragraph p;
    c.addElement(new Paragraph(" "));
    p=new Paragraph("Firma del Ayudante                                                      Firma de Jefe inmediato/Profesor-a \n" +
"                                                                     que supervisa el trabajo",DefaultK);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
}
}
