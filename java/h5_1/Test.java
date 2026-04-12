package h5_1;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("张三", "北京", "111", "ab@126.com");
        System.out.println(p1.toString()+"\n");
        Person.Student s1 = p1.new Student("李四", "北京", "222", "cd@126.com", 1);
        System.out.println(s1+"\n");
        Person.Employee e1 = p1.new Employee("王五", "上海", "333", "ef@126.con", "二教", 6000);
        System.out.println(e1.toString()+"\n");
        Person.Employee.Faculty f1 = e1.new Faculty("赵六", "上海", "444", "hi@126.com", "二教", 5000, "9点", 3);
        System.out.println(f1.toString()+"\n");
        Person.Employee.Staff st1 = e1.new Staff("孙七", "上海", "555", "jk@126.com", "三教", 5000, "处级");
        System.out.println(st1.toString());
    }
}

class Person {
    private String name;
        protected String address;
        protected String phonenum;
        protected String email;
        public Person(String name, String address, String phonenum, String email) {
            this.name = name;
            this.address = address;
            this.phonenum = phonenum;
            this.email = email;
        }

        @Override
        public String toString() {
            return  "姓名"+name+"\n地址"+address+"\n电话号码"+phonenum+"\n电子邮件"+email;
        }
    
    class Student extends Person {
        
        private static final int bigone = 1;
        private static final int bigtwo = 2;
        private static final int bigthree = 3;
        private static final int bigfour = 4;

        private int grade;
        public Student(String name,String address,String phonenum,String email,int grade){
            super(name,address,phonenum,email);
            this.grade = grade;
            
        }
        @Override
        public String toString() {
            return super.toString() + "\n年级" + grade;
        }
        
    }
    class Employee extends Person {
        private String office;
        private int salary;

        public Employee(String name,String address,String phonenum,String email,String office,int salary){
            super(name, address, phonenum, email);
            this.office = office;
            this.salary = salary;
        } 

        @Override
        public String toString() {
            return super.toString()+"\n办公室"+office+"\n工资"+salary;
        }
        class Faculty extends Employee {
            private String workTime;
            private static final int zhujiao = 0;
            private static final int jiangshi = 1;
            private static final int fujiaoshou = 2;
            private static final int jiaoshou = 3;

            private int jibie;

            public Faculty(String name,String address,String phonenum,String email,String office,int salary,String workTime,int jibie){
                super(name, address, phonenum, email, office, salary);
                this.workTime = workTime;
                this.jibie = jibie;
            }

            @Override
            public String toString() {
                return super.toString()+"\n办公时间"+workTime+"\n职称"+jibie;
            }
        }
        class Staff extends Employee {
            private static final String keji = "科级";
            private static final String chuji = "处级";
        
            private String level;

            public Staff(String name,String address,String phonenum,String email,String office,int salary,String level){
                super(name, address, phonenum, email, office, salary);
                this.level = level;
            }

            @Override
            public String toString() {
                return super.toString()+"\n职务"+level;
            }
        }
    }


}