package com.example.plab.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GROUND")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ground {
    @Id
    @GeneratedValue
    @Column(name = "ground_id")
    private long groundId;

    @Column(name = "ground_name")
    private String groundName;

    @Column(name = "ground_address")
    private String groundAddress;
}
