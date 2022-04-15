package com.vega.springit.controler;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.service.LinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

//@RestController
//@RequestMapping("/links")
@Controller
public class LinkController {

    LinkService linkService;
    CommentRepository commentRepository;
    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    public LinkController(LinkService linkService, CommentRepository commentRepository) {
        this.linkService = linkService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String list(Model model)
    {
        model.addAttribute("Links", linkService.findAll());
        return "link/list";
    }
    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {


        Optional<Link> link= linkService.findById(id);
        if(link.isPresent())
        {
            Link currentLink=link.get();
            Comment comment=new Comment();
            comment.setLink(currentLink);
            model.addAttribute("comment",comment);
            model.addAttribute("link",currentLink);
            model.addAttribute("success",model.containsAttribute("success"));
            return "link/view";
        }else
            return "redirect:/";

    }
    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
      if(bindingResult.hasErrors()){
          logger.info("validation error were found while submiting link ");
          model.addAttribute("link",link);
          return "link/submit";
      }else{
          linkService.save(link);
          logger.info("link saved successfully");
          redirectAttributes
                  .addAttribute("id",link.getId())
                  .addFlashAttribute("success",true);
          return "redirect:/link/{id}";
      }


    }
    @PostMapping("link/comments")
    public String addComment(@Valid Comment comment, BindingResult result){
        if(result.hasErrors())
        {
            logger.info("Something went wrong.");
        }else{
            commentRepository.save(comment);
            logger.info("New Comment Saved!");
        }
        return "redirect:/link/"+ comment.getLink().getId();
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

