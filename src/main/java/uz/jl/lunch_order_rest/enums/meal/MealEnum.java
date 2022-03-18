package uz.jl.lunch_order_rest.enums.meal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MealEnum {
    SALAD("Salad"),
    SOUP("Soup"),
    LIGHT_FOOD("Light food"),
    FAST_FOOD("Fast food"),
    HEAVY_MEAL("Heavy meal");

    private final String value;
}
