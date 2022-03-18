package uz.jl.lunch_order_rest.dto.complaint;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintCreateDto implements BaseDto {
    private String message;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "created_by")
    private Long createdBy;
}
