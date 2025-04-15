import java.util.ArrayList;
import java.util.List;
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Paneer Tikka");
        meals.add("Vegetable Biryani");
        return meals;
    }
}
class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Tofu Stir Fry");
        meals.add("Quinoa Salad");
        return meals;
    }
}
class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Grilled Chicken");
        meals.add("Avocado Salad");
        return meals;
    }
}
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Egg Whites");
        meals.add("Protein Smoothie");
        return meals;
    }
}
class Meal<T extends MealPlan> {
    final private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }
    public T getPlan() {
        return plan;
    }
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        System.out.println("Meal Type: " + meal.getPlan().getMealType());
        System.out.println("Meals Included:");
        for (String dish : meal.getPlan().getMeals()) {
            System.out.println(" - " + dish);
        }
        System.out.println("Personalized meal plan generated successfully!\n");
    }
}
public class MealPlangen{
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> hpMeal = new Meal<>(new HighProteinMeal());


        Meal.generatePlan(vegMeal);
        Meal.generatePlan(veganMeal);
        Meal.generatePlan(ketoMeal);
        Meal.generatePlan(hpMeal);
    }
}
