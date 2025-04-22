package es.mahoramas.lolpedia.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioEntityTest {
    UsuarioEntity usuarioEntity;
    @BeforeEach
    void setUp(){
        usuarioEntity = new UsuarioEntity("elpro", "123", "mati", "matielpro@gmail.com");
    }

    @Test
    void TestConstructorEmail(){
        UsuarioEntity usuarioEntityEmail = new UsuarioEntity("email@gmail.com");
    }

    @Test
    void TestSetEmail(){
        usuarioEntity.setEmail("prueba@gmail.com");
    }
}
