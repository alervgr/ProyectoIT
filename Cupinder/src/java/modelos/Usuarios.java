package modelos;
// Generated 01-may-2023 0:06:26 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer id;
     private Facultades facultades;
     private String usuario;
     private String nombre;
     private String apellidos;
     private String dni;
     private int edad;
     private String correo;
     private String password;
     private String genero;
     private String biografia;
     private String orientacion;
     private String fotoPerfil;
     private Date fechaRegistro;
     private String idioma;
     private String rol;
     private String ocupacion;
     private Set coincidenciasesForUsuario1Id = new HashSet(0);
     private Set usuarioIntereseses = new HashSet(0);
     private Set coincidenciasesForUsuario2Id = new HashSet(0);
     private Set tarjetasDeCreditos = new HashSet(0);
     private Set mensajesesForRemitenteId = new HashSet(0);
     private Set mensajesesForDestinatarioId = new HashSet(0);
     private Set usuarioPersonalidadeses = new HashSet(0);
     private Set chatsesForUsuario1Id = new HashSet(0);
     private Set chatsesForUsuario2Id = new HashSet(0);

    public Usuarios() {
    }

    public Usuarios(Facultades facultades, String usuario, String nombre, String apellidos, int edad, String correo, String password, String genero, String biografia, String orientacion, Date fechaRegistro, String idioma, String rol, String ocupacion) {
        this.facultades = facultades;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.password = password;
        this.genero = genero;
        this.biografia = biografia;
        this.orientacion = orientacion;
        this.fechaRegistro = fechaRegistro;
        this.idioma = idioma;
        this.rol = rol;
        this.ocupacion = ocupacion;
    }

	
    public Usuarios(Facultades facultades, String usuario, String nombre, String apellidos, String dni, int edad, String correo, String password, String genero, String biografia, String orientacion, Date fechaRegistro, String idioma, String rol) {
        this.facultades = facultades;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.correo = correo;
        this.password = password;
        this.genero = genero;
        this.biografia = biografia;
        this.orientacion = orientacion;
        this.fechaRegistro = fechaRegistro;
        this.idioma = idioma;
        this.rol = rol;
    }
    public Usuarios(Facultades facultades, String usuario, String nombre, String apellidos, String dni, int edad, String correo, String password, String genero, String biografia, String orientacion, String fotoPerfil, Date fechaRegistro, String idioma, String rol, String ocupacion, Set coincidenciasesForUsuario1Id, Set usuarioIntereseses, Set coincidenciasesForUsuario2Id, Set tarjetasDeCreditos, Set mensajesesForRemitenteId, Set mensajesesForDestinatarioId, Set usuarioPersonalidadeses, Set chatsesForUsuario1Id, Set chatsesForUsuario2Id) {
       this.facultades = facultades;
       this.usuario = usuario;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.dni = dni;
       this.edad = edad;
       this.correo = correo;
       this.password = password;
       this.genero = genero;
       this.biografia = biografia;
       this.orientacion = orientacion;
       this.fotoPerfil = fotoPerfil;
       this.fechaRegistro = fechaRegistro;
       this.idioma = idioma;
       this.rol = rol;
       this.ocupacion = ocupacion;
       this.coincidenciasesForUsuario1Id = coincidenciasesForUsuario1Id;
       this.usuarioIntereseses = usuarioIntereseses;
       this.coincidenciasesForUsuario2Id = coincidenciasesForUsuario2Id;
       this.tarjetasDeCreditos = tarjetasDeCreditos;
       this.mensajesesForRemitenteId = mensajesesForRemitenteId;
       this.mensajesesForDestinatarioId = mensajesesForDestinatarioId;
       this.usuarioPersonalidadeses = usuarioPersonalidadeses;
       this.chatsesForUsuario1Id = chatsesForUsuario1Id;
       this.chatsesForUsuario2Id = chatsesForUsuario2Id;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Facultades getFacultades() {
        return this.facultades;
    }
    
    public void setFacultades(Facultades facultades) {
        this.facultades = facultades;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getBiografia() {
        return this.biografia;
    }
    
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    public String getOrientacion() {
        return this.orientacion;
    }
    
    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }
    public String getFotoPerfil() {
        return this.fotoPerfil;
    }
    
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getIdioma() {
        return this.idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getOcupacion() {
        return this.ocupacion;
    }
    
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public Set getCoincidenciasesForUsuario1Id() {
        return this.coincidenciasesForUsuario1Id;
    }
    
    public void setCoincidenciasesForUsuario1Id(Set coincidenciasesForUsuario1Id) {
        this.coincidenciasesForUsuario1Id = coincidenciasesForUsuario1Id;
    }
    public Set getUsuarioIntereseses() {
        return this.usuarioIntereseses;
    }
    
    public void setUsuarioIntereseses(Set usuarioIntereseses) {
        this.usuarioIntereseses = usuarioIntereseses;
    }
    public Set getCoincidenciasesForUsuario2Id() {
        return this.coincidenciasesForUsuario2Id;
    }
    
    public void setCoincidenciasesForUsuario2Id(Set coincidenciasesForUsuario2Id) {
        this.coincidenciasesForUsuario2Id = coincidenciasesForUsuario2Id;
    }
    public Set getTarjetasDeCreditos() {
        return this.tarjetasDeCreditos;
    }
    
    public void setTarjetasDeCreditos(Set tarjetasDeCreditos) {
        this.tarjetasDeCreditos = tarjetasDeCreditos;
    }
    public Set getMensajesesForRemitenteId() {
        return this.mensajesesForRemitenteId;
    }
    
    public void setMensajesesForRemitenteId(Set mensajesesForRemitenteId) {
        this.mensajesesForRemitenteId = mensajesesForRemitenteId;
    }
    public Set getMensajesesForDestinatarioId() {
        return this.mensajesesForDestinatarioId;
    }
    
    public void setMensajesesForDestinatarioId(Set mensajesesForDestinatarioId) {
        this.mensajesesForDestinatarioId = mensajesesForDestinatarioId;
    }
    public Set getUsuarioPersonalidadeses() {
        return this.usuarioPersonalidadeses;
    }
    
    public void setUsuarioPersonalidadeses(Set usuarioPersonalidadeses) {
        this.usuarioPersonalidadeses = usuarioPersonalidadeses;
    }
    public Set getChatsesForUsuario1Id() {
        return this.chatsesForUsuario1Id;
    }
    
    public void setChatsesForUsuario1Id(Set chatsesForUsuario1Id) {
        this.chatsesForUsuario1Id = chatsesForUsuario1Id;
    }
    public Set getChatsesForUsuario2Id() {
        return this.chatsesForUsuario2Id;
    }
    
    public void setChatsesForUsuario2Id(Set chatsesForUsuario2Id) {
        this.chatsesForUsuario2Id = chatsesForUsuario2Id;
    }




}


