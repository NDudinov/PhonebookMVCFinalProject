package com.gridu.phonebookmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "first_name")
    private String name;

    @NonNull
    @Column(name = "phone")
    private String phone;
}
