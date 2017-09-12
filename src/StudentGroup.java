

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}


	public Student[] getStudents() {
		
		if(this.students == null)
		{
			throw new IllegalArgumentException();
		}
		return this.students;
		// Add your implementation here
		
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		else{
			for(int i = 0;i < students.length;i++){
				this.students[i].setAvgMark(students[i].getAvgMark());
				this.students[i].setBirthDate(students[i].getBirthDate());
				this.students[i].setFullName(students[i].getFullName());
				this.students[i].setId(students[i].getId());
			}
		}
		
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index >= students.length || index < 0){
			throw new IllegalArgumentException();
		}
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int i) {
		// Add your implementation here
		if(student == null || i >= students.length || i < 0){
			throw new IllegalArgumentException();
		}
		this.students[i].setAvgMark(student.getAvgMark());
		this.students[i].setBirthDate(student.getBirthDate());
		this.students[i].setFullName(student.getFullName());
		this.students[i].setId(student.getId());		
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
			
		}
		
		else{
			Student[] temp = new Student[students.length + 1];
			temp[0] = student;
			int j = 0;
			for(int i = 1;i < students.length;i++){
				temp[i] = students[j];
				j++;
			}
			students = null;
			setStudents(temp);		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
			if(student == null){
				throw new IllegalArgumentException();
				
			}
			
			else{
				Student[] temp = new Student[students.length + 1];
				temp[students.length] = student;
				for(int i = 0;i < students.length-1;i++){
					temp[i] = students[i];
				}
				students = null;
				setStudents(temp);			}
	}

	@Override
	public void add(Student student, int index) {

		if(student == null || index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		
		else{
			Student[] temp = new Student[students.length + 1];
			temp[students.length] = student;
			int ind = 0;
			for(int i = 0;i < index ; i++){
				temp[ind] = students[i];
				ind++;
			}
			temp[ind] = student;ind++;
			for(int i = index+1;i < students.length;i++){
				temp[ind] = students[i];
				ind++;
			}
			students = null;
			setStudents(temp);		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here

		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] temp = new Student[students.length - 1];
			int ind = 0;
			for(int i = 0;i < index ; i++){
				temp[ind] = students[i];
				ind++;
			}
			for(int i = index+1;i < students.length;i++){
				temp[ind] = students[i];
				ind++;
			}
			students = null;
			setStudents(temp);		}
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		else{
			int prev_length = students.length;
			for(int i = 0;i < students.length;i++){
				if(students[i] == student){
					remove(i);
					break;
				}
			}
			if(students.length == prev_length){
				throw new IllegalArgumentException("Student not exist");
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] temp = new Student[index + 1];
			for(int i = 0;i < index+1;i++){
				temp[i] = students[i];
			}
			students = null; 
			setStudents(temp);
			
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		else{
			int index = 0;
			for(int i = 0;i < students.length;i++){
				if(students[i] == student){
					index = i;
				}
			}
			removeFromIndex(index);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		else{
			Student[] temp = new Student[students.length - index];
			int k = 0;
			for(int i = index;i < students.length;i++){
				temp[k] = students[i];k++;
			}
			students = null; 
			setStudents(temp);
		}
	}

	@Override
	public void removeToElement(Student student) {
		
		if(student == null){
			throw new IllegalArgumentException();
		}
		else{
			int index = 0;
			for(int i = 0;i < students.length;i++){
				if(students[i] == student){
					index = i;
				}
			}
			removeToIndex(index);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int i , j;
		for(i = 0;i < students.length-1;i++){
			for(j = 0;j< students.length-i;j++){
				if(students[j].compareTo(students[j+1]) > 0){
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		int count = 0;
		for(int i =0;i < students.length;i++){
			if(students[i].getBirthDate().equals(date) || students[i].getBirthDate().before(date)){
				count++;
			}
		}
		Student[] temp = new Student[count];
		int index = 0;
		for(int i =0;i < students.length;i++){
			if(students[i].getBirthDate().equals(date) || students[i].getBirthDate().before(date)){
				temp[index] = students[i];
				index++;
			}
		}
		return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException();
		}
		int count = 0;
		for(int i =0;i < students.length;i++){
			if(firstDate.before(students[i].getBirthDate()) && students[i].getBirthDate().before(lastDate)){
				count++;
			}
		}
		Student[] temp = new Student[count];
		int index = 0;
		for(int i =0;i < students.length;i++){
			if(firstDate.before(students[i].getBirthDate()) && students[i].getBirthDate().before(lastDate)){
				temp[index] = students[i];
				index++;
			}
		}
		return temp;
	}

	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date == null){
			throw new IllegalArgumentException();
		}
		int count = 0;
		for(int i =0;i < students.length;i++){
			if(getDifferenceDays(students[i].getBirthDate(),date) == days){
				count++;
			}
		}
		Student[] temp = new Student[count];
		int index = 0;
		for(int i =0;i < students.length;i++){
			if(getDifferenceDays(students[i].getBirthDate(),date) == days){
				temp[index] = students[i];
				index++;
			}
		}
		
		return temp;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent == 0){
			throw  new IllegalArgumentException();
		}
		
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}