package com.university.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String subject;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @OneToOne(targetEntity = Student.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

}
