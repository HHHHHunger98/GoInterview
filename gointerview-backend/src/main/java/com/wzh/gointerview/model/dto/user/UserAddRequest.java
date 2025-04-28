package com.wzh.gointerview.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * Add new user request
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 * 
 */
@Data
public class UserAddRequest implements Serializable {

    /**
     * User name
     */
    private String userName;

    /**
     * User account
     */
    private String userAccount;

    /**
     * User avatar
     */
    private String userAvatar;

    /**
     * User role: user, admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}