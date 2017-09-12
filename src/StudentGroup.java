import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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
public class StudentGroup  implements StudentArrayOperation 
{
	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) 
	{
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() 
	{
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students)
	{
		// Add your implementation here
		if(students==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			this.students[i]=students[i];
		}
	}

	@Override
	public Student getStudent(int index)
	{
		// Add your implementation here
		int l;
		l=students.length;
		if(index < 0 || index>=l)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		return students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index)
	{
		// Add your implementation here
		int l;
		l=students.length;
		if(index < 0 || index > l || student==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.students[index]=student;
		}
	}

	@Override
	public void addFirst(Student student) 
	{
		int l;
		l=students.length;
		Student[] students1=new Student[l+1];
		// Add your implementation here
		if(students==null)
		{
			throw new IllegalArgumentException();
		}
	students1[0]=student;
	for(int i=1;i<l+1;i++)
	{
		students1[i]=this.students[i-1];
	}
	students=null;
	setStudents(students1);
	}

	@Override
	public void addLast(Student student)
	{
		int l;
		l=students.length;
		Student[] students1=new Student[l+1];
		// Add your implementation here
		if(students==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=1;i<l+1;i++)
		{
			students1[i]=this.students[i-1];
		}
		this.students[l]=student;
		students=null;
		setStudents(students1);
		
	}

	@Override
	public void add(Student student, int index) 
	{
		// Add your implementation here
		int l;
		l=students.length;
		Student[] students1=new Student[l+1];
		if(index<0 || index>l || students==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<index;i++)
		{
			students1[i]=this.students[i];
		}
		students1[index]=student;
		for(int j=index;j<l+1;j++)
		{
			students1[j]=this.students[j];
		}
		students=null;
		setStudents(students1);
	}

	@Override
	public void remove(int index) 
	{
		// Add your implementation here
		int l;
		l=students.length;
		Student[] students1=new Student[l-1];
		if(index<0||index>l||students==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<index;i++)
		{
			students1[i]=this.students[i];
		}
		for(int j=index;j<l+1;j++)
		{
			students1[j]=this.students[j+1];
		}
		students=null;
		setStudents(students1);
		
	}

	@Override
	public void remove(Student student) 
	{
		int l;
		l=students.length;
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				remove(i); 
			}
			else
			{
				throw new IllegalArgumentException("Student not exist");
			}
		}
	}

	@Override
	public void removeFromIndex(int index)
	{
		// Add your implementation here
		int l;
		l=students.length;
		Student[] students1=new Student[index];
		if(index<0||index>l)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<=index;i++)
		{
			students1[i]=students[i];
		}
		students=null;
		setStudents(students1);
	}

	@Override
	public void removeFromElement(Student student) 
	{
		// Add your implementation here
		int l,index = 0;
		l=students.length;
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<l;i++)
		{
			if(students[i]==student)
			{
				index=i;
			}
		}
		Student[] students1=new Student[index+1];
		for(int i=0;i<=index;i++)
		{
			students1[i]=students[i];
		}
		students=null;
		setStudents(students1);
	}

	@Override
	public void removeToIndex(int index)
	{
		// Add your implementation here
		int l;
		l=students.length;
		Student[] students1=new Student[l-index+1];
		if(index<0||index>l)
		{
			throw new IllegalArgumentException();
		}
		for(int i=index;i<l;i++)
		{
			students1[i]=students[i];
		}
		students=null;
		setStudents(students1);
	}

	@Override
	public void removeToElement(Student student)
	{
		// Add your implementation here
		int l,index=0;
		l=students.length;
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<l;i++)
		{
			if(students[i]==student)
			{
				index=i;
			}
		}
		Student[] students1=new Student[l-index+1];
		for(int i=index;i<l;i++)
		{
			students1[i]=students[i];
		}
		students=null;
		setStudents(students1);
	}

	@Override
	public void bubbleSort() 
	{
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=0;j<students.length-i;j++)
			{
				if(students[j].compareTo(students[j+1])>1)
				{
					Student temp=students[j+1];
					students[j+1]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date)
	{
		// Add your implementation here
		ArrayList<Student> al=new ArrayList<Student>();
		if(date==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
			{
				al.add(students[i]);
			}
		}
		 Student[] students1=(Student[]) al.toArray();
		return students1;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate)
	{
		// Add your implementation here
		ArrayList<Student> al=new ArrayList<Student>();
		if(firstDate==null || lastDate==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(firstDate)>0 && students[i].getBirthDate().compareTo(lastDate)<0 )	
			{
				al.add(students[i]);
			}
		}
		Student[] students1=(Student[]) al.toArray();
		return students1;
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
	public int getCurrentAgeByDate(int indexOfStudent)
	{
		// Add your implementation here
		int age;
		Date d=new Date();
		for(int i=0;i<students.length;i++)
		{
			
		}
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age)
	{
		// Add your implementation here
		int n;
		ArrayList<Student> al=new ArrayList<Student>();
		for(int i=0;i<students.length;i++)
		{
			
		}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() 
	{
		// Add your implementation here
		
		return null;
	}

	@Override
	public Student getNextStudent(Student student)
	{
		int index=0;
		// Add your implementation here
		if(student==null)
		{
		throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				index=i;
			}
		}
		return students[index+1];
	}
}
