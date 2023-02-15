package com.example.Back.Entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurantagent")
public class RestauAgent extends Person{

    private String restaurant;

    @OneToMany(mappedBy = "restauAgent")
    private List<Commandes> commandes;

    @OneToMany(mappedBy = "restauAgent")
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    private Logo logo;

}
