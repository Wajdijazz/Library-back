package com.libraryapplication.library.Category ;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "CODE")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "LABEL", nullable = false)

    private String label;
    public Category() {
        super();
    }

    public Category(Long id, String label) {
        super();
        this.id = id;
        this.label = label;
    }




    public Long getCode() {
        return id;
    }

    public void setCode(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
