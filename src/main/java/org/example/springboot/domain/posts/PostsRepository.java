package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, // JpaRepository <Entity 클래스, PK 타입>
                                                        Long> {
}
