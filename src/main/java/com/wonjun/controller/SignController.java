package com.wonjun.controller;

import com.wonjun.model.dto.SignInResultDto;
import com.wonjun.model.dto.SignUpResultDto;
import com.wonjun.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign-api")
public class SignController {
    @Autowired
    private SignService signService;

    @PostMapping("/sign-in")
    public SignInResultDto signIn(@RequestParam(value = "id") String id,
                                  @RequestParam(value = "password") String password) throws RuntimeException {

        SignInResultDto signInResultDto =  signService.signIn(id, password);
        if (signInResultDto.getCode() == 0) { // 정상 로그인
            System.out.println("정상 로그인 " + id + " token : " + signInResultDto.getToken());
        }
        return signInResultDto;
    }
    @PostMapping("/sign-up")
    public SignUpResultDto signUp(@RequestParam(value = "id") String id,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "auth") String role) {
        SignUpResultDto signUpResultDto = signService.signUp(id, password, name, role);
        return signUpResultDto;
    }

    @GetMapping("/exception")
    public void exceptionTest() throws RuntimeException {
        throw new RuntimeException("접근 거부");
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> ExceptionHandler(RuntimeException e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");
        return map;
    }
}
