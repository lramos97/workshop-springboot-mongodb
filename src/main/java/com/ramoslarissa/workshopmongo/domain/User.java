package com.ramoslarissa.workshopmongo.domain;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
}
