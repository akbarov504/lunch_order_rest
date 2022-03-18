package uz.jl.lunch_order_rest.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAcceptDepartmentDto implements BaseDto {
    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "department_id")
    private Long departmentId;
}
