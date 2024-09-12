package com.example.diamond.controller;

import com.example.diamond.dao.AccountDao;
import com.example.diamond.dao.ProductDao;
import com.example.diamond.entity.Account;
import com.example.diamond.entity.Product;
import com.example.diamond.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    ProductDao dao;

    @Autowired
    AccountService accountService;
    @Autowired
    private AccountDao accountDao;


    @RequestMapping("/product/list")
    public String index() {
        return "admin/productList";
    }

    @RequestMapping("/admin")
    public String x() {
        return "admin/indexAdmin";
    }

    @RequestMapping("/index")
    public String indexAdmin(Model model, HttpSession session) {
        Pageable pageable1 = PageRequest.of(0, 4);
        List<Product> products1 = dao.selectTop4Product(pageable1);
        model.addAttribute("products1", products1);

        Pageable pageable2 = PageRequest.of(1, 4);
        List<Product> products2 = dao.selectTop4Product(pageable2);
        model.addAttribute("products2", products2);

        Pageable pageable3 = PageRequest.of(0, 8);
        List<Product> products3 = dao.selectTop4Product(pageable3);
        model.addAttribute("products3", products3);
        model.addAttribute("username", session.getAttribute("username"));
        return "/client/layout/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/client/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        //tim kiem username can dang nhap
        Account account = accountDao.findById(username).get();
        //kiem tra dang nhap
        if (account != null && account.getPassword().equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("loginAccount", account);
            System.out.println("Login Success");
            return "redirect:/index";
        }
        return "/client/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginAccount");
        System.out.println("Logout Success");
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("account", new Account());
        return "/client/signUp";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model) {

        //kiem tra email exits
        if (accountDao.findByEmail(account.getEmail()) != null) {
            bindingResult.rejectValue("email", "error.account", "Email đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            return "/client/signUp";
        }
        accountService.resgisterAccount(account);
        model.addAttribute("success", "Sign Up Successful");
        model.addAttribute("account", new Account());
        System.out.println("Sign Up Successful");
        return "/client/signUp";
    }

    @GetMapping("/user/profile/{username}")
    public String profile(
            @PathVariable("username") String username,
            Model model) {
        model.addAttribute("infoAccount", accountDao.findById(username).orElse(null));
        return "/client/account/profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("infoAccount") Account account) {
        accountDao.save(account);
        return "redirect:/user/profile/" + account.getUsername();
    }
}
