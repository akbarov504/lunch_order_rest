package uz.jl.lunch_order_rest.mapper.complaint;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintCreateDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintGetDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintUpdateDto;
import uz.jl.lunch_order_rest.entity.complaint.ComplaintEntity;
import uz.jl.lunch_order_rest.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface ComplaintMapper extends GenericMapper<ComplaintCreateDto, ComplaintUpdateDto, ComplaintGetDto, ComplaintEntity> {
}
