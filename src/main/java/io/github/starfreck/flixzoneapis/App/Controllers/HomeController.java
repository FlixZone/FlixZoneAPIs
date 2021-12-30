package io.github.starfreck.flixzoneapis.App.Controllers;

import io.github.starfreck.flixzoneapis.App.Models.Auth.AuthRequest;
import io.github.starfreck.flixzoneapis.App.Models.Auth.AuthResponse;
import io.github.starfreck.flixzoneapis.App.Services.UserService;
import io.github.starfreck.flixzoneapis.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String Home(){
        return "Hi! Welcome to FlixZone";
    }

    @RequestMapping("/api")
    public String apiHome(){
        return "Hi! Welcome to FlixZone APIs";
    }

    @PostMapping("/api/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
            );
        }
        catch (BadCredentialsException e) {
            // Incorrect username or password
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }


        final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }



}
