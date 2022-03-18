package uz.jl.lunch_order_rest.dto.menu;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateDto implements BaseDto {
    private LocalDate date;

    private List<Long> meals;

    @SerializedName(value = "created_by")
    private Long createdBy;
}
