package com.wonjun.model.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpResultDto {
    private boolean success;
    private int code;
    private String mas;


}
