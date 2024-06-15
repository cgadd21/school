namespace Project3.Models;

// The MinorsViewModel class is a model class that represents the data that will be displayed on the Minors page.
public class MinorsViewModel
{
  public required List<UgMinor> UgMinors { get; set; }
}

public class UgMinor
{
  public required string Name { get; set; }
  public required string Title { get; set; }
  public required string Description { get; set; }
  public required List<string> Courses { get; set; }
  public string? Note { get; set; }
}