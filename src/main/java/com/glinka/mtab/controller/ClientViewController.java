package com.glinka.mtab.controller;

import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientViewController {

    private final UserService userService;
    private final RoleService roleService;
    private final AgencyService agencyService;
    private final BusService busService;
    private final StopService stopService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final TripScheduleService tripScheduleService;

    public ClientViewController(UserService userService, RoleService roleService, AgencyService agencyService, BusService busService, StopService stopService, TicketService ticketService, TripService tripService, TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.agencyService = agencyService;
        this.busService = busService;
        this.stopService = stopService;
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.tripScheduleService = tripScheduleService;
    }

    @GetMapping("/profile-1.html")
    public String viewProfile(Model model, @RequestParam("id") Long id){
        model.addAttribute("user", userService.findByIdDto(id));
        return "profile-1";
    }

    @GetMapping("/table.html")
    public String viewTrips(Model model){
        model.addAttribute("trips", tripScheduleService.findAllToView());
        return "table";
    }

//    @GetMapping("/hello")
//    public String hello(Model model){
//        model.addAttribute("date", new java.util.Date());
//        return "hello";
//    }
//
//    @GetMapping("/login.html")
//    public String loginUser(Model model){
//        return "login";
//    }
//
//    @GetMapping("/register.html")
//    public String signup(Model model){
//        return "register";
//    }

//    @GetMapping("/trips")
//    public String findTrip(@RequestParam("source") String source, @RequestParam("dest") String dest, @RequestParam("date") String date){
//        return "trips";
//    }
//
//    @GetMapping("/book")
//    public String bookTicket(@RequestParam("ticketId") Long id){
//        return "book";
//    }



}
