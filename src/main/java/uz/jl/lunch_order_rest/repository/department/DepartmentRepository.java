package uz.jl.lunch_order_rest.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.lunch_order_rest.entity.department.DepartmentEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import javax.transaction.Transactional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>, BaseRepository {
    @Transactional
    @Modifying
    @Query("update DepartmentEntity set name = :name, userId = :userId where id = :id")
    void updateById(@Param(value = "id") Long id, @Param(value = "name") String name, @Param(value = "userId") Long userId);

    DepartmentEntity findByName(String name);
}
