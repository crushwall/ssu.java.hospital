package com.hospital.entity;

import com.hospital.entity.enums.HumanSex;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Human{
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    private HumanSex sex;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String phoneNumber;
}
