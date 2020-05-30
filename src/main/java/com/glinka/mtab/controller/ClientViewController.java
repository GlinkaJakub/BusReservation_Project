package com.glinka.mtab.controller;

import com.glinka.mtab.dto.TicketDto;
import com.glinka.mtab.dto.UserDto;
import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.model.entity.User;
import com.glinka.mtab.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

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
    public String viewProfile(Model model, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        model.addAttribute("user", userService.findByIdDto(userId));
        return "profile-1";
    }

    @GetMapping("/table.html")
    public String viewTrips(Model model, Authentication authentication){
//        System.out.println(authentication.getName());
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        model.addAttribute("user", userService.findByIdDto(userId));
        model.addAttribute("trips", tripScheduleService.findAllToView());
        return "table";
    }

    @Transactional
    @GetMapping("/bookTicket")
    public String bookTicket(@RequestParam("tripScheduleId") Long id, @RequestParam("userId") Long userId){
        TripSchedule tripSchedule = tripScheduleService.findById(id);
        if (tripSchedule.getAvailableSeats() <= 0){
            return null;
        }
        System.out.println("book");
        TicketDto ticketDto = new TicketDto();
        ticketDto.setPassengerId(userId);
        ticketDto.setTripScheduleId(id);
        ticketDto.setJourneyDate(tripSchedule.getTripDate());
        ticketDto.setCancellable(true);
        ticketDto.setSeatNumber(tripSchedule.getAvailableSeats());
        tripSchedule.setAvailableSeats(tripSchedule.getAvailableSeats() - 1);
        saveTicket(ticketDto);
        return "redirect:/table.html";
    }

    @Transactional
//    @PostMapping("/saveTicket")
    public Ticket saveTicket(@ModelAttribute("ticket") TicketDto ticketDto) {
        return ticketService.save(ticketDto);
    }

    @Transactional
    @PostMapping("/saveUser")
    public String saveClient(@ModelAttribute("user") UserDto userDto, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();

        if (userDto.getRoleId() != null)
            userDto.setRoleId(5L);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(bcrypt.encode(userDto.getPassword()));
        userDto.setId(userId);
        userService.save(userDto);
        return "redirect:/profile-1.html";
    }

}
