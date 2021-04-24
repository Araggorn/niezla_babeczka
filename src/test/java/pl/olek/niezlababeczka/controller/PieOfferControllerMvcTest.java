package pl.olek.niezlababeczka.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.dto.PieOfferDto;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PieOfferControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldAddUser() throws Exception {
        Money money = Money.of(CurrencyUnit.EUR, BigDecimal.valueOf(1L));
        MoneyDto moneyDto = MoneyDto.toDto(money);
        mockMvc.perform(
                post("/v1/pieoffers")
                        .content(asJsonString(new PieOfferDto(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), moneyDto)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
