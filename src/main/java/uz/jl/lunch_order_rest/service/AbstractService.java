package uz.jl.lunch_order_rest.service;

import lombok.RequiredArgsConstructor;
import uz.jl.lunch_order_rest.mapper.BaseMapper;
import uz.jl.lunch_order_rest.repository.BaseRepository;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final M mapper;
    protected final R repository;
}
