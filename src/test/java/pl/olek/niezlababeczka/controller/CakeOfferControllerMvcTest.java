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
import pl.olek.niezlababeczka.dto.CakeOfferDto;
import pl.olek.niezlababeczka.dto.MoneyDto;
import pl.olek.niezlababeczka.entity.CakeLayer;
import pl.olek.niezlababeczka.entity.LayerTaste;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CakeOfferControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldAddCakeOffer() throws Exception {
        Money money = Money.of(CurrencyUnit.EUR, BigDecimal.valueOf(1L));
        MoneyDto moneyDto = MoneyDto.toDto(money);
        LayerTaste lt = new LayerTaste("brownie");
        CakeLayer cakeLayer = new CakeLayer(lt);
        Set<CakeLayer> a = Set.of(cakeLayer);

        mockMvc.perform(
                post("/v1/cakeoffers")
                        .content(asJsonString(new CakeOfferDto(moneyDto, UUID.randomUUID(), a, UUID.randomUUID())))
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

