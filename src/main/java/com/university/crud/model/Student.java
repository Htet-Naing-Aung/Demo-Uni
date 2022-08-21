package com.university.crud.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String address;

    @Getter @Setter
    @OneToOne(targetEntity=Classes.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Classes classes;

    @Getter @Setter
    @ManyToMany
            @JoinTable(
                    name = "student_book",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "book_id")
            )
    Set<Books> studentBooks;

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
