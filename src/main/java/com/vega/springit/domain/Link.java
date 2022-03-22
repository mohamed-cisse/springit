package com.vega.springit.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String url;

    // comment
    @OneToMany(mappedBy = "link")
    private List<Comment> comments=new ArrayList<>();


}
