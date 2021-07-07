package com.gridu.phonebookmvcfinal.dto;

import lombok.*;

import javax.persistence.*;


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
