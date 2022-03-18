package uz.jl.lunch_order_rest.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.lunch_order_rest.entity.user.UserEntity;
import uz.jl.lunch_order_rest.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, Long>, BaseRepository {
    UserEntity findByUsername(String username);

    UserEntity findByCode(UUID code);

    @Transactional
    @Modifying
    @Query("update UserEntity set departmentId = :department_id where id = :user_id")
    void updateDepartmentIdById(@Param(value = "department_id") Long departmentId, @Param(value = "user_id") Long userId);

    @Transactional
    @Modifying
    @Query("update UserEntity set username = :username, fullName = :fullName, phone = :phone, position = :position, departmentId = :departmentId where id = :id")
    void updateById(@Param(value = "id") Long id, @Param(value = "username") String username, @Param(value = "fullName") String fullName, @Param(value = "phone") String phone, @Param(value = "position") String position, @Param(value = "departmentId") Long departmentId);

    UserEntity findByPhone(@Param(value = "phone") String phone);

    UserEntity findByChatId(Integer chatId);
}
