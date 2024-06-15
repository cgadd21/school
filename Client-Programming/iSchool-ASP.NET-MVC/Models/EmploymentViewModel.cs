namespace Project3.Models;

// The EmploymentViewModel class is a model class that represents the data that will be displayed on the Employment page.
public class EmploymentViewModel
{
  public required Introduction Introduction { get; set; }
  public required DegreeStatistics DegreeStatistics { get; set; }
  public required Employers Employers { get; set; }
  public required Careers Careers { get; set; }
  public required CoopTable CoopTable { get; set; }
  public required EmploymentTable EmploymentTable { get; set; }
}

public class Introduction
{
  public required string Title { get; set; }
  public required List<Content> Content { get; set; }
}

public class Content
{
  public required string Title { get; set; }
  public required string Description { get; set; }
}

public class DegreeStatistics
{
  public required string Title { get; set; }
  public required List<Statistics> Statistics { get; set; }
}

public class Statistics
{
  public required string Value { get; set; }
  public required string Description { get; set; }
}

public class Employers
{
  public required string Title { get; set; }
  public required List<string> EmployerNames { get; set; }
}

public class Careers
{
  public required string Title { get; set; }
  public required List<string> CareerNames { get; set; }
}

public class CoopTable
{
  public required string Title { get; set; }
  public required List<CoopInformation> CoopInformation { get; set; }
}

public class CoopInformation
{
  public required string Employer { get; set; }
  public required string Degree { get; set; }
  public required string City { get; set; }
  public required string Term { get; set; }
}

public class EmploymentTable
{
  public required string Title { get; set; }
  public required List<ProfessionalEmploymentInformation> ProfessionalEmploymentInformation { get; set; }
}

public class ProfessionalEmploymentInformation
{
  public string? Employer { get; set; }
  public required string Degree { get; set; }
  public required string City { get; set; }
  public string? Title { get; set; }
  public DateTime StartDate { get; set; }
}