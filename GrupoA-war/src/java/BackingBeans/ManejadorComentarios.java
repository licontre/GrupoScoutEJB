/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modeloJPA.Comentario;

/**
 *
 * @author PC
 */
@ManagedBean(name="manejadorComentarios", eager=true)
@SessionScoped
public class ManejadorComentarios {
    
    private List<Comentario> comentarios;
    private String comment;
    
    public ManejadorComentarios(){
        comentarios=new ArrayList<>();
        comentarios.add(new Comentario(new Date(20181103111009L),"Soon her eye fell on a little glass box that was lying under\n" +
"the table:  she opened it, and found in it a very small cake, on\n" +
"which the words `EAT ME'"));
        comentarios.add(new Comentario(new Date(20181103112009L),"Well, I'll eat it,' said Alice, `and if it makes me grow larger,\n" +
"I can reach the key; and if it makes me grow smaller, I can creep\n" +
"under the door; so either way"));
        comentarios.add(new Comentario(new Date(20181103131009L),"She ate a little bit, and said anxiously to herself, `Which\n" +
"way?  Which way?', holding her hand on the top of her head to\n" +
"feel which way "));
        comentarios.add(new Comentario(new Date(20181103141009L),"it was growing, and she was quite surprised to\n" +
"find that she remained the same size:  to be sure, this generally\n" +
"happens when one eats cake, but Alice had got so much into the\n" +
"way of expecting nothing but out-of-the-way things to happen,"));
        comentarios.add(new Comentario(new Date(20181103151009L),"that it seemed quite dull and stupid for life to go on in the\n" +
"common way."));
    }
    
    
    public List<Comentario> getComentarios(){
        return comentarios;
    }
    
    public void addComentarios(){
        comentarios.add(new Comentario(new Date(),comment));
    }
    
    public String getComment(){
        return comment;
    }
    
   public void setComment(String comment){
       this.comment=comment;
   }
    
}
