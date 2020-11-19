package com.example.dubbo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/19 16:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
        private long id;
        private String userName;
        private Integer age;

}
