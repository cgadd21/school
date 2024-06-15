namespace Project3.Models;

// The ResearchViewModel class is a model class that represents the data that will be displayed on the Research page.
public class ResearchViewModel
{
  public required List<ByInterestArea> ByInterestArea { get; set; }
}

public class ByInterestArea
{
  public required string AreaName { get; set; }
  public required List<string> Citations { get; set; }
}