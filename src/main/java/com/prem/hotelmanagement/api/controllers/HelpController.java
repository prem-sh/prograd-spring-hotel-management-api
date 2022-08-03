package com.prem.hotelmanagement.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/help")
public class HelpController {
    @GetMapping
    public ResponseEntity<Help>help(){
        List<Api> listOfApis = new ArrayList<Api>();
        listOfApis.add(new Api("This Api has info about using admin api", "/help/admin", null));
        listOfApis.add(new Api("This Api has info about using user api", "/help/user", null));
        listOfApis.add(new Api("This Api has info about using rooms api", "/help/rooms", null));
        Help helpContent = new Help("This Rout has three apis | /help/admin | /help/room | /help/admin |", listOfApis);
        return new ResponseEntity<Help>(helpContent, HttpStatus.OK);
    }
    @GetMapping("room")
    public ResponseEntity<Help> roomHelp(){
        List<Api> listOfApis = new ArrayList<Api>();
        listOfApis.add(new Api("This Api has info about using admin api", "/help/admin", null));
        listOfApis.add(new Api("This Api has info about using user api", "/help/user", null));
        listOfApis.add(new Api("This Api has info about using rooms api", "/help/rooms", null));
        Help roomsHelp = new Help("This Rout has apis to create and manage rooms", listOfApis);
        return new ResponseEntity<Help>(roomsHelp, HttpStatus.OK);
    }
    @GetMapping("user")
    public ResponseEntity<Help> userHelp(){
        List<Api> listOfApis = new ArrayList<Api>();
        listOfApis.add(new Api("This Api has info about using admin api", "/help/admin", null));
        listOfApis.add(new Api("This Api has info about using user api", "/help/user", null));
        listOfApis.add(new Api("This Api has info about using rooms api", "/help/rooms", null));
        Help userHelp = new Help("This Rout has apis to create, update, delete user details ", listOfApis);
        return new ResponseEntity<Help>(userHelp, HttpStatus.OK);
    }
    @GetMapping("admin")
    public ResponseEntity<Help> adminHelp(){
        List<Api> listOfApis = new ArrayList<Api>();
        listOfApis.add(new Api("This Api has info about using admin api", "/help/admin", null));
        listOfApis.add(new Api("This Api has info about using user api", "/help/user", null));
        listOfApis.add(new Api("This Api has info about using rooms api", "/help/rooms", null));
        Help adminHelp = new Help("This Rout has apis to manage room bookings, getting revenue information", listOfApis);
        return new ResponseEntity<Help>(adminHelp, HttpStatus.OK);
    }
}

class Api {
    private String description;
    private String url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Api(String description, String url, List<String> example) {
        this.description = description;
        this.url = url;
    }
}

class Help {
    private String description;
    private List<Api> apis;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Api> getApis() {
        return apis;
    }

    public void setApis(List<Api> apis) {
        this.apis = apis;
    }

    public Help(String description, List<Api> apis) {
        this.description = description;
        this.apis = apis;
    }
}