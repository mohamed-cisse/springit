package com.vega.springit.service;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> findAll()
    {
        return linkRepository.findAll();

    }
   public Optional<Link> findById(Long id)
   {
      return linkRepository.findById(id);
   }

   public Link save(Link link)
   {
      return linkRepository.save(link);
   }
   public long count()
   {
       return linkRepository.count();
   }
}
