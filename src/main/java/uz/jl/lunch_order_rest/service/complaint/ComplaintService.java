package uz.jl.lunch_order_rest.service.complaint;

import uz.jl.lunch_order_rest.dto.complaint.ComplaintCreateDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintDetailDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintGetDto;
import uz.jl.lunch_order_rest.dto.complaint.ComplaintUpdateDto;
import uz.jl.lunch_order_rest.service.GenericCRUDService;
import uz.jl.lunch_order_rest.service.GenericService;

public interface ComplaintService extends GenericCRUDService<ComplaintCreateDto, ComplaintUpdateDto, ComplaintGetDto, Long>, GenericService<ComplaintGetDto, ComplaintDetailDto, Long> {
}
