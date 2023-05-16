package com.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HEADER")
public class Header {
    @Id
    private String id;
    private String mapperName;
    private String destinationTable;
    private boolean headerFlag;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mapperId",referencedColumnName = "id")
    private List<Details> mapperDetails;

}
