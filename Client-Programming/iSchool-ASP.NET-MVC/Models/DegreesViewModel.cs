namespace Project3.Models;

// The AboutViewModel class is a model class that represents the data that will be displayed on the Degrees page.
public class DegreesViewModel
{
  public required List<Undergraduate> Undergraduate { get; set; }
  public required List<Graduate> Graduate { get; set; }
}

public class Undergraduate
{
  public required string DegreeName { get; set; }
  public required string Title { get; set; }
  public required string Description { get; set; }
  public required List<string> Concentrations { get; set; }
}

public class Graduate
{
  public required string DegreeName { get; set; }
  public string? Title { get; set; }
  public string? Description { get; set; }
  public List<string>? Concentrations { get; set; }
  public List<string>? AvailableCertificates { get; set; }
}