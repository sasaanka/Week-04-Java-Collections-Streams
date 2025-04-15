import java.util.List;
abstract class JobRole{
    final private String name;
    public JobRole(String name){
        this.name=name;
    }
    public String getname(){
        return name;
    }
    public abstract String getRole();
    public abstract boolean isEligibile();
}
class SoftwareEngineer extends JobRole{
    final private int yearsofexp;
    public SoftwareEngineer(String name,int yearsofexp){
        super(name);
        this.yearsofexp=yearsofexp;
    }
    @Override
    public String getRole(){
        return "Software";
    }
    @Override
    public boolean isEligibile(){
        return yearsofexp>=2;
    }
}
class DataScientist extends JobRole{
    final private int publications;
    public DataScientist(String name,int publications){
        super(name);
        this.publications=publications;
    }
    @Override
    public String getRole(){
        return "Data-scientist";
    }
    @Override
    public boolean isEligibile(){
        return publications>=1;
    }
}
class ProductManager extends JobRole {
    final private boolean hasMBA;

    public ProductManager(String candidateName, boolean hasMBA) {
        super(candidateName);
        this.hasMBA = hasMBA;
    }

    @Override
    public String getRole() {
        return "Product Manager";
    }
    @Override
    public boolean isEligibile() {
        return hasMBA;
    }
}
class Resume<T extends JobRole> {
    final private T role;
    public Resume(T role){
        this.role=role;
    }
    public T getrole(){
        return role;
    }
    public void display(){
        System.out.println("Resume: "+role.getname()+" Role: "+role.getRole());
        System.out.println("Is eligible: "+role.isEligibile());
    }
    public static void allresume(List<? extends JobRole> roles){
        for(JobRole role:roles){
            System.out.println(role);
        }
    }
}
public class ResumeScreening{
    public static void main(String[] args) {
        Resume<SoftwareEngineer> se=new Resume<>(new SoftwareEngineer("Sasanka",4));
        Resume<DataScientist> ds=new Resume<>(new DataScientist("Bharath",6));
        Resume<ProductManager> pm=new Resume<>(new ProductManager("Abhinaya",true));
        se.display();
        ds.display();
        pm.display();
    }
}