/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author gutir
 */
@Named(value = "controlDocumento")
@SessionScoped
public class ControlDocumento implements Serializable {

    private Part archivo;
    
    private String nombre_usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    public Part getArchivo() {
        return archivo;
    }

    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

    
    
 public void descargarArchivo() throws IOException {
     
    File fich = new File("C:\\Users\\gutir\\Documents\\documento_descargar.pdf");
    FacesContext ctx = FacesContext.getCurrentInstance();
    FileInputStream fis = new FileInputStream(fich);
    byte[] bytes = new byte[1000];
    int read = 0;

    if (!ctx.getResponseComplete()) {
       String fileName = "informe.pdf";
       String contentType = "application/pdf";
       HttpServletResponse response =(HttpServletResponse) ctx.getExternalContext().getResponse();
       response.setContentType(contentType);
       response.setHeader("Content-Disposition","attachment;filename=\"" + fileName + "\"");
       ServletOutputStream out = response.getOutputStream();

       while ((read = fis.read(bytes)) != -1) {
            out.write(bytes, 0, read);
       }

       out.flush();
       out.close();
       ctx.responseComplete();

        } 
     
    /* File file = new File("C:\\Users\\gutir\\Documents\\documento_descargar");
     InputStream fis = new FileInputStream(file);
     byte[] buf = new byte[1024];
     int offset = 0;
     int numRead = 0;
     
     while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
       offset += numRead;
     }
     
     fis.close();
     HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment;filename=prueba.pdf");
    response.getOutputStream().write(buf);
    response.getOutputStream().flush();
    response.getOutputStream().close();
    FacesContext.getCurrentInstance().responseComplete();*/
  }
    
    public void subirArchivo(){
        try{
            String foto_usuario = nombre_usuario;
            InputStream input = archivo.getInputStream();
            File file = new File("C:\\Users\\gutir\\Documents\\INFORMÁTICA\\SISTEMAS DE INFORMACIÓN PARA INTERNET\\GITHUB\\GrupoScoutWeb\\web\\imagenes\\fotos_usuarios\\"+foto_usuario+".jpg");
            
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileOutputStream output = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            
            while((length=input.read(buffer))>0){
                output.write(buffer, 0, length);
            }
            
            input.close();
            output.close();
            
        } catch(Exception e){
            e.printStackTrace(System.out);
        }
    }
 
    public ControlDocumento() {
    }
    
}
