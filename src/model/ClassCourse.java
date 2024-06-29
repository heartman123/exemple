package model;

public class ClassCourse {
    private int courseId; // �γ�ID
    private String courseName; // �γ�����
    private String classTime; // �Ͽ�ʱ��
    private String teacherName; //��ʦ����
    private int teacherId; // ��ʦ���
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public ClassCourse(int courseId, String courseName, String classTime, String teacherName, int teacherId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.classTime = classTime;
		this.teacherName = teacherName;
		this.teacherId = teacherId;
		
	}
public ClassCourse() {
	
}
@Override
public String toString() {
	return courseName;
}

  
}
