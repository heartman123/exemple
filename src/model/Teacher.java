package model;

public class Teacher {
    private int teacherId; // ��ʦ���
    private String teacherName; // �û���
    private String password; // ����

    public Teacher(int teacherId, String teacherName, String password) {
        this.teacherId = teacherId;
        this.teacherName =teacherName;
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getteacherName() {
        return teacherName;
    }

    public void setUsername(String username) {
        this.teacherName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Teacher() {
    	
    }
}
