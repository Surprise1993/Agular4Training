package cn.com.transcosmos.training.domain;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_pass
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    private String userPass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_name
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.dept_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    private Integer deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.del_flag
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    private String delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_id
     *
     * @return the value of tbl_user.user_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_id
     *
     * @param userId the value for tbl_user.user_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_pass
     *
     * @return the value of tbl_user.user_pass
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_pass
     *
     * @param userPass the value for tbl_user.user_pass
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_name
     *
     * @return the value of tbl_user.user_name
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_name
     *
     * @param userName the value for tbl_user.user_name
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.dept_id
     *
     * @return the value of tbl_user.dept_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.dept_id
     *
     * @param deptId the value for tbl_user.dept_id
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.del_flag
     *
     * @return the value of tbl_user.del_flag
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.del_flag
     *
     * @param delFlag the value for tbl_user.del_flag
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}