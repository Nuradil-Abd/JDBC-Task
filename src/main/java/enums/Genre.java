package enums;

import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@ToString
public enum Genre {
    FICTION,
    NON_FICTION,
    ROMANCE,
    FANTASY,
    BIOGRAPHY,
    THRILLER
}
