/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelos.Facultades;
import modelos.TarjetasDeCredito;
import modelos.Usuarios;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import persistencia.DAO_facultades;
import persistencia.DAO_tarjeta;
import persistencia.DAO_usuario;

public class perfilAcciones extends ActionSupport {

    private final DAO_facultades dao_f;
    private final DAO_tarjeta dao_t;
    private final DAO_usuario dao_u;

    private String passwordConfirm;
    private String password;
    private String email;
    private String dni;
    private String orientacion;
    private String facultad;
    private String ocupacion;
    private String idioma;
    private String bio;
    private String edad;
    private File image;
    private String imageContentType;
    private String imageFileName;

    private Usuarios u;
    private int usuarioId;

    private List<String> facultades;
    private List<TarjetasDeCredito> tarjetasUsuario;
    private String fac;

    public perfilAcciones() {
        dao_f = new DAO_facultades();
        dao_t = new DAO_tarjeta();
        dao_u = new DAO_usuario();
        facultades = new ArrayList();
        tarjetasUsuario = new ArrayList();
        u = new Usuarios();
    }

    public void validate() {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.getEmail());

        if (0 == this.getEmail().length() || null == this.getEmail()) {
            addFieldError("correo", getText("correo.relleno"));
        } else {
            if (!matcher.matches()) {
                addFieldError("correo", getText("correo.formato"));
            } else {
                if (comprobarCorreos()) {
                    addFieldError("correo", getText("correo.existente"));
                }
            }
        }
        if (0 == this.getPassword().length() || null == this.getPassword()) {
            addFieldError("password", getText("contrasenia.rellena"));
        } else if (0 == this.getPasswordConfirm().length() || null == this.getPasswordConfirm()) {
            addFieldError("passwordConfirm", getText("contrasenia.rellena"));
        } else if (!this.getPassword().equals(this.getPasswordConfirm())) {
            addFieldError("passwordConfirm", getText("contrasenia.diferente"));
        }
        if (0 == this.getOrientacion().length() || null == this.getOrientacion()) {
            addFieldError("orientacion", getText("orientacion.rellena"));
        }
        if (0 == this.getFacultad().length() || null == this.getFacultad()) {
            addFieldError("facultad", getText("facultad.rellena"));
        }
        if (0 == this.getOcupacion().length() || null == this.getOcupacion()) {
            addFieldError("ocupacion", getText("ocupacion.rellena"));
        }
        if (0 == this.getIdioma().length() || null == this.getIdioma()) {
            addFieldError("idioma", getText("idioma.relleno"));
        }
        if (0 == this.getEdad().length() || null == this.getEdad()) {
            addFieldError("edad", getText("edad.rellena"));
        }
        
        if(this.getImageFileName() != null) {
            if (!this.getImageFileName().substring(this.getImageFileName().lastIndexOf(".")).equalsIgnoreCase(".jpeg")
                    && !this.getImageFileName().substring(this.getImageFileName().lastIndexOf(".")).equalsIgnoreCase(".png")
                    && !this.getImageFileName().substring(this.getImageFileName().lastIndexOf(".")).equalsIgnoreCase(".jpg")) {
                addFieldError("image", "Formato no válido, debe ser jpeg, jpg o png");
            }
        }

        Map session = (Map) ActionContext.getContext().get("session");
        Usuarios user = (Usuarios) session.get("user");
        this.setFac(dao_f.getFacultadId(user.getId()));

        this.setFacultades(this.dao_f.listadoFacultades());
        this.setTarjetasUsuario(this.dao_t.obtenerTarjetasDeCredito(user.getId()));

    }
    
    /*
    Obtenemos la facultad del usuario mediante la id.
    Obtenemos todas las facultades guardadas en la base de datos.
    Obtenemos las tarjetas asociadas al usuario activo.
    */
    @SkipValidation
    public String execute() throws Exception {

        Map session = (Map) ActionContext.getContext().get("session");
        Usuarios user = (Usuarios) session.get("user");

        this.setFac(dao_f.getFacultadId(user.getId()));

        this.setFacultades(this.dao_f.listadoFacultades());
        this.setTarjetasUsuario(this.dao_t.obtenerTarjetasDeCredito(user.getId()));

        return SUCCESS;
    }
    
    /*Editar perfil
    Seteamos de nuevo todos los atributos del usuario por si estos
    han sufrido cambios.
    Obtenemos la facultad mediante el nombre.
    Actualizamos el usuario y reemplazamos en la sesión al nuevo usuario
    sus datos actualizados.
    */
    public String actualizar() throws IOException {

        System.out.println("entro");
        Map session = (Map) ActionContext.getContext().get("session");
        Usuarios user = (Usuarios) session.get("user");
        Facultades facultad = this.dao_f.getFacultadNombre(this.getFacultad());

        user.setCorreo(this.getEmail());

        if (this.getDni().equals("")) {
            user.setDni(null);
        } else {
            user.setDni(this.getDni());
        }
        
        if (this.getImage() != null) {
            String filePath = ServletActionContext.getServletContext().getRealPath("/Fotos_usuarios");
            System.out.println(filePath);
            filePath = filePath.replace("\\build", "");
            System.out.println(filePath);
            String fileName = UUID.randomUUID().toString().replace("-", "") + imageFileName.substring(imageFileName.lastIndexOf("."));

            FileUtils.copyFile(this.getImage(), new File(filePath, fileName));

            user.setFotoPerfil("/Fotos_usuarios/" + fileName);
        }

        user.setEdad(Integer.parseInt(this.getEdad()));
        user.setFacultades(facultad);
        user.setIdioma(this.getIdioma());
        user.setOcupacion(this.getOcupacion());
        user.setOrientacion(this.getOrientacion());
        user.setBiografia(this.getBio());
        user.setPassword(this.getPassword());

        this.dao_u.actualizarUsuario(user);

        session.replace("user", user);

        return SUCCESS;
    }

    /*
    Obtenemos el usuario a partil del id al igual que la facultad
    y los setemos a los atributos de la clase U y Fac.
    */
    @SkipValidation
    public String cargarPerfil() {

        this.setU(this.dao_u.obtenerUsuarioId(this.getUsuarioId()));

        this.setFac(dao_f.getFacultadId(this.getUsuarioId()));

        return SUCCESS;
    }
    
    /*
    Obtenemos todos los correos de los usuario menos el del usuario activo.
    Para comprobar que el correo introducido no existe ya en la base de datos.
    */
    private boolean comprobarCorreos() {
        boolean encontrado = false;
        Map session = (Map) ActionContext.getContext().get("session");
        Usuarios user = (Usuarios) session.get("user");
        List<String> correos = this.dao_u.obtenerCorreosU(user.getId());

        System.out.println(correos.toString());

        for (String correo : correos) {

            if (correo.equals(this.getEmail())) {
                encontrado = true;
            }

        }

        return encontrado;
    }

    public List<String> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<String> facultades) {
        this.facultades = facultades;
    }

    public List<TarjetasDeCredito> getTarjetasUsuario() {
        return tarjetasUsuario;
    }

    public void setTarjetasUsuario(List<TarjetasDeCredito> tarjetasUsuario) {
        this.tarjetasUsuario = tarjetasUsuario;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Usuarios getU() {
        return u;
    }

    public void setU(Usuarios u) {
        this.u = u;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

}
