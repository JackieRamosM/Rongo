/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.pdfmatico;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author SEHORE
 */
public abstract class PDFMatico {
    private static String FILE = "c:/temp/FirstPdf.pdf";
    
    protected String title1;
    protected String title2;
    protected String title3;
    protected String title4;

    public void setUnidadAcademica(String unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public void setNombreAyudante(String nombreAyudante) {
        this.nombreAyudante = nombreAyudante;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public void setAñoAcademico(int inicio, int fin) {
        this.añoAcademico = ""+inicio+"/"+fin;
    }

    public void setFecha_evaluacion(String Fecha_evaluacion) {
        this.Fecha_evaluacion = Fecha_evaluacion;
    }

    public void setHorario(int l,int mar,int mi,int j,int v,int s,int d) {
        this.Horario[0]=l;
        this.Horario[1]=mar;
        this.Horario[2]=mi;
        this.Horario[3]=j;
        this.Horario[4]=v;
        this.Horario[5]=s;
        this.Horario[6]=d;
    }
    public void setDesempeño(String desempeño) {
        this.desempeño = desempeño;
    }

    public void setMejorar(String mejorar) {
        this.mejorar = mejorar;
    }

    public void setRecomendado(String recomendado) {
        this.recomendado = recomendado;
    }
    
    
    protected String unidadAcademica="";
    protected String nombreAyudante="";
    protected String matricula="";
    protected String jefe="";
    protected String añoAcademico="201_ / 201_";
    protected String Fecha_evaluacion="";
    protected String[] desde={"dd","mm","aa"};
    protected String[] hasta={"dd","mm","aa"};
    protected int[] Horario={0,0,0,0,0,0,0};
    protected String desempeño="";
    protected int[] Calificacion={-1,-1,-1,-1,-1};
    protected String[] Observaciones={"","","","",""};

    public void setCalificacion(int Calificacion,int lugar) {
        this.Calificacion[lugar] = Calificacion;
    }
    protected void setObservaciones(String[] observaciones){
        Observaciones=observaciones;
    }
    public void setObservaciones(String Observaciones,int lugar) {
        this.Observaciones[lugar] = Observaciones;
    }
    
    
    protected String mejorar="";
    protected String recomendado="_____(SÍ /NO)";
    
    protected static Font h1 = new Font(Font.BOLD,16.0f,1, Color.BLACK);
    protected static Font h2 = new Font(Font.BOLD,12.0f,1, Color.BLACK);
    protected static Font h3 = new Font(Font.BOLD,11.0f,1, Color.BLACK);
    protected static Font h4 = new Font(Font.BOLD,7.0f,1, Color.BLACK);
    protected static Font Default  = new Font(Font.DEFAULTSIZE,9.0f);
    protected static Font DefaultK  = new Font(Font.BOLD,9.0f,2, Color.BLACK);//= new Font(Font.ITALIC,9.0f);

  
  private void addMetaData(Document document) {
    document.addTitle("PDF");
    document.addSubject("Informes");
    document.addKeywords("Java, PDF, iText");
    document.addAuthor("Denny,David,Jacqueline");
    document.addCreator("David");
  }
  private void addContent(Document document) throws DocumentException, BadElementException, MalformedURLException, IOException {
    createMainTable(document);
  }
  public void setDesde(String dia, String mes, String año){
      setFecha(desde,dia,mes,año);
  }
  public void setHasta(String dia, String mes, String año){
      setFecha(hasta,dia,mes,año);
  }
  private void setFecha(String[] fecha,String dia,String mes, String año){
      fecha[0]=dia;
      fecha[1]=mes;
      fecha[2]=año;
  }
  private void setEspolLogo (PdfPCell c) throws BadElementException, MalformedURLException, IOException{
      Image image = Image.getInstance("c:/temp/logoEspol.png");
      image.setAlignment(Image.LEFT);
      image.scaleAbsolute(60.0f,60.0f);
      c.setPadding(12.0f);
      c.addElement(image);      
  }
protected void setTitleCellText(PdfPCell c) throws BadElementException, MalformedURLException, IOException{
    Paragraph p;
    
    p=new Paragraph(title1, h1);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
   
   p=new Paragraph(title2, h1);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
    
    p=new Paragraph(title3, h2);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
    
    p=new Paragraph(title4, h2);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
}
private PdfPTable getTitleCell() throws BadElementException, MalformedURLException, IOException{
    float[] f ={1.0f,5.0f};
    PdfPTable table = new PdfPTable(f);
    
        PdfPCell c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_CENTER);
        setEspolLogo(c1);
        c1.setBorderColor(Color.WHITE);
        table.addCell(c1);
        
        
        PdfPCell c2 = new PdfPCell();
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        setTitleCellText(c2);
        c2.setBorderColor(Color.WHITE);
        table.addCell(c2);
        
        return table;
}
protected PdfPTable getDateTable(String[] s){
float[] f ={1.0f,1.0f,1.0f};
PdfPTable table = new PdfPTable(f);
PdfPCell c;
c=new PdfPCell(new Phrase(s[0],DefaultK));
c.setHorizontalAlignment(Element.ALIGN_CENTER);
table.addCell(c);
c=new PdfPCell(new Phrase(s[1],DefaultK));
c.setHorizontalAlignment(Element.ALIGN_CENTER);
table.addCell(c);
c=new PdfPCell(new Phrase(s[2],DefaultK));
c.setHorizontalAlignment(Element.ALIGN_CENTER);
table.addCell(c);
return table;
}
protected PdfPTable getSpacedNestedTable(Paragraph p,PdfPTable t){
float[] f ={2.f,1.f,1.0f};
PdfPTable table = new PdfPTable(f);
PdfPCell c;
c=new PdfPCell();
c.setBorderColor(Color.WHITE);
table.addCell(c);
c=new PdfPCell(p);
c.setBorderColor(Color.WHITE);
table.addCell(c);
c=new PdfPCell(t);
c.setBorderColor(Color.WHITE);
table.addCell(c);
return table;
}
protected PdfPTable getDiasAsignadasTable(){
        float[] f ={2.f,1.f,1.f,1.f,1.f,1.f,1.f,1.f};
        PdfPTable table = new PdfPTable(f);
        table.addCell(new Paragraph("Días",Default));
        
        PdfPCell c;
        c=new PdfPCell(new Paragraph("L",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("M",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("M",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("J",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("V",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("S",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("D",Default));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c);
        
        table.addCell(new Paragraph("Cantidad horas",Default));
        for(int i=0;i<7;i++){
            c=new PdfPCell(new Paragraph((Horario[i]==0?"":""+Horario[i]),Default));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c);
        }
        return table;
}
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
  p=new Paragraph("Horario y número de horas diarias asignadas:",Default);
  c.addElement(p);
  c.addElement(new Paragraph(" "));
  c.addElement(getDiasAsignadasTable());
}
protected PdfPCell getCellTable3(String s){
    PdfPCell c=new PdfPCell(new Paragraph(s,Default));
    c.setPaddingTop(13.f);
    c.setPaddingBottom(13.f);
    c.setPaddingLeft(5.0f);
    return c;
}
protected PdfPTable getTable3(){
        float[] f ={0.25f,2.0f,1.0f,4.0f};
        PdfPTable table = new PdfPTable(f);   
        int i=0;
        table.addCell("");
        PdfPCell c;
        c=new PdfPCell(new Paragraph("CRITERIOS",h4));
        c.setPaddingBottom(13.f);
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("CALIFICACIÓN",h4));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        c=new PdfPCell(new Paragraph("OBSERVACIONES",h4));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setVerticalAlignment(Element.ALIGN_TOP);
        table.addCell(c);
        
        table.addCell(getCellTable3("1"));
        table.addCell(getCellTable3("Asistencia y puntualidad"));
        table.addCell(getCellTable3(""+(Calificacion[i]==-1?"":""+Calificacion[i])));
        table.addCell(getCellTable3(""+Observaciones[i]));
        i++;
        
        table.addCell(getCellTable3("2"));
        table.addCell(getCellTable3("Cumplimiento de tareas asignadas"));
        table.addCell(getCellTable3(""+(Calificacion[i]==-1?"":""+Calificacion[i])));
        table.addCell(getCellTable3(""+Observaciones[i]));
        i++;
        
        
        table.addCell(getCellTable3("3"));
        table.addCell(getCellTable3("Calidad en los trabajos realizados"));
         table.addCell(getCellTable3(""+(Calificacion[i]==-1?"":""+Calificacion[i])));
        table.addCell(getCellTable3(""+Observaciones[i]));
        i++;
        
        table.addCell(getCellTable3("4"));
        table.addCell(getCellTable3("Volumen de trabajo cubierto"));
         table.addCell(getCellTable3(""+(Calificacion[i]==-1?"":""+Calificacion[i])));
        table.addCell(getCellTable3(""+Observaciones[i]));
        i++;
        
        table.addCell(getCellTable3("5"));
        table.addCell(getCellTable3("Relaciones interpersonales actitudes"));
        table.addCell(getCellTable3(""+(Calificacion[i]==-1?"":""+Calificacion[i])));
        table.addCell(getCellTable3(""+Observaciones[i]));
        i++;
        
        return table;
}
protected PdfPCell getCell3(){
    float[] f ={1.0f};
    PdfPTable table = new PdfPTable(f);
    Paragraph p;
    PdfPCell c=new PdfPCell();
    c.setBorderColor(Color.WHITE);
    p=new Paragraph("VALORACIÓN DEL DESEMPEÑO",h3);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
    p=new Paragraph("Escala: 4: MS (Muy satisfactorio); 3: S(Satisfactorio); 2: PS (Poco satisfactorio); 1: I (Insatisfactorio)",Default);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);    
    table.addCell(c);
    
    c=new PdfPCell(getTable3());
    c.setBorderColor(Color.WHITE);
    table.addCell(c);
    
    PdfPCell result=new PdfPCell(table);
    result.setPadding(5.0f);
    return result;
}
protected void setCell4(PdfPCell c){
    c.addElement(new Paragraph("Lo mejor en su desempeño: ",Default));
    c.addElement(new Paragraph(" "+desempeño,Default));
    c.addElement(new Paragraph("Lo que debe mejorar: ",Default));
    c.addElement(new Paragraph(" "+mejorar,Default));
    c.addElement(new Paragraph(recomendado+" se lo-a recomienda para una nueva Ayudantía.",DefaultK));
}
protected void setCell5(PdfPCell c){
    Paragraph p;
    c.addElement(new Paragraph(" "));
    p=new Paragraph("Firma del Ayudante                                                       Firma del evaluador",DefaultK);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
    c.addElement(new Paragraph(" "));
    p=new Paragraph("Firma del Subdecano/Director/Subdirector",DefaultK);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
}
private void setCell6(PdfPCell c){
    Paragraph p;
    p=new Paragraph("El proceso de selección de ayudantes se enmarca dentro de las políticas afirmativas declaradas por la ESPOL.",DefaultK);
    p.setAlignment(Element.ALIGN_CENTER);
    c.addElement(p);
}
  private void createMainTable(Document subCatPart)throws BadElementException, DocumentException, MalformedURLException, IOException{
        float[] f ={1.0f};
        
        PdfPTable table = new PdfPTable(f);
        
        
        PdfPCell c1 = new PdfPCell (getTitleCell());//this line made the difference
        c1.setPadding(0);
        table.addCell(c1);
        
        PdfPCell c2 = new PdfPCell();
        c2.setPadding(12.0f);
        setCell2(c2);
        c2.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c2);
        
        PdfPCell c3 = getCell3();
        table.addCell(c3);
        
        PdfPCell c4 = new PdfPCell();
        setCell4(c4);
        c4.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c4);
        
        PdfPCell c5 = new PdfPCell();
        setCell5(c5);
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c5);
        
        PdfPCell c6 = new PdfPCell();
        setCell6(c6);
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c6);
  
    subCatPart.add(table);
  }
  private void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
  public void generate(){
        try{
         Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
         document.open();
         addContent(document);
         document.close();
        }catch(Exception e){
            System.out.println("Generacion de pdf fallido");
        }
        
    }
}

