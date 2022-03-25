package com.vega.springit.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable{
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String body;
    @ManyToOne
    @NonNull
    private Link link;
    //link


    public Comment(String body, @NonNull Link link) {
        this.body = body;
        this.link = link;
    }
}
