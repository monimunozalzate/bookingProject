/*package com.dh.digital_booking_back;

import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionCategoriaTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrarCategoria() throws Exception {
        int inum = 1;
        Long Inum = Long.valueOf(inum);
        Categoria categoria1 = new Categoria(Inum,"Bogota","Prueba1","fdsfsdfsdfs");

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/categorias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.asJsonString(categoria1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(result.getResponse().getContentAsString().isEmpty());
    }
}
*/