package com.vega.springit;


import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
@EnableTransactionManagement
public class SpringitApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringitApplication.class, args);

    }
    @Bean
    PrettyTime prettyTime(){
            return new PrettyTime();
    }

//
//    @Autowired
//    LinkRepository linkRepository;
//    @Autowired
//    CommentRepository commentRepository;
   // @Bean
//    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository)
//    {
//        return args -> {
//            Link link=new Link("spring","https://therealdanvega.com/spring-boot-2");
//            linkRepository.save(link);
//
//            Comment comment=new Comment("this is awsom",link);
//            commentRepository.save(comment);
//
//            link.addComment(comment);
////           Link link1=linkRepository.findByTitle("spring");
////            System.out.println(link1.getTitle());
//
//
//
//        };
//    }

}
