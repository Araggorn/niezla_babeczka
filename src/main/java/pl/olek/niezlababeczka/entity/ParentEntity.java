package pl.olek.niezlababeczka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Data
@AllArgsConstructor
@SuperBuilder
public abstract class ParentEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    protected UUID id;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime createTime;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updateTime;

    private boolean deleted;

    public ParentEntity(UUID id) {
        this.id = id;
    }

    protected ParentEntity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParentEntity)) {
            return false;
        }
        ParentEntity that = (ParentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
