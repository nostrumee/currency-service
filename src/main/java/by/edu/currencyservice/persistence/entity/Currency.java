package by.edu.currencyservice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Currency {

    @JsonProperty("Date")
    private LocalDate date;

    @JsonProperty("Cur_Abbreviation")
    private String code;

    @JsonProperty("Cur_OfficialRate")
    private double rate;

}
