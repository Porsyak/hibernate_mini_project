package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "category", schema = "todolist", catalog = "postgres")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Log4j2
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private long userId;
    @Basic
    @Column(name = "completed_count", updatable = false)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false )
//    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return title;
    }
}
