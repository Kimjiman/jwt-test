package com.jm.jwttest;

import com.jm.jwttest.config.JwtTokenProvider;
import com.jm.jwttest.config.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {
    private final JwtTokenProvider jwtTokenProvider;

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        if(user.get("username").equals("user") && user.get("password").equals("password")) {
            User member = new User();
            member.setUsername("user");
            member.setPassword("password");
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_USER");
            member.setUserRole(roles);
            return jwtTokenProvider.createToken(user.get("username"), member.getUserRole());
        } else {
            throw new RuntimeException("로그인 실패");
        }
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
