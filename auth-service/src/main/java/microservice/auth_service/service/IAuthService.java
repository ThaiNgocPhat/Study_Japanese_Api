package microservice.auth_service.service;

import jakarta.mail.MessagingException;
import microservice.auth_service.dto.req.*;
import microservice.auth_service.dto.res.JwtResponse;
import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;

public interface IAuthService {
    ResponseWrapper<MessageResponse> register(RegisterDto req) throws MessagingException;
    ResponseWrapper<MessageResponse> verify(OtpDto otp);
    ResponseWrapper<MessageResponse> resendOtp(ResendOtpDto req) throws MessagingException;
    ResponseWrapper<JwtResponse> login (FormLogin req);
    ResponseWrapper<MessageResponse> resendOtpForgotPassword(ResendOtpForgotPasswordDto req) throws MessagingException;
    ResponseWrapper<MessageResponse> verifyForgotPassword(OtpForgotPasswordDto otp);
    ResponseWrapper<MessageResponse> resetPassword(ResetPasswordDto req);
}