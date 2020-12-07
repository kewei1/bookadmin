package cn.kewei.bookadmin.pojo;

import lombok.Data;
import java.io.Serializable;



@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String code;



}