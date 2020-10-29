public class Main {

  public static void main(final String[] args) {
    final UsernameRepository repo = new UsernameRepository();

    System.out.println("Persisting username: \"" + repo.persistUsername("rightLen") + '\"');
    System.out.println("Persisting username: " + repo.persistUsername("tooLongName"));
  }
}
