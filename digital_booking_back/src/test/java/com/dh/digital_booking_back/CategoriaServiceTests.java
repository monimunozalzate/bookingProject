/*package com.dh.digital_booking_back;

import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.service.CategoriaService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTests {

    @Autowired
    private CategoriaService categoriaService;

    public void cargarDataSet() throws BadRequestException {
        int inum = 1;
        Long Inum = Long.valueOf(inum);
        this.categoriaService.addCategoria(new Categoria(Inum,"Bogota","Prueba1","fdsfsdfsdfs"));
    }

    @Test
    public void agregarCategoria() throws BadRequestException {
        this.cargarDataSet();
        int inum = 2;
        Long Inum = Long.valueOf(inum);
        Categoria categoria = categoriaService.agregarCategoria(new Categoria(Inum, "Cali", "Prueba1", "dfsafsd"));
        Assert.assertTrue(categoria.getId() != null);
    }

    @Test
    public void traerTodasLasCategorias() {
        List<Categoria> categorias = categoriaService.listCategorias();
        Assert.assertTrue(!categorias.isEmpty());
        //Assert.assertTrue(odontologos.size() == 1);
    }

    @Test
    public void buscarCategoriaTest() throws BadRequestException {
        int inum = 2;
        Long Inum = Long.valueOf(inum);
        Assert.assertNotNull(categoriaService.searchCategoriaById(Inum));
    }

}
*/