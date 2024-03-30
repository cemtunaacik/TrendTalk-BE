package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IUser extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);

    // Diğer özel sorgularınızı buraya ekleyebilirsiniz.
}
