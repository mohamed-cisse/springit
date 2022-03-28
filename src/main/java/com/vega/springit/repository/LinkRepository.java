package com.vega.springit.repository;

import com.vega.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.ldap.LdapReferralException;

public interface LinkRepository extends JpaRepository<Link,Long> {
  //  Link findByTitle(String title);

 Link findByTitle(String title);

}
