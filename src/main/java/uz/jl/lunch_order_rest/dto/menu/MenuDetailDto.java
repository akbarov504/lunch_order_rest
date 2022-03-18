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
public class MenuDetailDto extends GenericDto {
    private LocalDate date;

    private List<Long> meals;
}
