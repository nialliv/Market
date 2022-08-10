package ru.kit.backend.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @OneToOne
    @JoinColumn(name = "device_type_id")
    private DeviceType type;


    @OneToOne
    @JoinColumn(name = "device_brand_id")
    private DeviceBrand brand;

}
