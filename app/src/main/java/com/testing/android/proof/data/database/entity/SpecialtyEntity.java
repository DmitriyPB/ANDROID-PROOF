package com.testing.android.proof.data.database.entity;

import com.testing.android.proof.domain.specialtylist.Specialty;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "specialty")
public final class SpecialtyEntity implements Specialty {
    @PrimaryKey
    private int id;
    private String name;

    public SpecialtyEntity() {}

    @Ignore
    public SpecialtyEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialtyEntity)) return false;

        SpecialtyEntity that = (SpecialtyEntity) o;

        if (getId() != that.getId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "SpecialtyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
