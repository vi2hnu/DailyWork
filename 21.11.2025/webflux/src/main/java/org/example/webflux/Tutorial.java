package org.example.webflux;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Tutorial {
    @Id
    private Integer id;
    private String title;
    private String description;
    private boolean published;
}
