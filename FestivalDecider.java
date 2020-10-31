import java.util.List;

public class FestivalDecider {

  /**
   * Decides whether someone liking cheese should go to a cheese festival.
   *
   * @param weather
   * @param mood
   * @param accompanyingFriends
   */
  public boolean willGoToCheeseFestival(final String weather, final String mood, final List<String> accompanyingFriends) {
    final FestivalDecision decision = FestivalDecision.decide(weather, mood, accompanyingFriends);

    switch(decision) {

      case INVALID_WEATHER:
        throw new IllegalArgumentException();

      case INVALID_MOOD:
        throw new IllegalArgumentException();

      case DONT_GO_TO_FESTIVAL:
        return false;

      case GO_TO_FESTIVAL:
        return true;
    }
    return true; // Still  needed because Java sucks
  }

  private enum FestivalDecision {
    INVALID_WEATHER,
    INVALID_MOOD,
    GO_TO_FESTIVAL,
    DONT_GO_TO_FESTIVAL;


    public static FestivalDecision decide(final String weather, final String mood, final List<String> accompanyingFriends) {
        if(!isValidWeather(weather)) {
          return INVALID_WEATHER;
        }

        if(!isValidMood(mood)) {
          return INVALID_MOOD;
        }

        final String lowerWeather = weather.toLowerCase();
        final String lowerMood = mood.toLowerCase();

        if(lowerWeather == "raining") {
          return DONT_GO_TO_FESTIVAL;
        }

        if(lowerWeather == "cloudy") {
          if(lowerMood == "good") {
            return GO_TO_FESTIVAL;
          }
          if(lowerMood == "bored" && accompanyingFriends.size() >= 2) {
            return GO_TO_FESTIVAL;
          }
        }

        if(lowerWeather == "sunny") {
          if(lowerMood == "bad" && accompanyingFriends.size() >= 1) {
            return GO_TO_FESTIVAL;
          }
          if(lowerMood == "good" || lowerMood == "bored") {
            return GO_TO_FESTIVAL;
          }
        }

        return DONT_GO_TO_FESTIVAL;
    }

    private static boolean isValidWeather(final String weather) {
      if(weather == null) {
        return false;
      }
      final String lowercaseWeather = weather.toLowerCase();

      return lowercaseWeather == "raining"
          || lowercaseWeather == "cloudy"
          || lowercaseWeather == "sunny";
    }

    private static boolean isValidMood(final String mood) {
      if(mood == null) {
        return false;
      }
      final String lowercaseMood = mood.toLowerCase();

      return lowercaseMood == "good"
          || lowercaseMood == "bad"
          || lowercaseMood == "bored";
    }
  }
}
