package by.edu.currencyservice.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pk")
    @SequenceGenerator(name="seq_pk", sequenceName= "primary_key_seq", allocationSize = 1)
    private Long id;

    private LocalDate date;

    private String code;

    private double rate;

}
