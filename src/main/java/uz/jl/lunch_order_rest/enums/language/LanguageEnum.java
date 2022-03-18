package uz.jl.lunch_order_rest.enums.language;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageEnum {
    UZ("Uzbek"),
    RU("Russian"),
    EN("English");

    private final String value;
}
