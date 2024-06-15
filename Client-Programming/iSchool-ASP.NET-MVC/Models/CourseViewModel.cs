namespace Project3.Models;

// The CourseViewModel class is a model class that represents the data that will be displayed on the Course page.
public class CourseViewModel
{
  public required string CourseID { get; set; }
  public required string Title { get; set; }
  public required string Description { get; set; }

  public string ReplaceAmp(string text) => text.Replace("&amp;", "&");
}