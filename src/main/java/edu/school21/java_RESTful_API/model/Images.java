package edu.school21.java_RESTful_API.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@Table(name = "images")
public class Images {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "data")
    private byte[] data;
        @OneToOne(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    private Product product;

    public Images() {};

    public Images(byte[] data) {
        this.data = data;
    }
}
