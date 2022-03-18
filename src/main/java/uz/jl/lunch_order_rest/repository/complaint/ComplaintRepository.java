package uz.jl.lunch_order_rest.repository.complaint;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jl.lunch_order_rest.entity.complaint.ComplaintEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long>, BaseRepository {
    List<ComplaintEntity> findAllByUserId(Long userId);
}
