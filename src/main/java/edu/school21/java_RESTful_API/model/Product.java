package edu.school21.java_RESTful_API.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@Entity
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private Integer price;
    @Column(name = "available_stock")
    private Integer availableStock;
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;
    @Column(name = "supplier_id")
    private int supplierId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Images image;

    public Product() {};
}
