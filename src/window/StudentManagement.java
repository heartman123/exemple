package window;

import javax.swing.*;

import model.StudentBaseInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement extends JFrame {
//    private List<student> studentList;
    private JTextArea studentTextArea;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public StudentManagement() {
        setTitle("ѧ����Ϣ������");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        studentList = new ArrayList<>();
//        studentList.add(new Student("����", "101", "��", 20));
//        studentList.add(new Student("����", "102", "Ů", 21));

        JPanel topPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("����");
        addButton = new JButton("���ѧ��");
        editButton = new JButton("�༭ѧ����Ϣ");
        deleteButton = new JButton("ɾ��ѧ��");

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);
        topPanel.add(editButton);
        topPanel.add(deleteButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudents();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        add(topPanel, BorderLayout.NORTH);

        studentTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(studentTextArea);
        add(scrollPane, BorderLayout.CENTER);

        displayStudents();
    }

    private void displayStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append("����: ").append(student.getName()).append(", ѧ��: ").append(student.getId())
                    .append(", �Ա�: ").append(student.getGender()).append(", ����: ").append(student.getAge()).append("\n");
        }
        studentTextArea.setText(sb.toString());
    }

    private void searchStudents() {
        String keyword = searchField.getText();
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().contains(keyword) || student.getId().contains(keyword)) {
                result.add(student);
            }
        }
        studentList = result;
        displayStudents();
    	StudentBaseInfo Student = new StudentBaseInfo();
    	Student.setName();
    	
    }

    private void addStudent() {
        // ������������ѧ�����߼�
        JOptionPane.showMessageDialog(this, "���ѧ��������δʵ��");
    }

    private void editStudent() {
        // ��������ӱ༭ѧ����Ϣ���߼�
        JOptionPane.showMessageDialog(this, "�༭ѧ����Ϣ������δʵ��");
    }

    private void deleteStudent() {
        // ���������ɾ��ѧ�����߼�
        JOptionPane.showMessageDialog(this, "ɾ��ѧ��������δʵ��");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagement().setVisible(true);
            }
        });
    }
}

//class Student {
//    private String name;
//    private String id;
//    private String gender;
//    private int age;
//
//    public Student(String name, String id, String gender, int age) {
//        this.name = name;
//        this.id = id;
//        this.gender = gender;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
}
