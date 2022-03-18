package uz.jl.lunch_order_rest.service.department;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.department.DepartmentCreateDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentDetailDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentGetDto;
import uz.jl.lunch_order_rest.dto.department.DepartmentUpdateDto;
import uz.jl.lunch_order_rest.entity.department.DepartmentEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.department.DepartmentMapper;
import uz.jl.lunch_order_rest.repository.department.DepartmentRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl extends AbstractService<DepartmentMapper, DepartmentRepository> implements DepartmentService {
    public DepartmentServiceImpl(DepartmentMapper mapper, DepartmentRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(DepartmentCreateDto dto) {
        DepartmentEntity entity = mapper.fromCreateDto(dto);
        entity.setCode(UUID.randomUUID());
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void update(DepartmentUpdateDto dto) {
        repository.updateById(dto.getId(), dto.getName(), dto.getUserId());
    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public DepartmentGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Department not found");
        }));
    }

    @Override
    public DepartmentDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<DepartmentGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public DepartmentGetDto getByName(String name) {
        return mapper.toGetDto(repository.findByName(name));
    }
}
