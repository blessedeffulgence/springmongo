package com.springbootmongo.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
public class Address {

    private String addressOne;
    private String addressTwo;
    private String city;

}
