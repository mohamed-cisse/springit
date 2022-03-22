package com.vega.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable{
    @Id
    @GeneratedValue
    private long id;
    private String body;
    @ManyToOne
    private Link link;
    //link



}
