package modelos;
// Generated 01-may-2023 0:06:26 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Mensajes generated by hbm2java
 */
public class Mensajes  implements java.io.Serializable {


     private Integer id;
     private Chats chats;
     private Usuarios usuariosByRemitenteId;
     private Usuarios usuariosByDestinatarioId;
     private String texto;
     private Date fechaEnvio;

    public Mensajes() {
    }

    public Mensajes(Chats chats, Usuarios usuariosByRemitenteId, Usuarios usuariosByDestinatarioId, String texto, Date fechaEnvio) {
       this.chats = chats;
       this.usuariosByRemitenteId = usuariosByRemitenteId;
       this.usuariosByDestinatarioId = usuariosByDestinatarioId;
       this.texto = texto;
       this.fechaEnvio = fechaEnvio;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Chats getChats() {
        return this.chats;
    }
    
    public void setChats(Chats chats) {
        this.chats = chats;
    }
    public Usuarios getUsuariosByRemitenteId() {
        return this.usuariosByRemitenteId;
    }
    
    public void setUsuariosByRemitenteId(Usuarios usuariosByRemitenteId) {
        this.usuariosByRemitenteId = usuariosByRemitenteId;
    }
    public Usuarios getUsuariosByDestinatarioId() {
        return this.usuariosByDestinatarioId;
    }
    
    public void setUsuariosByDestinatarioId(Usuarios usuariosByDestinatarioId) {
        this.usuariosByDestinatarioId = usuariosByDestinatarioId;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }
    
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }




}


