package com.nasa.prueba.aspirante.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Information")
@Table(name="tbl_information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String href;
    private String center;
    private String title;
    private String nasaId;
    private LocalDateTime dateCreated;



    @PrePersist
    public void prePersist() {
        this.setDateCreated(LocalDateTime.now());
    }
}
