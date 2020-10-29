public class UsernameRepository {

  public String persistUsername(final String username) {
    final UsernameValidationResult validationResult = UsernameValidationResult.validate(username);

    switch (validationResult) {

      case SHORTER_THAN_MINLENGTH:
        throw new IllegalArgumentException();

      case LONGER_THAN_MAXLENGTH:
        throw new IllegalArgumentException();

      case CORRECT_USERNAME:
        return username;
    }
    return null; // Still needed because java sucks
  }

  enum UsernameValidationResult {
    SHORTER_THAN_MINLENGTH,
    LONGER_THAN_MAXLENGTH,
    CORRECT_USERNAME;

    public static UsernameValidationResult validate(final String username) {
      if(username.length() < 3) {
        return SHORTER_THAN_MINLENGTH;
      } else if(username.length() > 8) {
        return LONGER_THAN_MAXLENGTH;
      } else {
        return CORRECT_USERNAME;
      }
    }
  }
}
