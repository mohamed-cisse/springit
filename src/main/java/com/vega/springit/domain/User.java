package com.vega.springit.domain;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.awt.font.ShapeGraphicAttribute;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
//@RequiredArgsConstructor
@Data

public class User implements UserDetails {

    @Id @GeneratedValue
    private  Long id;
    @NotNull @Column(unique = true, nullable = false)
    @Size(min = 8, max = 20)
    private  String email;
    @NotNull
    private  String password;
    @NotNull @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public void addRole(Role role)
    {
        roles.add(role);

    }
    public void addRoles(Set<Role> roles)
    {
       roles.forEach(this::addRole);



    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
