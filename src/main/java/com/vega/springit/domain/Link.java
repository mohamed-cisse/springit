package com.vega.springit.domain;

import com.sun.istack.NotNull;
import com.vega.springit.service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Link extends Auditable {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @NotEmpty(message = "please enter title")
    private String title;
    @NotNull
    @NotEmpty(message = "please enter url")
    @URL(message = "please enter a valid Url ")
    private String url;

    // comment
    @OneToMany(mappedBy = "link")
    private List<Comment> comments=new ArrayList<>();

    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();

    private int voteCount = 0;

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public void addComment( Comment comment)
    {
        comments.add(comment);
    }

    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}
