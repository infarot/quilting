package com.dawid.quilting.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "production_worker")
public class ProductionWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "productionWorker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuiltedIndex> quiltedIndex;
    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuiltingData> quiltingData;

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
}
