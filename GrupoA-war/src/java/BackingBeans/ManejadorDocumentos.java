package BackingBeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Inject;


import javax.servlet.http.Part;
import modeloJPA.Documento;



/**
 *
 * @author PC
 */
@ManagedBean(name = "manejadorDocumentos", eager = true)
@SessionScoped
public class ManejadorDocumentos implements Serializable {

    private List<Documento> documentos;
    private String nombreDocumento;
    private Documento documento;
    private Part fich;

    
    public ManejadorDocumentos(){

        documentos = new ArrayList<>();
        documentos.add(new Documento(1L, "Documento 1", "Modificandose", "contenido del documentos", ".txt"));
        documentos.add(new Documento(2L, "Documento 2", "Actualizado", "contenido del documentos2 esta lleno", ".txt"));
        documentos.add(new Documento(3L, "Documento 3", "Finalizado", "contenido del documentos, final", ".txt"));
        documentos.add(new Documento(4L, "Documento 4", "Actualizado", "contenido del documento4 esta completo", ".txt"));
    }

    /**
     * @return the documentos
     */
    public List<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the nombreDocumento
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * @param nombreDocumento the nombreDocumento to set
     */
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    /**
     * @return the documento
     */
    public Documento getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    /**
     * @return the fich
     */
    public Part getFich() {
        return fich;
    }

    /**
     * @param fich the fich to set
     */
    public void setFich(Part fich) {
        this.fich = fich;
    }

    public void subir() throws IOException {
        try (InputStream input = fich.getInputStream()) {
            Files.copy(input, new File("C:/Users/PC/Documents/doc.pdf").toPath());
        }
    }
    
    
    
    public String getFileName(Part part)
    {
        for(String cd:part.getHeader("content-disposition").split(";"))
            if(cd.trim().startsWith("filename")){
                String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
                return filename;
            }
        return "";
                
    }
    public void upload()
    {
        try{
        fich.write("C:/Users/PC/Documents/"+getFileName(fich));
        }
        catch(Exception ex)
        {
            System.err.print(ex);
        }
    }
}
