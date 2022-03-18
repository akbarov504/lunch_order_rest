package uz.jl.lunch_order_rest.dto.department;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentUpdateDto extends GenericDto {
    private String name;

    @SerializedName(value = "user_id")
    private Long userId;
}
