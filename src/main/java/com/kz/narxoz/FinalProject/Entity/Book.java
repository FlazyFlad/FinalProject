package com.kz.narxoz.FinalProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "Name", nullable = false)
    private String Name;

    @Column(name =  "Author", nullable = false)
    private String Author;

    @Column(name =  "Description", nullable = false)
    private String Description;

    @Column(name = "Price", nullable = false)
    private String Price;

}
