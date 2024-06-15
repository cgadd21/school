namespace Project3.Models;

// The PeopleViewModel class is a model class that represents the data that will be displayed on the People page.
public class PeopleViewModel
{
  public required string Title { get; set; }
  public required string SubTitle { get; set; }
  public required List<Person> Faculty { get; set; }
  public required List<Person> Staff { get; set; }
}

public class Person
{
  public required string Username { get; set; }
  public required string Name { get; set; }
  public string? Tagline { get; set; }
  public required string ImagePath { get; set; }
  public string? Title { get; set; }
  public string? InterestArea { get; set; }
  public string? Office { get; set; }
  public string? Website { get; set; }
  public string? Phone { get; set; }
  public string? Email { get; set; }
  public string? Twitter { get; set; }
  public string? Facebook { get; set; }
}