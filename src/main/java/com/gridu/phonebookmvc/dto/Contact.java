package com.gridu.phonebookmvc.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@Entity
@Table(name = "contact")
@AllArgsConstructor
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String contactName;

    private String phone;
}
