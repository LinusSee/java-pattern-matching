import java.util.List;
import java.util.ArrayList;


public class ComplexExampleMain {
  public static void main(final String[] args) {
    final FestivalDecider decider = new FestivalDecider();

    final String weather = "sunny";
    final String mood = "bored";
    final List<String> accompanyingFriends = new ArrayList<>();

    final boolean result = decider.willGoToCheeseFestival(weather, mood, accompanyingFriends);

    System.out.println(String.format("Will you go on a %s day in a %s mood? %s", weather, mood, result));
  }
}
