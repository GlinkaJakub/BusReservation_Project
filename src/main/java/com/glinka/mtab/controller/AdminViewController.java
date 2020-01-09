package com.glinka.mtab.controller;

import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminViewController {

    private final UserService userService;
    private final RoleService roleService;
    private final AgencyService agencyService;
    private final BusService busService;
    private final StopService stopService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final TripScheduleService tripScheduleService;

    public AdminViewController(UserService userService, RoleService roleService, AgencyService agencyService, BusService busService, StopService stopService, TicketService ticketService, TripService tripService, TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.agencyService = agencyService;
        this.busService = busService;
        this.stopService = stopService;
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.tripScheduleService = tripScheduleService;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserDto user){
        return "login";
    }
//
//    @PostMapping("/signup")
//    public String signup(@RequestBody UserDto user){
//        return "signup";
//    }
//
//    @GetMapping("/agency")
//    public String viewAgency(Model model, @RequestParam("agencyId") Long agencyId){
//
//        AgencyDto agencyDto = agencyService.findDtoById(agencyId);
//
//        model.addAttribute("agency", agencyDto);
//        return "agency";
//    }

    @GetMapping("/agency.html")
    public String viewAgency(){
        return "agency";
    }

    @GetMapping("/buses.html")
    public String viewBuses(){
        return "buses";
    }

    @GetMapping("/index.html")
    public String viewBoard(){
        return "index";
    }

    @GetMapping("/trips.html")
    public String viewTrips(){
        return "trips";
    }

    @GetMapping("/profile.html")
    public String viewProfile(){
        return "profile";
    }
//
//    @GetMapping("/buses")
//    public String viewBuses(@RequestParam("agencyId") Long agencyId){
//        return "buses";
//    }
//
//    @GetMapping("/trips")
//    public String viewTrips(@RequestParam("agencyId") Long agencyId){
//        return "trips";
//    }

}
