package com.car.training.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Promotion {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int entityId;

    @Column
    private String entityType;

    @Column
    private Date updateDate;

    @Column
    private int ord;

}
