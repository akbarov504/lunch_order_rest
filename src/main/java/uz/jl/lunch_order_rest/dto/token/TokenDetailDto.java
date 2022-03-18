package uz.jl.lunch_order_rest.dto.token;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.GenericDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenDetailDto extends GenericDto {
    @SerializedName(value = "user_id")
    private Long userId;

    private String token;

    private String type;

    private LocalDate duration;
}
