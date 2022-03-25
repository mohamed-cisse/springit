package com.vega.springit.controler;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@RequestMapping("links")
public class LinkControler {

    private LinkRepository linkRepository;

    public LinkControler(LinkRepository linkRepository1)
    {
        this.linkRepository=linkRepository1;
    }
    @RestController
    public class LinkController {

        @GetMapping("/")
        public List<Link> list() {
            return linkRepository.findAll();
        }

        @PostMapping("/create")
        public Link create(@ModelAttribute Link link) {
            return linkRepository.save(link);
        }
        @GetMapping("/{id}")
        public Optional<Link> read(@PathVariable Long id) {
            return linkRepository.findById(id);
        }
        @PutMapping("/{id}")
        public Link update(@PathVariable Long id,@ModelAttribute Link link) {
            //get id
            return linkRepository.save(link);
        }
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            linkRepository.deleteById(id);

        }
    }
}
