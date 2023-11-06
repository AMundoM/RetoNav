package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioDBRepositoryTest {

    private IUsuarioRepository repo;

    @BeforeEach
    void setUp() {
//        repo = new UsuarioInMemoryRepository();
        repo = new UsuarioDBRepository();
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioEnDB_entoncesOK() throws Exception {
        boolean existe = repo.existeUsuario("juana@e.com", "juanason_1");
        assertThat(existe, is(true));
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioNoEnDB_entoncesNOK() throws Exception {
        boolean existe = repo.existeUsuario("xxxx@e.com", "xxxx");
        assertThat(existe, is(false));
    }

    @Test
    void dadosUsuarios_cuandogetUsuarioEnDB_entoncesUsuario() throws Exception {
        Usuario usuario = repo.getUsuario("juana@e.com", "juanason_1");

        System.out.println(usuario);

        assertThat(usuario.getEmail(), is("juana@e.com"));

    }

    @Test
    void dadosUsuarios_cuandogetUsuarioNoEnDB_entoncesExcepcion() {

        assertThrows(UsuarioNotFoundException.class, () -> {
            Usuario usuario = repo.getUsuario("xxxx@e.com", "xxxx");
        });

    }

}