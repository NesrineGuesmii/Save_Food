package com.example.Back.Entities;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends Person{

    @OneToMany(mappedBy = "client")
    private List<Commandes> commandes;

}
