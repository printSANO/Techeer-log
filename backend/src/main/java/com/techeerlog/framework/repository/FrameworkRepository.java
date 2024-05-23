package com.techeerlog.framework.repository;

import com.techeerlog.framework.domain.Framework;
import com.techeerlog.framework.enums.FrameworkTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FrameworkRepository extends JpaRepository<Framework, Long> {
    Optional<Framework> findByNameAndFrameworkTypeEnum(String name, FrameworkTypeEnum frameworkTypeEnum);
}
