package com.NMN.foodorder.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;

    private String oName;
    private double oPrice;
    private int oQuantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_u_id")
    private User user;
}
