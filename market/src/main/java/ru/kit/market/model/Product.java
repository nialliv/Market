package ru.kit.market.model;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    private Long rateId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    private ProductType type;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_brand_id")
    private ProductBrand brand;

}
