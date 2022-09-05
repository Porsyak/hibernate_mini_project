package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "stat", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Stat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "completed_total",updatable = false)
    private Long completedTotal;
    @Basic
    @Column(name = "uncompleted_total", updatable = false)
    private Long uncompletedTotal;
    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return id == stat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
