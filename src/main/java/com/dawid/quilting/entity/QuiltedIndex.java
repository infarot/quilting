package com.dawid.quilting.entity;

import javax.persistence.*;

@Entity
@Table(name = "quilted_index")
public class QuiltedIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "rejected_quantity")
    private int rejectedQuantity;
    @ManyToOne
    @JoinColumn(name = "production_worker_id")
    private ProductionWorker productionWorker;
    @ManyToOne
    @JoinColumn(name = "quilting_data_id")
    private QuiltingData quiltingData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRejectedQuantity() {
        return rejectedQuantity;
    }

    public void setRejectedQuantity(int rejectedQuantity) {
        this.rejectedQuantity = rejectedQuantity;
    }

    public ProductionWorker getProductionWorker() {
        return productionWorker;
    }

    public void setProductionWorker(ProductionWorker productionWorker) {
        this.productionWorker = productionWorker;
    }

    public QuiltingData getQuiltingData() {
        return quiltingData;
    }

    public void setQuiltingData(QuiltingData quiltingData) {
        this.quiltingData = quiltingData;
    }
}
