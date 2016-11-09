package com.car.training.bean;

import com.car.training.enums.UserType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bill on 11/6/16.
 */
@Table
@Entity
public class PromotionUser {

    @Id
    @GeneratedValue
    @Column
    int id;

    @Column
    int uid;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    UserType type;

    @Column
    Date updateDate;
}
