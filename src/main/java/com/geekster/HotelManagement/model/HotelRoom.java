package com.geekster.HotelManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Room")
public class HotelRoom {

    @Id
    private Long roomId;

    @Column(unique = true)
    private Integer roomNumber;
    @Enumerated(EnumType.STRING )
    private Type roomType;
    private Double roomPrice;

    @Column(name = "status")
    private Boolean roomStatus;

}
