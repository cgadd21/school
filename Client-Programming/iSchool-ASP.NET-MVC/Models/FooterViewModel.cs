namespace Project3.Models;

// The FooterViewModel class is a model class that represents the data that will be displayed on the Footer Partial View.
public class FooterViewModel
{
  public required Social Social { get; set; }
  public required List<QuickLink> QuickLinks { get; set; }
  public required Copyright Copyright { get; set; }
  public required string News { get; set; }
}

public class Social
{
  public required string Title { get; set; }
  public required string Tweet { get; set; }
  public required string By { get; set; }
  public required string Twitter { get; set; }
  public required string Facebook { get; set; }
}

public class QuickLink
{
  public required string Title { get; set; }
  public required string Href { get; set; }
}

public class Copyright
{
  public required string Title { get; set; }
  public required string Html { get; set; }
}