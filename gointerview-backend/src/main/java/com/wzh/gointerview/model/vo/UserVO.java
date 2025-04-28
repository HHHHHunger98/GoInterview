package com.wzh.gointerview.model.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * User view object class
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Data
public class UserVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * user name
     */
    private String userName;

    /**
     * third party login id
     */
    private String subId;

    /**
     * user avatar
     */
    private String userAvatar;

    /**
     * user profile
     */
    private String userProfile;

    /**
     * user role: user/admin/ban
     */
    private String userRole;

    /**
     * created time
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}