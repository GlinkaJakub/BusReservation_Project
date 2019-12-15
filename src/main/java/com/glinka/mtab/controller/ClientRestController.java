package com.glinka.mtab.controller;

import com.glinka.mtab.model.dto.RoleDto;
import com.glinka.mtab.model.entity.Role;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.service.RoleService;
import com.glinka.mtab.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/client")
public class ClientRestController {


    private UserService userService;
    private RoleService roleService;

    public ClientRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/allRole")
    public List<RoleDto> findAllRoles(){
        return roleService.findAll();
    }

    @Transactional
    @PostMapping("/addRole")
    public Role addRole(@RequestBody RoleDto roleDto){
        return roleService.save(roleDto);
    }

    @PostMapping("/save")
    public User saveClient(@RequestBody User client){
        return userService.save(client);
    }

}
