package com.example.board.dto;

public class PasswordChangeLogDto {
    private int change_log_id;
    private int user_no;
    private String changed_password;
    private String created_at;
    private String user_id;

    public int getChange_log_id() {
        return change_log_id;
    }

    public void setChange_log_id(int change_log_id) {
        this.change_log_id = change_log_id;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getChanged_password() {
        return changed_password;
    }

    public void setChanged_password(String changed_password) {
        this.changed_password = changed_password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
