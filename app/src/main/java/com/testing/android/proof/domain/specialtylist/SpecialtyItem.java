package com.testing.android.proof.domain.specialtylist;

public final class SpecialtyItem {
    private final int id;
    private final String name;

    public SpecialtyItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialtyItem)) return false;

        SpecialtyItem specialtyItem = (SpecialtyItem) o;

        if (getId() != specialtyItem.getId()) return false;
        return getName() != null ? getName().equals(specialtyItem.getName()) : specialtyItem.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SpecialtyItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
