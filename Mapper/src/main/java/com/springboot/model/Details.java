package com.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "DETAILS")
public class Details {

    @Id
    private String id;
    private String mapperId;
    private String name;
    private String dataType;
    private String destinationColumn;
}
