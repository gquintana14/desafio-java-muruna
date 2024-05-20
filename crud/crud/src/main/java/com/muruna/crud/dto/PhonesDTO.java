package com.muruna.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhonesDTO {
    private String number;
    private String cityCode;
    private String countryCode;
}
