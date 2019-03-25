package com.dawid.quilting.wrapper;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class QuiltingReportWrapper {
    @Positive(message = "Please choose operator")
    private int operatorId;
    private String date = LocalDate.now().toString();
    @PositiveOrZero
    private int pickerId;
    @PositiveOrZero
    @Max(1300)
    private Integer ma75;
    @PositiveOrZero
    @Max(1300)
    private Integer ma75o;
    @PositiveOrZero
    @Max(1300)
    private Integer ma80;
    @PositiveOrZero
    @Max(1300)
    private Integer ma80o;
    @PositiveOrZero
    @Max(1300)
    private Integer ma90;
    @PositiveOrZero
    @Max(1300)
    private Integer ma90o;
    @PositiveOrZero
    @Max(1300)
    private Integer ma140;
    @PositiveOrZero
    @Max(1300)
    private Integer ma140o;
    @PositiveOrZero
    @Max(1300)
    private Integer ma160;
    @PositiveOrZero
    @Max(1300)
    private Integer ma160o;
    @PositiveOrZero
    @Max(1300)
    private Integer mo75;
    @PositiveOrZero
    @Max(1300)
    private Integer mo75o;
    @PositiveOrZero
    @Max(1300)
    private Integer mo80;
    @PositiveOrZero
    @Max(1300)
    private Integer mo80o;
    @PositiveOrZero
    @Max(1300)
    private Integer mo90;
    @PositiveOrZero
    @Max(1300)
    private Integer mo90o;
    @PositiveOrZero
    @Max(1300)
    private Integer mo140;
    @PositiveOrZero
    @Max(1300)
    private Integer mo140o;
    @PositiveOrZero
    @Max(1300)
    private Integer mo160;
    @PositiveOrZero
    @Max(1300)
    private Integer mo160o;
    @PositiveOrZero
    private int picker2Id;
    @PositiveOrZero
    @Max(1300)
    private Integer ma752;
    @PositiveOrZero
    @Max(1300)
    private Integer ma75o2;
    @PositiveOrZero
    @Max(1300)
    private Integer ma802;
    @PositiveOrZero
    @Max(1300)
    private Integer ma80o2;
    @PositiveOrZero
    @Max(1300)
    private Integer ma902;
    @PositiveOrZero
    @Max(1300)
    private Integer ma90o2;
    @PositiveOrZero
    @Max(1300)
    private Integer ma1402;
    @PositiveOrZero
    @Max(1300)
    private Integer ma140o2;
    @PositiveOrZero
    @Max(1300)
    private Integer ma1602;
    @PositiveOrZero
    @Max(1300)
    private Integer ma160o2;
    @PositiveOrZero
    @Max(1300)
    private Integer mo752;
    @PositiveOrZero
    @Max(1300)
    private Integer mo75o2;
    @PositiveOrZero
    @Max(1300)
    private Integer mo802;
    @PositiveOrZero
    @Max(1300)
    private Integer mo80o2;
    @PositiveOrZero
    @Max(1300)
    private Integer mo902;
    @PositiveOrZero
    @Max(1300)
    private Integer mo90o2;
    @PositiveOrZero
    @Max(1300)
    private Integer mo1402;
    @PositiveOrZero
    @Max(1300)
    private Integer mo140o2;
    @PositiveOrZero
    @Max(1300)
    private Integer mo1602;
    @PositiveOrZero
    @Max(1300)
    private Integer mo160o2;
    @PositiveOrZero
    private int picker3Id;
    @PositiveOrZero
    @Max(1300)
    private Integer ma753;
    @PositiveOrZero
    @Max(1300)
    private Integer ma75o3;
    @PositiveOrZero
    @Max(1300)
    private Integer ma803;
    @PositiveOrZero
    @Max(1300)
    private Integer ma80o3;
    @PositiveOrZero
    @Max(1300)
    private Integer ma903;
    @PositiveOrZero
    @Max(1300)
    private Integer ma90o3;
    @PositiveOrZero
    @Max(1300)
    private Integer ma1403;
    @PositiveOrZero
    @Max(1300)
    private Integer ma140o3;
    @PositiveOrZero
    @Max(1300)
    private Integer ma1603;
    @PositiveOrZero
    @Max(1300)
    private Integer ma160o3;
    @PositiveOrZero
    @Max(1300)
    private Integer mo753;
    @PositiveOrZero
    @Max(1300)
    private Integer mo75o3;
    @PositiveOrZero
    @Max(1300)
    private Integer mo803;
    @PositiveOrZero
    @Max(1300)
    private Integer mo80o3;
    @PositiveOrZero
    @Max(1300)
    private Integer mo903;
    @PositiveOrZero
    @Max(1300)
    private Integer mo90o3;
    @PositiveOrZero
    @Max(1300)
    private Integer mo1403;
    @PositiveOrZero
    @Max(1300)
    private Integer mo140o3;
    @PositiveOrZero
    @Max(1300)
    private Integer mo1603;
    @PositiveOrZero
    @Max(1300)
    private Integer mo160o3;

    public int getPicker2Id() {
        return picker2Id;
    }

    public void setPicker2Id(int picker2Id) {
        this.picker2Id = picker2Id;
    }

    public Integer getMa752() {
        return ma752;
    }

    public void setMa752(Integer ma752) {
        this.ma752 = ma752;
    }

    public Integer getMa75o2() {
        return ma75o2;
    }

    public void setMa75o2(Integer ma75o2) {
        this.ma75o2 = ma75o2;
    }

    public Integer getMa802() {
        return ma802;
    }

    public void setMa802(Integer ma802) {
        this.ma802 = ma802;
    }

    public Integer getMa80o2() {
        return ma80o2;
    }

    public void setMa80o2(Integer ma80o2) {
        this.ma80o2 = ma80o2;
    }

    public Integer getMa902() {
        return ma902;
    }

    public void setMa902(Integer ma902) {
        this.ma902 = ma902;
    }

    public Integer getMa90o2() {
        return ma90o2;
    }

    public void setMa90o2(Integer ma90o2) {
        this.ma90o2 = ma90o2;
    }

    public Integer getMa1402() {
        return ma1402;
    }

    public void setMa1402(Integer ma1402) {
        this.ma1402 = ma1402;
    }

    public Integer getMa140o2() {
        return ma140o2;
    }

    public void setMa140o2(Integer ma140o2) {
        this.ma140o2 = ma140o2;
    }

    public Integer getMa1602() {
        return ma1602;
    }

    public void setMa1602(Integer ma1602) {
        this.ma1602 = ma1602;
    }

    public Integer getMa160o2() {
        return ma160o2;
    }

    public void setMa160o2(Integer ma160o2) {
        this.ma160o2 = ma160o2;
    }

    public Integer getMo752() {
        return mo752;
    }

    public void setMo752(Integer mo752) {
        this.mo752 = mo752;
    }

    public Integer getMo75o2() {
        return mo75o2;
    }

    public void setMo75o2(Integer mo75o2) {
        this.mo75o2 = mo75o2;
    }

    public Integer getMo802() {
        return mo802;
    }

    public void setMo802(Integer mo802) {
        this.mo802 = mo802;
    }

    public Integer getMo80o2() {
        return mo80o2;
    }

    public void setMo80o2(Integer mo80o2) {
        this.mo80o2 = mo80o2;
    }

    public Integer getMo902() {
        return mo902;
    }

    public void setMo902(Integer mo902) {
        this.mo902 = mo902;
    }

    public Integer getMo90o2() {
        return mo90o2;
    }

    public void setMo90o2(Integer mo90o2) {
        this.mo90o2 = mo90o2;
    }

    public Integer getMo1402() {
        return mo1402;
    }

    public void setMo1402(Integer mo1402) {
        this.mo1402 = mo1402;
    }

    public Integer getMo140o2() {
        return mo140o2;
    }

    public void setMo140o2(Integer mo140o2) {
        this.mo140o2 = mo140o2;
    }

    public Integer getMo1602() {
        return mo1602;
    }

    public void setMo1602(Integer mo1602) {
        this.mo1602 = mo1602;
    }

    public Integer getMo160o2() {
        return mo160o2;
    }

    public void setMo160o2(Integer mo160o2) {
        this.mo160o2 = mo160o2;
    }

    public int getPicker3Id() {
        return picker3Id;
    }

    public void setPicker3Id(int picker3Id) {
        this.picker3Id = picker3Id;
    }

    public Integer getMa753() {
        return ma753;
    }

    public void setMa753(Integer ma753) {
        this.ma753 = ma753;
    }

    public Integer getMa75o3() {
        return ma75o3;
    }

    public void setMa75o3(Integer ma75o3) {
        this.ma75o3 = ma75o3;
    }

    public Integer getMa803() {
        return ma803;
    }

    public void setMa803(Integer ma803) {
        this.ma803 = ma803;
    }

    public Integer getMa80o3() {
        return ma80o3;
    }

    public void setMa80o3(Integer ma80o3) {
        this.ma80o3 = ma80o3;
    }

    public Integer getMa903() {
        return ma903;
    }

    public void setMa903(Integer ma903) {
        this.ma903 = ma903;
    }

    public Integer getMa90o3() {
        return ma90o3;
    }

    public void setMa90o3(Integer ma90o3) {
        this.ma90o3 = ma90o3;
    }

    public Integer getMa1403() {
        return ma1403;
    }

    public void setMa1403(Integer ma1403) {
        this.ma1403 = ma1403;
    }

    public Integer getMa140o3() {
        return ma140o3;
    }

    public void setMa140o3(Integer ma140o3) {
        this.ma140o3 = ma140o3;
    }

    public Integer getMa1603() {
        return ma1603;
    }

    public void setMa1603(Integer ma1603) {
        this.ma1603 = ma1603;
    }

    public Integer getMa160o3() {
        return ma160o3;
    }

    public void setMa160o3(Integer ma160o3) {
        this.ma160o3 = ma160o3;
    }

    public Integer getMo753() {
        return mo753;
    }

    public void setMo753(Integer mo753) {
        this.mo753 = mo753;
    }

    public Integer getMo75o3() {
        return mo75o3;
    }

    public void setMo75o3(Integer mo75o3) {
        this.mo75o3 = mo75o3;
    }

    public Integer getMo803() {
        return mo803;
    }

    public void setMo803(Integer mo803) {
        this.mo803 = mo803;
    }

    public Integer getMo80o3() {
        return mo80o3;
    }

    public void setMo80o3(Integer mo80o3) {
        this.mo80o3 = mo80o3;
    }

    public Integer getMo903() {
        return mo903;
    }

    public void setMo903(Integer mo903) {
        this.mo903 = mo903;
    }

    public Integer getMo90o3() {
        return mo90o3;
    }

    public void setMo90o3(Integer mo90o3) {
        this.mo90o3 = mo90o3;
    }

    public Integer getMo1403() {
        return mo1403;
    }

    public void setMo1403(Integer mo1403) {
        this.mo1403 = mo1403;
    }

    public Integer getMo140o3() {
        return mo140o3;
    }

    public void setMo140o3(Integer mo140o3) {
        this.mo140o3 = mo140o3;
    }

    public Integer getMo1603() {
        return mo1603;
    }

    public void setMo1603(Integer mo1603) {
        this.mo1603 = mo1603;
    }

    public Integer getMo160o3() {
        return mo160o3;
    }

    public void setMo160o3(Integer mo160o3) {
        this.mo160o3 = mo160o3;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getPickerId() {
        return pickerId;
    }

    public void setPickerId(int pickerId) {
        this.pickerId = pickerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMa75() {
        return ma75;
    }

    public void setMa75(Integer ma75) {
        this.ma75 = ma75;
    }

    public Integer getMa75o() {
        return ma75o;
    }

    public void setMa75o(Integer ma75o) {
        this.ma75o = ma75o;
    }

    public Integer getMa80() {
        return ma80;
    }

    public void setMa80(Integer ma80) {
        this.ma80 = ma80;
    }

    public Integer getMa80o() {
        return ma80o;
    }

    public void setMa80o(Integer ma80o) {
        this.ma80o = ma80o;
    }

    public Integer getMa90() {
        return ma90;
    }

    public void setMa90(Integer ma90) {
        this.ma90 = ma90;
    }

    public Integer getMa90o() {
        return ma90o;
    }

    public void setMa90o(Integer ma90o) {
        this.ma90o = ma90o;
    }

    public Integer getMa140() {
        return ma140;
    }

    public void setMa140(Integer ma140) {
        this.ma140 = ma140;
    }

    public Integer getMa140o() {
        return ma140o;
    }

    public void setMa140o(Integer ma140o) {
        this.ma140o = ma140o;
    }

    public Integer getMa160() {
        return ma160;
    }

    public void setMa160(Integer ma160) {
        this.ma160 = ma160;
    }

    public Integer getMa160o() {
        return ma160o;
    }

    public void setMa160o(Integer ma160o) {
        this.ma160o = ma160o;
    }

    public Integer getMo75() {
        return mo75;
    }

    public void setMo75(Integer mo75) {
        this.mo75 = mo75;
    }

    public Integer getMo75o() {
        return mo75o;
    }

    public void setMo75o(Integer mo75o) {
        this.mo75o = mo75o;
    }

    public Integer getMo80() {
        return mo80;
    }

    public void setMo80(Integer mo80) {
        this.mo80 = mo80;
    }

    public Integer getMo80o() {
        return mo80o;
    }

    public void setMo80o(Integer mo80o) {
        this.mo80o = mo80o;
    }

    public Integer getMo90() {
        return mo90;
    }

    public void setMo90(Integer mo90) {
        this.mo90 = mo90;
    }

    public Integer getMo90o() {
        return mo90o;
    }

    public void setMo90o(Integer mo90o) {
        this.mo90o = mo90o;
    }

    public Integer getMo140() {
        return mo140;
    }

    public void setMo140(Integer mo140) {
        this.mo140 = mo140;
    }

    public Integer getMo140o() {
        return mo140o;
    }

    public void setMo140o(Integer mo140o) {
        this.mo140o = mo140o;
    }

    public Integer getMo160() {
        return mo160;
    }

    public void setMo160(Integer mo160) {
        this.mo160 = mo160;
    }

    public Integer getMo160o() {
        return mo160o;
    }

    public void setMo160o(Integer mo160o) {
        this.mo160o = mo160o;
    }

    @Override
    public String toString() {
        return "QuiltingReportWrapper{" +
                "operatorId=" + operatorId +
                ", date='" + date + '\'' +
                ", pickerId=" + pickerId +
                ", ma75=" + ma75 +
                ", ma75o=" + ma75o +
                ", ma80=" + ma80 +
                ", ma80o=" + ma80o +
                ", ma90=" + ma90 +
                ", ma90o=" + ma90o +
                ", ma140=" + ma140 +
                ", ma140o=" + ma140o +
                ", ma160=" + ma160 +
                ", ma160o=" + ma160o +
                ", mo75=" + mo75 +
                ", mo75o=" + mo75o +
                ", mo80=" + mo80 +
                ", mo80o=" + mo80o +
                ", mo90=" + mo90 +
                ", mo90o=" + mo90o +
                ", mo140=" + mo140 +
                ", mo140o=" + mo140o +
                ", mo160=" + mo160 +
                ", mo160o=" + mo160o +
                ", picker2Id=" + picker2Id +
                ", ma752=" + ma752 +
                ", ma75o2=" + ma75o2 +
                ", ma802=" + ma802 +
                ", ma80o2=" + ma80o2 +
                ", ma902=" + ma902 +
                ", ma90o2=" + ma90o2 +
                ", ma1402=" + ma1402 +
                ", ma140o2=" + ma140o2 +
                ", ma1602=" + ma1602 +
                ", ma160o2=" + ma160o2 +
                ", mo752=" + mo752 +
                ", mo75o2=" + mo75o2 +
                ", mo802=" + mo802 +
                ", mo80o2=" + mo80o2 +
                ", mo902=" + mo902 +
                ", mo90o2=" + mo90o2 +
                ", mo1402=" + mo1402 +
                ", mo140o2=" + mo140o2 +
                ", mo1602=" + mo1602 +
                ", mo160o2=" + mo160o2 +
                ", picker3Id=" + picker3Id +
                ", ma753=" + ma753 +
                ", ma75o3=" + ma75o3 +
                ", ma803=" + ma803 +
                ", ma80o3=" + ma80o3 +
                ", ma903=" + ma903 +
                ", ma90o3=" + ma90o3 +
                ", ma1403=" + ma1403 +
                ", ma140o3=" + ma140o3 +
                ", ma1603=" + ma1603 +
                ", ma160o3=" + ma160o3 +
                ", mo753=" + mo753 +
                ", mo75o3=" + mo75o3 +
                ", mo803=" + mo803 +
                ", mo80o3=" + mo80o3 +
                ", mo903=" + mo903 +
                ", mo90o3=" + mo90o3 +
                ", mo1403=" + mo1403 +
                ", mo140o3=" + mo140o3 +
                ", mo1603=" + mo1603 +
                ", mo160o3=" + mo160o3 +
                '}';
    }
}
