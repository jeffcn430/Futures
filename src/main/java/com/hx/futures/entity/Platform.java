package com.hx.futures.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table
public class Platform implements Serializable {
    /**
     * 平台id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 平台名称
     */
    private String name;

    public static void main(String[] args) {
        double init = 1751;
        double cash = 0;
        double add = 0;
        for (int i = 1; i <= 240; i++) {
            if (init / 10 < 1000) {
                add = 1000;
            } else {
                add = init * 0.1;
            }

            add = init * 0.1;

            System.out.println((int) add);

            if (init > 10311) {
                if (cash > 10311) {
                    if (init < 100000) {
                        init += add * 0.5;
                        cash += add * 0.5;
                    } else if (init > 200000) {
                        init += add * 0.1;
                        cash += add * 0.9;
                    } else {
                        init += add * 0.3;
                        cash += add * 0.7;
                    }
                } else {
                    cash += add;
                }
            } else {
                init += add;
            }

            if (i % 20 == 0) {
                System.out.println((int) init + "=============" + (int) cash);
            }
        }

    }
}
