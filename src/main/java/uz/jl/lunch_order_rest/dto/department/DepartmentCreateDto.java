package uz.jl.lunch_order_rest.dto.department;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateDto implements BaseDto {
    private String name;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "created_by")
    private Long createdBy;
}
