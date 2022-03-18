package uz.jl.lunch_order_rest.dto.complaint;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintUpdateDto extends GenericDto {
    private String message;

    @SerializedName(value = "user_id")
    private Long user_id;
}
