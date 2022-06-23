package br.com.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    Boolean success;
    Long status;
    String message;
}
