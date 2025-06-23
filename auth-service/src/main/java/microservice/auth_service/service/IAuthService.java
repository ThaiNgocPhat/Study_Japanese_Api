package microservice.auth_service.service;

import jakarta.mail.MessagingException;
import microservice.auth_service.dto.req.FormLogin;
import microservice.auth_service.dto.req.OtpDto;
import microservice.auth_service.dto.req.RegisterDto;
import microservice.auth_service.dto.req.ResendOtpDto;
import microservice.auth_service.dto.res.JwtResponse;
import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;

public interface IAuthService {
    ResponseWrapper<MessageResponse> register(RegisterDto req) throws MessagingException;
    ResponseWrapper<MessageResponse> verify(OtpDto otp);
    ResponseWrapper<MessageResponse> resendOtp(ResendOtpDto req) throws MessagingException;
    ResponseWrapper<JwtResponse> login (FormLogin req);
}