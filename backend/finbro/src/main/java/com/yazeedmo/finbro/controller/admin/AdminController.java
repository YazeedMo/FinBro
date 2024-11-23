package com.yazeedmo.finbro.controller.admin;

import com.yazeedmo.finbro.domain.AdminEvent;
import com.yazeedmo.finbro.domain.ApiResponse;
import com.yazeedmo.finbro.service.UserService;
import com.yazeedmo.finbro.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin(origins = "http://localhost")
public class AdminController {

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private UserService userService;

    @GetMapping("/online-users/count")
    public ResponseEntity<ApiResponse<AdminEvent>> getTotalUsersOnline() {

        int totalUsersOnline = webSocketService.getTotalOnlineUsers();

        AdminEvent adminEvent = new AdminEvent(AdminEvent.EventType.ONLINE_USER_COUNT, totalUsersOnline);
        ApiResponse<AdminEvent> apiResponse = new ApiResponse<>(true, adminEvent);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(apiResponse);

    }

    @GetMapping("/total-users/count")
    public ResponseEntity<ApiResponse<AdminEvent>> getTotalUsers() {

        long totalUsers = userService.getCountTotalUsers();

        AdminEvent adminEvent = new AdminEvent(AdminEvent.EventType.TOTAL_USER_COUNT, totalUsers);
        ApiResponse<AdminEvent> apiResponse = new ApiResponse<>(true, adminEvent);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(apiResponse);

    }

}