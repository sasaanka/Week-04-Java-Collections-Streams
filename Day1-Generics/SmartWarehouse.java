import java.util.ArrayList;
import java.util.List;
abstract class WareHouse{
    final private String name;
    public WareHouse(String name){
        this.name=name;
    }
    public String getname(){
        return name;
    }
    public abstract String getcategory();
}
class Electronics extends WareHouse{
    public Electronics(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Electronics";
    }
}
class Groceries extends WareHouse{
    public Groceries(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Groceries";
    }
}
class Furniture extends WareHouse{
    public Furniture(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Furniture";
    }
}
class Storage <T extends WareHouse>{
    final private List<T> items=new ArrayList<>();
    public void additem(T item){
        items.add(item);
    }
    public List<T> getitem(){
        return items;
    }

    public static void diaplayitems(List<? extends WareHouse> items){
        for(WareHouse item:items){
            System.out.println(item.getcategory()+"-"+item.getname());
        }
    }
}
public class SmartWarehouse{
    public static void main(String[] args) {
        Storage<Electronics> es=new Storage<>();
        es.additem(new Electronics("Phone"));
        es.additem(new Electronics("LAptop"));

        Storage<Groceries> gl=new Storage<>();
        gl.additem(new Groceries("Salt"));
        gl.additem(new Groceries("Sugar"));

        Storage<Furniture> fs=new Storage<>();
        fs.additem(new Furniture("Table"));
        fs.additem(new Furniture("AC"));
        
        System.out.println("Displaying ware house items::");
        Storage.diaplayitems(es.getitem());
        System.out.println();
        Storage.diaplayitems(gl.getitem());
        System.out.println();
        Storage.diaplayitems(fs.getitem());
    }
}