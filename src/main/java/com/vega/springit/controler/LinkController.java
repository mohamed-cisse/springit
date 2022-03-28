package com.vega.springit.controler;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

//@RestController
//@RequestMapping("/links")
@Controller
public class LinkController {

    LinkRepository linkRepository;
    public LinkController(LinkRepository linkRepository)
    {
         this.linkRepository=linkRepository;
    }
    @GetMapping("/")
    public String list(Model model)
    {
        model.addAttribute("Links",linkRepository.findAll());
        return "link/list";
    }
    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {


        Optional<Link> link= linkRepository.findById(id);
        if(link.isPresent())
        {
        model.addAttribute("link",link.get());
            return "link/view";
        }else
            return "redirect:/";

    }

//    private LinkRepository linkRepository;
//
//    public LinkControler(LinkRepository linkRepository1)
//    {
//        this.linkRepository=linkRepository1;
//    }
//


//        @GetMapping("/foo")
//        public String foo(Model model)
//        {
//            model.addAttribute("pageTitle","this is foo");
//            return "foo";
//        }
//
//        @GetMapping("/")
//        public List<Link> list() {
//            return linkRepository.findAll();
//        }
//
//        @PostMapping("/create")
//        public Link create(@ModelAttribute Link link) {
//            return linkRepository.save(link);
//        }
//        @GetMapping("/{id}")
//        public Optional<Link> read(@PathVariable Long id) {
//            return linkRepository.findById(id);
//        }
//        @PutMapping("/{id}")
//        public Link update(@PathVariable Long id,@ModelAttribute Link link) {
//            //get id
//            return linkRepository.save(link);
//        }
//        @DeleteMapping("/{id}")
//        public void delete(@PathVariable Long id) {
//            linkRepository.deleteById(id);
//
//        }
    }

