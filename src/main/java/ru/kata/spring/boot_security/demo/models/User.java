package ru.kata.spring.boot_security.demo.models;

import groovyjarjarantlr4.v4.runtime.misc.Array2DHashSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String firstname;

   @Column
   private String lastname;

   @Column
   private String email;

   @Size(min=2, message = "Не меньше 5 знаков")
   private String username;

   @Size(min=2, message = "Не меньше 5 знаков")
   private String password;

   public String getUsername() {
      return username;
   }

   @ManyToMany
   @JoinTable(name = "users_roles",
           joinColumns = {@JoinColumn(name = "USER_ID")},
           inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
   private Set<Role> roles;



   public void setPassword(String password) {
      this.password = password;
   }

   public User(String firstname, String lastname, String email, String username, String password) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.email = email;
      this.username = username;
      this.password = password;
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

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return roles;
   }

}
