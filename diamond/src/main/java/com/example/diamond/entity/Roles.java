package com.example.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    private String role_id;
    private String role_name;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authorities> authorities;
}
