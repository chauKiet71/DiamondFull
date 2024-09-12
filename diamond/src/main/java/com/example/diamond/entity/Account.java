package com.example.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
//    @NotBlank(message = "Vui lòng nhập tên tài khoản")
    public String username;

//    @NotBlank(message = "Vui lòng nhập mật khẩu")
//    @Size(min = 6, message = "Mật khẩu tối thiểu 6 kí tự")
    public String password;

//    @NotBlank(message = "Vui lòng nhập họ và tên")
    public String full_name;

//    @NotBlank(message = "Vui lòng nhập email")
//    @Email(message = "Email không đúng định dạng")
    public String email;
    public String photo;
    public Boolean gender;
    public Date birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authorities> authorities;
}
