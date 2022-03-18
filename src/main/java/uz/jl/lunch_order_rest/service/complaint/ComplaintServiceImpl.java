package uz.jl.lunch_order_rest.service.complaint;

import org.springframework.stereotype.Service;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintCreateDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintDetailDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintGetDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintUpdateDto;
import uz.jl.lunch_order_rest.entity.complaint.ComplaintEntity;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.exception.custom_exception.NotFoundException;
import uz.jl.lunch_order_rest.mapper.complaint.ComplaintMapper;
import uz.jl.lunch_order_rest.repository.complaint.ComplaintRepository;
import uz.jl.lunch_order_rest.service.AbstractService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintServiceImpl extends AbstractService<ComplaintMapper, ComplaintRepository> implements ComplaintService {
    public ComplaintServiceImpl(ComplaintMapper mapper, ComplaintRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(ComplaintCreateDto dto) {
        ComplaintEntity entity = mapper.fromCreateDto(dto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUserId(dto.getUserId());
        repository.save(entity);
    }

    @Override
    public void update(ComplaintUpdateDto dto) {

    }

    @Override
    public void delete(Long key) {
        repository.deleteById(key);
    }

    @Override
    public ComplaintGetDto get(Long key) {
        return mapper.toGetDto(repository.findById(key).orElseThrow(() -> {
            throw new NotFoundException("Complaint not found");
        }));
    }

    @Override
    public ComplaintDetailDto detail(Long key) {
        return null;
    }

    @Override
    public List<ComplaintGetDto> list() {
        return mapper.toGetListDto(repository.findAll());
    }

    @Override
    public Long totalCount() {
        return repository.count();
    }

    public List<ComplaintGetDto> list(Long userId) {
        return mapper.toGetListDto(repository.findAllByUserId(userId));
    }
}
