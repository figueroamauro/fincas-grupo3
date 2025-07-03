package com.example.fincas_grupo3.infrastructure.entities.usuario;

import com.example.fincas_grupo3.infrastructure.entities.direccion.DireccionEntidad;
import com.example.fincas_grupo3.infrastructure.entities.rol.RolEntidad;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class UsuarioEntidad  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private  String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "correo",nullable = false,unique = true)
    private String correo;
    @Column(name = "contrasenia",nullable = false)
    private String contraseña;
    @Column(name = "telefono",nullable = false)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", unique = true)
    private DireccionEntidad direccion;

    @ManyToMany
    @JoinTable(
            name = "rol_usuarios",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RolEntidad> roles;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(Long id, String nombre, String apellido, String correo, String contraseña, String telefono, DireccionEntidad direccion, Set<RolEntidad> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.direccion = direccion;
        this.roles = roles;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionEntidad getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntidad direccion) {
        this.direccion = direccion;
    }

    public Set<RolEntidad> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolEntidad> roles) {
        this.roles = roles;
    }
}