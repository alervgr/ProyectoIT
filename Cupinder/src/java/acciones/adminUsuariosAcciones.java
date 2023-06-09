/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import modelos.*;
import modelos.Mensajes;
import modelos.Usuarios;
import org.apache.struts2.interceptor.validation.SkipValidation;
import persistencia.DAO_chat;
import persistencia.DAO_usuario;

/**
 *
 * @author victo
 */
public class adminUsuariosAcciones extends ActionSupport {

    private final DAO_usuario dao_u;
    private final DAO_chat dao_c;
    private List<Usuarios> listaUsuarios;
    private List<Mensajes> listaMensajes;
    private List<Chats> listaChats;
    private List<UsuarioIntereses> listaUsuarioIntereses;
    private List<TarjetasDeCredito> listaTarjetas;
    private List<UsuarioPersonalidades> listaUsuarioPer;
    private List<Coincidencias> listaCoincidencias;

    private int idUsuario;

    public List<Mensajes> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensajes> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public adminUsuariosAcciones() {
        listaUsuarios = new ArrayList();
        dao_u = new DAO_usuario();
        dao_c = new DAO_chat();
    }
    
    /*
    Obtenemos la lista de usuario exluyendo el Usuario que está
    haciendo uso del sistema para evitar que se pueda eliminar a
    sí mismo.
    */
    public String execute() throws Exception {

        Map session = (Map) ActionContext.getContext().get("session");

        Usuarios user = (Usuarios) session.get("user");

        this.setListaUsuarios(this.dao_u.listaUsuariosSinCurrent(user.getId()));

        return SUCCESS;
    }
    
    
    /*Eliminar a un usuario
    Obtenemos el usuario a partir de su id.
    Debemos asegurarnos de eliminar previamente todas sus dependencias con las 
    demás tablas de la base datos para que nos permita eliminar el usuario.
    */
    @SkipValidation
    public String eliminarUsuario() throws Exception {

        //Borramos coincidencias
        this.setListaMensajes(this.dao_c.listarMensajesUsuario(this.getIdUsuario()));
        if (this.getListaMensajes().size() != 0) {
            for (int i = 0; i < this.getListaMensajes().size(); i++) {
                
                this.dao_c.eliminarMensaje(this.getListaMensajes().get(i));
            }
        }

        //borramos coincidencias del usuario
     
        this.setListaCoincidencias(this.dao_c.listarCoincidencias(this.getIdUsuario()));
        if (this.getListaCoincidencias().size() != 0) {
            for (int i = 0; i < this.getListaCoincidencias().size(); i++) {
                
                this.dao_c.eliminarCoincidencia(this.getListaCoincidencias().get(i));
            }
        }

        //borramos chats del usuario
  
        this.setListaChats(this.dao_c.listarChatsUsuario(this.getIdUsuario()));
        if (this.getListaChats().size() != 0 || this.getListaChats() != null) {
            for (int i = 0; i < this.getListaChats().size(); i++) {
                
                this.dao_c.eliminarChat(this.getListaChats().get(i));
            }
        }

        //borrar tarjetas de credito 
        
        this.setListaTarjetas(this.dao_c.listarTarjetasUsuario(idUsuario));
        if (this.getListaTarjetas().size() != 0 || this.getListaTarjetas() != null) {
            for (int i = 0; i < this.getListaTarjetas().size(); i++) {
                
                this.dao_c.eliminarTarjeta(this.getListaTarjetas().get(i));
            }
        }

        //borrar usuarios intereses
        
        this.setListaUsuarioIntereses(this.dao_c.listarUsuarioIntereses(idUsuario));
        if (this.getListaUsuarioIntereses().size() != 0 || this.getListaUsuarioIntereses() != null) {
            
            for (int i = 0; i < this.getListaUsuarioIntereses().size(); i++) {
                this.dao_c.eliminarUsuarioInteres(this.getListaUsuarioIntereses().get(i));
            }
        }

        //borrar usuarios personalidades
        
        this.setListaUsuarioPer(this.dao_c.listarUsuarioPersonalidades(idUsuario));
        if (this.getListaUsuarioPer().size() != 0 || this.getListaUsuarioPer() != null) {
            
            for (int i = 0; i < this.getListaUsuarioPer().size(); i++) {
                this.dao_c.eliminarUsuarioPersonalidad(this.getListaUsuarioPer().get(i));
            }
        }

        //borrar usuario
        
        Usuarios eliminar = this.dao_u.obtenerUsuarioId(this.getIdUsuario());
        
        this.dao_u.eliminarUsuario(eliminar);

        //Cargamos de nuevo la lista de usuario
        Map session = (Map) ActionContext.getContext().get("session");

        Usuarios user = (Usuarios) session.get("user");

        this.setListaUsuarios(this.dao_u.listaUsuariosSinCurrent(user.getId()));

        return SUCCESS;
    }

    public List<Coincidencias> getListaCoincidencias() {
        return listaCoincidencias;
    }

    public void setListaCoincidencias(List<Coincidencias> listaCoincidencias) {
        this.listaCoincidencias = listaCoincidencias;
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Chats> getListaChats() {
        return listaChats;
    }

    public void setListaChats(List<Chats> listaChats) {
        this.listaChats = listaChats;
    }

    public List<UsuarioIntereses> getListaUsuarioIntereses() {
        return listaUsuarioIntereses;
    }

    public void setListaUsuarioIntereses(List<UsuarioIntereses> listaUsuarioIntereses) {
        this.listaUsuarioIntereses = listaUsuarioIntereses;
    }

    public List<TarjetasDeCredito> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(List<TarjetasDeCredito> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public List<UsuarioPersonalidades> getListaUsuarioPer() {
        return listaUsuarioPer;
    }

    public void setListaUsuarioPer(List<UsuarioPersonalidades> listaUsuarioPer) {
        this.listaUsuarioPer = listaUsuarioPer;
    }

}
