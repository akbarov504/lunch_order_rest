package uz.jl.lunch_order_rest.controller;

import lombok.RequiredArgsConstructor;
import uz.jl.lunch_order_rest.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {
    protected final S service;
}
