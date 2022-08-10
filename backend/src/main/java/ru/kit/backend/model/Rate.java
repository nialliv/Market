package ru.kit.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * To Do
 * 
 * Add rating value - min. 1 and max. 5
 */

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User userId;
    
    @OneToOne
    @JoinColumn(name = "device_id")
    @Column(nullable = false)
    private Device deviceId;

    @Column(nullable = false)
    private int rateValue;
}
