package microservice.auth_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import microservice.auth_service.dto.req.FormLogin;
import microservice.auth_service.dto.req.OtpDto;
import microservice.auth_service.dto.req.RegisterDto;
import microservice.auth_service.dto.req.ResendOtpDto;
import microservice.auth_service.dto.res.JwtResponse;
import microservice.auth_service.service.IAuthService;
import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "APIs for user registration, login, and OTP verification")
public class AuthController {

    private final IAuthService authService;

    @Operation(summary = "Register account", description = "Register a new user account and send OTP to the email")
    @PostMapping("/register")
    public ResponseEntity<ResponseWrapper<MessageResponse>> register(@Valid @RequestBody RegisterDto req) throws MessagingException {
        ResponseWrapper<MessageResponse> response = authService.register(req);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Verify OTP", description = "Enter the received OTP to verify the email address")
    @PostMapping("/verify")
    public ResponseEntity<ResponseWrapper<MessageResponse>> verify(@Valid @RequestBody OtpDto otp) {
        ResponseWrapper<MessageResponse> response = authService.verify(otp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Resend OTP", description = "Send a new OTP code to the registered email address")
    @PostMapping("/resend-otp")
    public ResponseEntity<ResponseWrapper<MessageResponse>> resendOtp(@RequestBody ResendOtpDto req) throws MessagingException {
        ResponseWrapper<MessageResponse> response = authService.resendOtp(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Login", description = "Login using email and password")
    @PostMapping("/login")
    public ResponseEntity<ResponseWrapper<JwtResponse>> login(@Valid @RequestBody FormLogin req) {
        ResponseWrapper<JwtResponse> response = authService.login(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
