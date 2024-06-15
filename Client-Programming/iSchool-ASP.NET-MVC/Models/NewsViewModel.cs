namespace Project3.Models;

// The NewsViewModel class is a model class that represents the data that will be displayed on the News page.
public class NewsViewModel
{
  public required List<Older> Older { get; set; }
}

public class Older
{
  public required string Date { get; set; }
  public required string Title { get; set; }
  public required string Description { get; set; }

  public DateTime ToDateTime(string Date)
  {
    try
    {
      return DateTime.Parse(Date);
    }
    catch (Exception)
    {
      return DateTime.Now;
    }
  }
}
