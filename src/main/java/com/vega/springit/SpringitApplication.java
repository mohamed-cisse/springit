package com.vega.springit;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringitApplication.class, args);

    }

    @Autowired
    LinkRepository linkRepository;
    @Autowired
    CommentRepository commentRepository;
    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository)
    {
        return args -> {
            Link link=new Link("spring","https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link);

            Comment comment=new Comment("this is awsom",link);
            commentRepository.save(comment);

            link.addComment(comment);
//           Link link1=linkRepository.findByTitle("spring");
//            System.out.println(link1.getTitle());



        };
    }

}
