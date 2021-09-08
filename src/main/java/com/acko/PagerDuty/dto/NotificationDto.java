package com.acko.PagerDuty.dto;

public class NotificationDto {

    String phone_number;
    String message="too many 500";

    public NotificationDto(String phone_number) {
        this.phone_number = phone_number;
    }
}
