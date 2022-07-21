package com.example.demo.Entities;




import javax.persistence.*;


@Entity

public class Coche  {


    // atributos encapsulados
   @Id

   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;

   private String manufacturer;

   private int modelyear;


    public Coche() {
    }

    public Coche(Long id, String name, String manufacturer, int modelyear) {
        this.id = id;
        this.name = name;
       this.manufacturer=manufacturer;
this.modelyear = modelyear;

    }

    // getter y setter



    // tostring


    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelyear=" + modelyear +
                '}';
    }
}
