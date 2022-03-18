package uz.jl.lunch_order_rest.dto.department;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDetailDto extends GenericDto {
    private String name;

    private UUID code;

    @SerializedName(value = "user_id")
    private Long userId;
}
