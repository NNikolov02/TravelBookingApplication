package com.example.travelbookingapplication3.web;

import com.example.travelbookingapplication3.dto.TokenRequest;
import com.example.travelbookingapplication3.dto.TokenResponse;
import com.example.travelbookingapplication3.service.TokenManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @RestController
    public class JWTController {
        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenManagerService tokenManager;

        @PostMapping("/token")
        public ResponseEntity<TokenResponse> createToken(@RequestBody TokenRequest
                                                                 request) throws Exception {
            try {
                authenticationManager.authenticate(
                        new
                                UsernamePasswordAuthenticationToken(request.getUsername(),
                                request.getPassword())
                );
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            final String jwtToken = tokenManager.generateJwtToken(userDetails);
            return ResponseEntity.ok(TokenResponse.builder().token(jwtToken.toString()).build());
        }
    }

}
