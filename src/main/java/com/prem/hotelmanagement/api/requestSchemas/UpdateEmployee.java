package com.prem.hotelmanagement.api.requestSchemas;

import lombok.Data;

@Data
public class UpdateEmployee {
    private String fullname;
    private String email;
    private String password;
    private String role;
}
