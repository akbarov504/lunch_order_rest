package uz.jl.lunch_order_rest.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import uz.jl.lunch_order_rest.dto.BaseDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements BaseDto {
    private String username;

    private String password;

    private String fullName;

    private String phone;

    private String language;

    private String position;

    private Integer chatId;

    @SerializedName(value = "created_by")
    private Long createdBy = -1L;
}
