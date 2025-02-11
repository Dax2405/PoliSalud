package DataAccess.DTO;

public class PacienteDTO {
    private Integer idPaciente;
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private String email;
    private String telefono;
    private String fechaNacimiento;
    private String direccion;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    public PacienteDTO() {
    }
    public PacienteDTO(Integer idPaciente, String nombre, String apellido, String codigoUnico, String email, String telefono, String fechaNacimiento, String direccion, String estado, String fechaCrea, String fechaModifica) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }
    
    
    public Integer getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFechaCrea() {
        return fechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return fechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    @Override
    public String toString(){
        return getClass().getName()
            + "\n IdPaciente: " + getIdPaciente()
            + "\n Nombre: " + getNombre()
            + "\n Apellido: " + getApellido()
            + "\n CodigoUnico: " + getCodigoUnico()
            + "\n Email: " + getEmail()
            + "\n Telefono: " + getTelefono()
            + "\n FechaNacimiento: " + getFechaNacimiento()
            + "\n Direccion: " + getDireccion()
            + "\n Estado: " + getEstado()
            + "\n FechaCrea: " + getFechaCrea()
            + "\n FechaModifica: " + getFechaModifica();
    } 
}
