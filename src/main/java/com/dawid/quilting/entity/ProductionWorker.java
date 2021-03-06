package com.dawid.quilting.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "production_worker")
public class ProductionWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "is_operator")
    private Boolean operator;
    @Column(name = "is_picker")
    private Boolean picker;
    @OneToMany(mappedBy = "productionWorker", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<QuiltedIndex> quiltedIndex;
    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<QuiltingData> quiltingData;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getOperator() {
        return operator;
    }

    public void setOperator(Boolean operator) {
        this.operator = operator;
    }

    public Boolean getPicker() {
        return picker;
    }

    public void setPicker(Boolean picker) {
        this.picker = picker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<QuiltedIndex> getQuiltedIndex() {
        return quiltedIndex;
    }

    public void setQuiltedIndex(List<QuiltedIndex> quiltedIndex) {
        this.quiltedIndex = quiltedIndex;
    }

    public List<QuiltingData> getQuiltingData() {
        return quiltingData;
    }

    public void setQuiltingData(List<QuiltingData> quiltingData) {
        this.quiltingData = quiltingData;
    }

    @Override
    public String toString() {
        return "ProductionWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
