package com.pws.APIDoc.controller;

import com.pws.APIDoc.entity.User;
import com.pws.APIDoc.service.UserServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImp service;


    @Operation(summary = "Save")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "saved Successfully",
                    content = { @Content(mediaType = "application/json"
                    ) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content) })
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated Successfully",
                    content = { @Content(mediaType = "application/json"
                    ) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
        service.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Get User By ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = { @Content(mediaType = "application/json"
                    ) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content) })
    @GetMapping("/byId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User us = service.getUserById(id);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @Operation(summary = "Get All User Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched Successfully",
                    content = { @Content(mediaType = "application/json"
                    ) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content) })
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> us = service.getAll();
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @Operation(summary = "Delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Successfully",
                    content = { @Content(mediaType = "application/json"
                    ) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Access denied",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
