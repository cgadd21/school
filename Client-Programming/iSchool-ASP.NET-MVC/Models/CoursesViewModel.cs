namespace Project3.Models;

// The CoursesViewModel class is a model class that represents the data that will be displayed on the Courses page.
public class CoursesViewModel
{
  public required string DegreeName { get; set; }
  public required string Semester { get; set; }
  public required List<string> Courses { get; set; }
}