package com.dh.aula31Conclusao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class MascoteDTO {

    private String nome;
    private Integer idade;

    public MascoteDTO(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

}
