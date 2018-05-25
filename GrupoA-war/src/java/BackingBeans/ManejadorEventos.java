/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modeloJPA.Evento;

/**
 *
 * @author PC
 */

@ManagedBean(name="manejadorEventos", eager=true)
@SessionScoped
public class ManejadorEventos implements Serializable{
    
    private List<Evento> eventos;
    private String nombreEvento;
    private Evento evento;
    private int dia,mes,ano;
    private String loc;
    private float precio,pres;
    private String dsc;
    public ManejadorEventos(){
        eventos = new ArrayList<>();
        eventos.add(new Evento(1L,"Salida a la montaña",new Date(20180618111111L),"Malaga",300,30,"Alice was beginning to get very tired of sitting by her sister\n" +
"on the bank, and of having nothing to do:  once or twice she had\n" +
"peeped into the book her sister was reading, but it had no\n" +
"pictures or conversations in it, `and what is the use of a book,'\n" +
"thought Alice `without pictures or conversation?'\n" +
"\n" +
"  So she was considering in her own mind (as well as she could,\n" +
"for the hot day made her feel very sleepy and stupid), whether\n" +
"the pleasure of making a daisy-chain would be worth the trouble\n" +
"of getting up and picking the daisies, when suddenly a White\n" +
"Rabbit with pink eyes ran close by her.\n" +
"\n" +
"  There was nothing so VERY remarkable in that; nor did Alice\n" +
"think it so VERY much out of the way to hear the Rabbit say to\n" +
"itself, `Oh dear!  Oh dear!  I shall be late!'  (when she thought\n" +
"it over afterwards, it occurred to her that she ought to have\n" +
"wondered at this, but at the time it all seemed quite natural);\n" +
"but when the Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT-\n" +
"POCKET, and looked at it, and then hurried on, Alice started to\n" +
"her feet, for it flashed across her mind that she had never\n" +
"before seen a rabbit with either a waistcoat-pocket, or a watch to\n" +
"take out of it, and burning with curiosity, she ran across the\n" +
"field after it, and fortunately was just in time to see it pop\n" +
"down a large rabbit-hole under the hedge."));
       eventos.add(new Evento(2L,"Salida a la playa",new Date(2018,7,28),"Granada",300,30,"In another moment down went Alice after it, never once\n" +
"considering how in the world she was to get out again.\n" +
"\n" +
"  The rabbit-hole went straight on like a tunnel for some way,\n" +
"and then dipped suddenly down, so suddenly that Alice had not a\n" +
"moment to think about stopping herself before she found herself\n" +
"falling down a very deep well.\n" +
"\n" +
"  Either the well was very deep, or she fell very slowly, for she\n" +
"had plenty of time as she went down to look about her and to\n" +
"wonder what was going to happen next.  First, she tried to look\n" +
"down and make out what she was coming to, but it was too dark to\n" +
"see anything; then she looked at the sides of the well, and\n" +
"noticed that they were filled with cupboards and book-shelves;\n" +
"here and there she saw maps and pictures hung upon pegs.  She\n" +
"took down a jar from one of the shelves as she passed; it was\n" +
"labelled `ORANGE MARMALADE', but to her great disappointment it\n" +
"was empty:  she did not like to drop the jar for fear of killing\n" +
"somebody, so managed to put it into one of the cupboards as she\n" +
"fell past it."));
       eventos.add(new Evento(3L,"Salida a la ciudad",new Date(2018,8,8),"Sevilla",300,30,"`Well!' thought Alice to herself, `after such a fall as this, I\n" +
"shall think nothing of tumbling down stairs!  How brave they'll\n" +
"all think me at home!  Why, I wouldn't say anything about it,\n" +
"even if I fell off the top of the house!' (Which was very likely\n" +
"true.)\n" +
"\n" +
"  Down, down, down.  Would the fall NEVER come to an end!  `I\n" +
"wonder how many miles I've fallen by this time?' she said aloud.\n" +
"`I must be getting somewhere near the centre of the earth.  Let\n" +
"me see:  that would be four thousand miles down, I think--' (for,\n" +
"you see, Alice had learnt several things of this sort in her\n" +
"lessons in the schoolroom, and though this was not a VERY good\n" +
"opportunity for showing off her knowledge, as there was no one to\n" +
"listen to her, still it was good practice to say it over) `--yes,\n" +
"that's about the right distance--but then I wonder what Latitude\n" +
"or Longitude I've got to?'  (Alice had no idea what Latitude was,\n" +
"or Longitude either, but thought they were nice grand words to\n" +
"say.)"));
       eventos.add(new Evento(4L,"Salida a Madrid",new Date(2018,10,15),"Madrid",300,30," Presently she began again.  `I wonder if I shall fall right\n" +
"THROUGH the earth!  How funny it'll seem to come out among the\n" +
"people that walk with their heads downward!  The Antipathies, I\n" +
"think--' (she was rather glad there WAS no one listening, this\n" +
"time, as it didn't sound at all the right word) `--but I shall\n" +
"have to ask them what the name of the country is, you know.\n" +
"Please, Ma'am, is this New Zealand or Australia?' (and she tried\n" +
"to curtsey as she spoke--fancy CURTSEYING as you're falling\n" +
"through the air!  Do you think you could manage it?)  `And what\n" +
"an ignorant little girl she'll think me for asking!  No, it'll\n" +
"never do to ask:  perhaps I shall see it written up somewhere.'\n" +
"\n" +
"  Down, down, down.  There was nothing else to do, so Alice soon\n" +
"began talking again.  `Dinah'll miss me very much to-night, I\n" +
"should think!'  (Dinah was the cat.)  `I hope they'll remember\n" +
"her saucer of milk at tea-time.  Dinah my dear!  I wish you were\n" +
"down here with me!  There are no mice in the air, I'm afraid, but\n" +
"you might catch a bat, and that's very like a mouse, you know.\n" +
"But do cats eat bats, I wonder?'  And here Alice began to get\n" +
"rather sleepy, and went on saying to herself, in a dreamy sort of\n" +
"way, `Do cats eat bats?  Do cats eat bats?' and sometimes, `Do\n" +
"bats eat cats?' for, you see, as she couldn't answer either\n" +
"question, it didn't much matter which way she put it.  She felt\n" +
"that she was dozing off, and had just begun to dream that she\n" +
"was walking hand in hand with Dinah, and saying to her very\n" +
"earnestly, `Now, Dinah, tell me the truth:  did you ever eat a\n" +
"bat?' when suddenly, thump! thump! down she came upon a heap of\n" +
"sticks and dry leaves, and the fall was over."));
    }
    public void crearEvento(){
        Random r = new Random(System.currentTimeMillis());
        eventos.add(new Evento(r.nextLong(),nombreEvento,new Date(2018, getMes(), getDia()), getLoc(), getPrecio(), getPres(), getDsc()));
    }
    
    public List<Evento> getEventos(){      
        return eventos;
    }
    
    public void setNombreEvento(String nombreEvento){
        this.nombreEvento=nombreEvento;
    }
    
    public String getNombreEvento(){
        return nombreEvento;
    }
    
    
    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the pres
     */
    public float getPres() {
        return pres;
    }

    /**
     * @param pres the pres to set
     */
    public void setPres(float pres) {
        this.pres = pres;
    }

    /**
     * @return the dsc
     */
    public String getDsc() {
        return dsc;
    }

    /**
     * @param dsc the dsc to set
     */
    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
