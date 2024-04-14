package consolelog.project.repository;

import consolelog.project.domain.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.id < :lastProjectId ORDER BY p.id DESC")
    Slice<Project> findProjectByIdIsLessThanOrderByIdDesc(@Param("lastProjectId") Long maxId, Pageable pageable);

    default Slice<Project> findNextPage(Pageable pageable) {
        long lastPrjectId = findMaxId() + 1;
        if (lastPrjectId == 1) {
            return null; // No data available
        }
        return findProjectByIdIsLessThanOrderByIdDesc(lastPrjectId, pageable);
    }

    @Query("SELECT MAX(p.id) FROM Project p")
    Long findMaxId();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE post SET like_count = like_count + 1 WHERE post_id = :postId", nativeQuery = true)
    void increaseLikeCount(@Param("postId") Long postId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE post SET like_count = like_count - 1 WHERE post_id = :postId", nativeQuery = true)
    void decreaseLikeCount(@Param("postId") Long postId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE project SET view_count = view_count + 1 WHERE project_id = :projectId", nativeQuery = true)
    void updateViewCount(@Param("projectId") Long projectId);
}
