package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.Follow;
import com.trendtalk.app.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IFollow extends JpaRepository<Follow, Long> {
    List<Follow> findByFollower(User follower);
    List<Follow> findByFollowing(User following);
    List<Follow> findByFollowerAndFollowing(User follower, User following);

    // Diğer özel sorgularınızı buraya ekleyebilirsiniz.
}
