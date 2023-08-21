//못 풀었음! 해답 풀이..

package BaekJoon_10825_국영수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}//이름, 국어점수, 영어점수, 수학 점수를 저장하기 위한 Student Class 생성

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();	//입력할 갯수(사람수)
        List<Student> students = new ArrayList<>();	//students라는 arrayList 생성

        for (int i = 0; i < n; i++) {		//n개의 정보 입력 받기
            String name = scanner.next();	//name만 String으로
            int kor = scanner.nextInt();	//국어점수
            int eng = scanner.nextInt();	//영어점수
            int math = scanner.nextInt();	//수학점수
            students.add(new Student(name, kor, eng, math));	//Student class 인스턴스로 만들고, 이걸 students 리스트에 넣음
        }

        // 정렬 조건에 따라 학생 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {	//s1, s2 비교
                if (s1.kor != s2.kor) {					//만약 국어 점수 다르면
                	// compare(a, b) => 만약 a가 더 크면 1, a가 더 작으면 -1, 같으면 0 반환.
                    return Integer.compare(s2.kor, s1.kor); // 국어 점수 내림차순 (내림차순의 경우 인자를 바꿔 쓰면 된다.)
                } else if (s1.eng != s2.eng) {			//(국어점수 같고) 만약 영어 점수 다르면
                    return Integer.compare(s1.eng, s2.eng); // 영어 점수 오름차순(오름차순의 경우 그대로 쓰면 됨)
                } else if (s1.math != s2.math) {		//(영어점수 같고) 만약 수학점수 다르면
                    return Integer.compare(s2.math, s1.math); // 수학 점수 내림차순
                } else {								//수학점수 같으면
                    return s1.name.compareTo(s2.name); // 이름 오름차순
                }
            }
        });

        // 정렬된 학생 정보 출력
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
