package com.hospital.entity;

import com.hospital.enums.HumanSex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Human {
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
