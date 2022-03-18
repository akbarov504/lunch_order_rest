package uz.jl.lunch_order_rest.dto.menu;

import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuUpdateDto extends GenericDto {
    private LocalDate date;
}
