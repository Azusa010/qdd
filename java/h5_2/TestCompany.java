package h5_2;

import java.util.Scanner;


public class TestCompany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee e1 = new Employee();
        Employee.MonthWorker m1 = e1.new MonthWorker(sc.next(),sc.nextDouble());
        Employee.WeekWorker w1 = e1.new WeekWorker(sc.next(),sc.nextDouble());
        System.out.println(m1.toString());
        System.out.println(w1.toString());
        Employee.Company c1 = e1.new Company();
        c1.addEmployee(m1);
        c1.addEmployee(w1);
        System.out.println(c1.toString());
        
    }
}

class Employee {
    protected String name;
    public Employee(){}
    public Employee(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public double earnings(){
        return 0;
    }
    @Override
    public String toString(){
        return "姓名 "+name;
    }
    class MonthWorker extends Employee {
        private double monthSal;
        public MonthWorker(){}
        public MonthWorker(String name,double monthSal){
            super(name);
            this.monthSal = monthSal;
        }
        public void setMonthSal(double monthSal){
            this.monthSal = monthSal;
        }
        public double getMonthSal(){
            return monthSal;
        }
        @Override
        public double earnings(){
            return monthSal*12;
        }
        @Override
        public String toString(){
            return super.toString()+"\n月薪为 "+monthSal+"\n年薪为 "+earnings();
        }
    }
    
    class WeekWorker extends Employee {
        private double weekSal;
        public WeekWorker(){}
        public WeekWorker(String name,double weekSal){
            super(name);
            this.weekSal=weekSal;
        }
        public void setWeekSal(double weekSal){
            this.weekSal = weekSal;
        }
        public double getWeekSal(){
            return weekSal;
        }
        @Override
        public double earnings(){
            return weekSal*52;
        }
        @Override
        public String toString(){
            return super.toString()+"\n周薪为 "+weekSal+"\n年薪为 "+earnings();
        }
    }
    class Company extends Employee{
        private Employee[] employees;
        private int numberOfWorkers = 0;
        public Company(){
            employees = new Employee[100]; // 初始化数组
        }
        public double computeTotalSal(){
            double total=0;
            for(int i=0;i<numberOfWorkers;i++){
                total += employees[i].earnings();
            }
            return total;
        }
        public void addEmployee(Employee a){
            employees[numberOfWorkers] = a;
            numberOfWorkers++;
        }
        @Override
        public String toString(){
            return "公司年工资总额为"+computeTotalSal();
        }

    }
    
}